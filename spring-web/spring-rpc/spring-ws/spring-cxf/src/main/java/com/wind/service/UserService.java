package com.wind.service;

import com.wind.entity.User;

import javax.jws.WebService;

/**
 * @author com.wind
 */
@WebService
public interface UserService {

    /**
     * 
     * @param name
     * @return
     */
    User getUser(String name);
}
