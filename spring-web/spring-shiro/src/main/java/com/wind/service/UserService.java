package com.wind.service;

import com.wind.entity.User;

/**
 * @package com.wind.service
 * @className UserService
 * @note user service处理
 * @author wind
 * @date 2018/6/3 19:44
 */
public interface UserService {

    /**
     * 通过username查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);
}
