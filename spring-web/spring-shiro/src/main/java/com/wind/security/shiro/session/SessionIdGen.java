package com.wind.security.shiro.session;


import com.wind.util.IdGenUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @package com.wind.security.shiro.session
 * @className SessionIdGen
 * @note shiro session id生成
 * @author wind
 * @date 2018/6/3 15:20
 */
@Service
@Lazy(false)
public class SessionIdGen implements SessionIdGenerator {
    @Override
    public Serializable generateId(Session session) {
        return IdGenUtil.getUUID();
    }
}
