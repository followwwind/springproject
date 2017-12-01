package com.wind.security.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Set;

/**
 * @author com.wind
 */
public class SessionCacheManager implements CacheManager {
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return new SessionCache<K, V>(s);
    }

    /**
     * SESSION缓存管理类
     */
    public class SessionCache<K, V> implements Cache<K, V> {

        private Logger logger = LoggerFactory.getLogger(getClass());

        private String cacheKeyName = null;

        public SessionCache(String cacheKeyName) {
            this.cacheKeyName = cacheKeyName;
        }

        @Override
        public V get(K k) throws CacheException {
            return null;
        }

        @Override
        public V put(K k, V v) throws CacheException {
            return null;
        }

        @Override
        public V remove(K k) throws CacheException {
            return null;
        }

        @Override
        public void clear() throws CacheException {

        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Set<K> keys() {
            return null;
        }

        @Override
        public Collection<V> values() {
            return null;
        }
    }
}
