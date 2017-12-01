package com.wind.service.impl;

import com.wind.entity.User;
import com.wind.service.UserService;

/**
 * @author com.wind
 */
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(String name) {

        User u = new User();
        u.setUsername(name);
        u.setPassword("123456");
        return u;
    }
}
