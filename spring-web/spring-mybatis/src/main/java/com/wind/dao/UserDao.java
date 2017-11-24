package com.wind.dao;

import com.wind.entity.User;

import java.util.List;

/**
 * 
 */
public interface UserDao {

    /**
     *
     */
    void insert(User user);

    /**
     * 
     */
    User selectByPrimaryKey(String userId);

    /**
     * 
     */
    List<User> selectByCondition(User user);

    /**
     * 
     */
    int deleteByPrimaryKey(String userId);

    /**
     * 
     */
    int updateByPrimaryKeySelective(User user);

    /**
     * 
     */
    int countByCondition(User user);

}

