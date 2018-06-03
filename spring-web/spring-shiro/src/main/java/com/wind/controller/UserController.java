package com.wind.controller;

import com.wind.entity.User;
import com.wind.security.shiro.Principal;
import com.wind.security.shiro.UserToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package com.wind.controller
 * @className UserController
 * @note  user接口
 * @author wind
 * @date 2018/6/3 14:32
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    /**
     * 登陆接口
     * @param user
     * @return
     */
    @PostMapping(value = "login")
    public String login(@RequestBody User user){

        Subject subject = SecurityUtils.getSubject();
        String username = user.getUsername();
        String password = user.getPassword();
        UserToken userToken = new UserToken(username, password);

        try {
            subject.login(userToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        Principal principal = (Principal)subject.getPrincipal();
        return "success";
    }
}
