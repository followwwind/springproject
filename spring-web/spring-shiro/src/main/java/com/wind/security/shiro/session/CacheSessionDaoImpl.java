package com.wind.security.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;

/**
 * 系统安全认证实现类
 * @author com.wind
 */
public class CacheSessionDaoImpl extends EnterpriseCacheSessionDAO implements SessionDaoImpl {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public CacheSessionDaoImpl() {
        super();
    }

    @Override
    protected void doUpdate(Session session) {
        if (session == null || session.getId() == null) {
            return;
        }

        super.doUpdate(session);
    }

    @Override
    protected void doDelete(Session session) {
        if (session == null || session.getId() == null) {
            return;
        }

        super.doDelete(session);
        logger.debug("delete {} ", session.getId());
    }

    @Override
    protected Serializable doCreate(Session session) {

        super.doCreate(session);
        return session.getId();
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return super.doReadSession(sessionId);
    }

    @Override
    public Session readSession(Serializable sessionId) throws UnknownSessionException {
        try{
            Session s = null;


            Session session = super.readSession(sessionId);

            return session;
        }catch (UnknownSessionException e) {
            return null;
        }
    }

}
