package com.wind.security.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @package com.wind.security.shiro
 * @className UserToken
 * @note 用户和密码（包含验证码）令牌类
 * @author wind
 * @date 2018/6/3 19:26
 */
public class UserToken extends UsernamePasswordToken {


    public UserToken(String username, String password) {
        super(username, password);
    }
}
