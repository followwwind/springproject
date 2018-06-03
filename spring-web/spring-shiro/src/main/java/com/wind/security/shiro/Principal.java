package com.wind.security.shiro;

import java.io.Serializable;

/**
 * @package com.wind.security.shiro
 * @className Principal
 * @note 授权用户信息
 * @author wind
 * @date 2018/6/3 18:08
 */
public class Principal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String username;

    public Principal(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
