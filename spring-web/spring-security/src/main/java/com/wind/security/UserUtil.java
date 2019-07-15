package com.wind.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserUtil {

    /**
     * 获取当前用户信息
     * @return
     */
    public static UserDetails getCurrentUser() {
        UserDetails user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = null;
        if (authentication != null) {
            principal = authentication.getPrincipal();
        }
        if (principal instanceof UserDetails) {
            user = (UserDetails) principal;
        }
        return user;
    }
}
