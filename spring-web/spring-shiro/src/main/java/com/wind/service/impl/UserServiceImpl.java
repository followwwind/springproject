package com.wind.service.impl;

import com.wind.entity.User;
import com.wind.service.UserService;
import com.wind.util.IdGenUtil;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findByUsername(String username) {
        User user = new User();
        user.setUserId(IdGenUtil.getUUID());
        user.setUsername(username);
        user.setPassword("123456");
        return user;
    }
}
