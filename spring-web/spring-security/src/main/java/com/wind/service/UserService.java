package com.wind.service;

import com.wind.entity.User;

public interface UserService {

    /**
     * 根据userId获取用户信息
     * @param userId
     * @return
     */
    User findByUserName(String userId);
}
