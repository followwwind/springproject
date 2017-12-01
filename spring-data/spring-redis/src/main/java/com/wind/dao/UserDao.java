package com.wind.dao;

import com.wind.entity.User;

import java.util.List;

/**
 * @author com.wind
 */
public interface UserDao {

    /**
     * 新增
     * @param user
     * @return
     */
    boolean add(User user);

    /**
     * 批量新增 使用pipeline方式
     * @param list
     * @return
     */
    boolean add(List<User> list);

    /**
     * 删除
     * @param key
     */
    void delete(String key);

    /**
     * 删除多个
     * @param keys
     */
    void delete(List<String> keys);

    /**
     * 修改
     * @param user
     * @return
     */
    boolean update(User user);

    /**
     * 通过key获取
     * @param keyId
     * @return
     */
    User get(String keyId);

}
