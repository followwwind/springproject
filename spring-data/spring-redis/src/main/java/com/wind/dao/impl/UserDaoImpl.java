package com.wind.dao.impl;

import com.wind.dao.UserDao;
import com.wind.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * @author com.wind
 */
public class UserDaoImpl implements UserDao {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean add(User user) {
        redisTemplate.execute((RedisConnection conn) -> {
            if(user != null){
                byte[] key = user.getId() != null ? user.getId().getBytes() : new byte[]{};
                byte[] value = user.getName() != null ? user.getName().getBytes() : new byte[]{};
                conn.rPush(key, value);
            }
            return true;
        });
        return false;
    }

    @Override
    public boolean add(List<User> list) {
        return false;
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public void delete(List<String> keys) {

    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User get(String keyId) {
        return null;
    }
}
