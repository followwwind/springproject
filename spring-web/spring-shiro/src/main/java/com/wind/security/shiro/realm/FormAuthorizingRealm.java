package com.wind.security.shiro.realm;

import com.wind.entity.User;
import com.wind.security.shiro.Principal;
import com.wind.security.shiro.UserToken;
import com.wind.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @package com.wind.security.shiro.realm
 * @className FormAuthorizingRealm
 * @note shiro权限校验
 * @author wind
 * @date 2018/6/3 15:47
 */
public class FormAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权验证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Principal principal = (Principal) getAvailablePrincipal(principalCollection);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    /**
     * 登陆验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UserToken token = (UserToken) authenticationToken;

        String username = token.getUsername();

        User user = userService.findByUsername(username);
        if (user != null) {
            String userId = user.getUserId();
            return new SimpleAuthenticationInfo(new Principal(userId, username), user.getPassword(), getName());
        }

        return null;
    }
}
