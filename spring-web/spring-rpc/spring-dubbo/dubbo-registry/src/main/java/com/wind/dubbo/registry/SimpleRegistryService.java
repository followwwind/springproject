package com.wind.dubbo.registry;

/*
 * Copyright 1999-2011 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.ConcurrentHashSet;
import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.common.utils.UrlUtils;
import com.alibaba.dubbo.registry.NotifyListener;
import com.alibaba.dubbo.registry.RegistryService;
import com.alibaba.dubbo.registry.support.AbstractRegistry;
import com.alibaba.dubbo.rpc.RpcContext;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * SimpleRegistryService
 *
 * @author wind
 */
public class SimpleRegistryService extends AbstractRegistry {

    private final static Logger logger = LoggerFactory.getLogger(SimpleRegistryService.class);
    private final ConcurrentMap<String, Set<URL>> remoteRegistered = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, ConcurrentMap<URL, Set<NotifyListener>>> remoteSubscribed = new ConcurrentHashMap<>();

    public SimpleRegistryService() {
        super(new URL("dubbo", NetUtils.getLocalHost(), 0, RegistryService.class.getName(), "file", "N/A"));
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public List<URL> lookup(URL url) {
        List<URL> urls = new ArrayList<>();
        for (URL u : getRegistered()) {
            if (UrlUtils.isMatch(url, u)) {
                urls.add(u);
            }
        }
        return urls;
    }

    @Override
    public void register(URL url) {
        String client = RpcContext.getContext().getRemoteAddressString();
        Set<URL> urls = remoteRegistered.get(client);
        if (urls == null) {
            remoteRegistered.putIfAbsent(client, new ConcurrentHashSet<>());
            urls = remoteRegistered.get(client);
        }
        urls.add(url);
        super.register(url);
        registered(url);
    }

    @Override
    public void unregister(URL url) {
        String client = RpcContext.getContext().getRemoteAddressString();
        Set<URL> urls = remoteRegistered.get(client);
        if (urls != null && urls.size() > 0) {
            urls.remove(url);
        }
        super.unregister(url);
        unregistered(url);
    }

    @Override
    public void subscribe(URL url, NotifyListener listener) {
        if (getUrl().getPort() == 0) {
            URL registryUrl = RpcContext.getContext().getUrl();
            if (registryUrl != null && registryUrl.getPort() > 0
                    && RegistryService.class.getName().equals(registryUrl.getPath())) {
                super.setUrl(registryUrl);
                super.register(registryUrl);
            }
        }
        String client = RpcContext.getContext().getRemoteAddressString();
        ConcurrentMap<URL, Set<NotifyListener>> clientListeners = remoteSubscribed.get(client);
        if (clientListeners == null) {
            remoteSubscribed.putIfAbsent(client, new ConcurrentHashMap<>(16));
            clientListeners = remoteSubscribed.get(client);
        }
        Set<NotifyListener> listeners = clientListeners.get(url);
        if (listeners == null) {
            clientListeners.putIfAbsent(url, new ConcurrentHashSet<>());
            listeners = clientListeners.get(url);
        }
        listeners.add(listener);
        super.subscribe(url, listener);
        subscribed(url, listener);
    }

    @Override
    public void unsubscribe(URL url, NotifyListener listener) {
        if (!Constants.ANY_VALUE.equals(url.getServiceInterface())
                && url.getParameter(Constants.REGISTER_KEY, true)) {
            unregister(url);
        }
        String client = RpcContext.getContext().getRemoteAddressString();
        Map<URL, Set<NotifyListener>> clientListeners = remoteSubscribed.get(client);
        if (clientListeners != null && clientListeners.size() > 0) {
            Set<NotifyListener> listeners = clientListeners.get(url);
            if (listeners != null && listeners.size() > 0) {
                listeners.remove(listener);
            }
        }
    }

    protected void registered(URL url) {
        notifyListener(url);
    }

    protected void unregistered(URL url) {
        notifyListener(url);
    }

    private void notifyListener(URL url){
        for (Map.Entry<URL, Set<NotifyListener>> entry : getSubscribed().entrySet()) {
            URL key = entry.getKey();
            if (UrlUtils.isMatch(key, url)) {
                List<URL> list = lookup(key);
                for (NotifyListener listener : entry.getValue()) {
                    listener.notify(list);
                }
            }
        }
    }

    protected void subscribed(final URL url, final NotifyListener listener) {
        if (Constants.ANY_VALUE.equals(url.getServiceInterface())) {
            new Thread(() -> {
                Map<String, List<URL>> map = new HashMap<>(16);
                for (URL u : getRegistered()) {
                    if (UrlUtils.isMatch(url, u)) {
                        String service = u.getServiceInterface();
                        List<URL> list = map.get(service);
                        if (list == null) {
                            list = new ArrayList<>();
                            map.put(service, list);
                        }
                        list.add(u);
                    }
                }
                for (List<URL> list : map.values()) {
                    try {
                        listener.notify(list);
                    } catch (Throwable e) {
                        logger.warn("Discard to notify " + url.getServiceKey() + " to listener " + listener);
                    }
                }
            }, "DubboMonitorNotifier").start();
        } else {
            List<URL> list = lookup(url);
            try {
                listener.notify(list);
            } catch (Throwable e) {
                logger.warn("Discard to notify " + url.getServiceKey() + " to listener " + listener);
            }
        }
    }

    public void disconnect() {
        String client = RpcContext.getContext().getRemoteAddressString();
        if (logger.isInfoEnabled()) {
            logger.info("Disconnected " + client);
        }
        Set<URL> urls = remoteRegistered.get(client);
        if (urls != null && urls.size() > 0) {
            for (URL url : urls) {
                unregister(url);
            }
        }
        Map<URL, Set<NotifyListener>> listeners = remoteSubscribed.get(client);
        if (listeners != null && listeners.size() > 0) {
            for (Map.Entry<URL, Set<NotifyListener>> entry : listeners.entrySet()) {
                URL url = entry.getKey();
                for (NotifyListener listener : entry.getValue()) {
                    unsubscribe(url, listener);
                }
            }
        }
    }

}
