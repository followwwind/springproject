package com.wind.dao.impl;

import com.wind.dao.UserDao;
import com.wind.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    protected RedisTemplate<String, User> redisTemplate;

    /**
     * 新增
     * @param user
     * @return
     */
    @Override
    public boolean add(User user) {
        boolean flag = false;
        if(redisTemplate != null){
            flag = redisTemplate.execute(callback(Arrays.asList(user), "insert"));
        }
        return flag;
    }




    /**
     * 批量新增 使用pipeline方式
     *@param list
     *@return
     */
    @Override
    public boolean add(List<User> list) {
        boolean flag = false;
        if(redisTemplate != null){
            flag = redisTemplate.execute(callback(list, "insert"), false, true);
        }
        return flag;
    }

    /**
     * 删除
     * @param key
     */
    @Override
    public void delete(String key) {
        List<String> list = new ArrayList<String>();
        list.add(key);
        delete(list);
    }

    /**
     * 删除多个
     * @param keys
     */
    @Override
    public void delete(List<String> keys) {
        redisTemplate.delete(keys);
    }


    private RedisCallback<Boolean> callback(List<User> users, String mode){
        return conn -> {
            if(redisTemplate != null && users != null){
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                if(serializer != null){
                    users.forEach(user -> {
                        byte[] key  = serializer.serialize(user.getId());
                        byte[] name = serializer.serialize(user.getName());
                        if("insert".equals(mode)){
                            conn.setNX(key, name);
                        }else if("update".equals(mode)){
                            conn.set(key, name);
                        }
                    });
                }
            }
            return true;
        };
    }



    /**
     * 修改
     * @param user
     * @return
     */
    @Override
    public boolean update(User user) {
        String key = user.getId();
        if (get(key) == null) {
            throw new NullPointerException("数据行不存在, key = " + key);
        }
        boolean result = redisTemplate.execute(callback(Arrays.asList(user), "update"));
        return result;
    }

    /**
     * 通过key获取
     * <br>------------------------------<br>
     * @param keyId
     * @return
     */
    @Override
    public User get(String keyId) {
        User result = redisTemplate.execute((RedisConnection conn) -> {
            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            byte[] key = serializer.serialize(keyId);
            byte[] value = conn.get(key);
            if (value == null) {
                return null;
            }
            String name = serializer.deserialize(value);
            return new User(keyId, name, null);
        });
        return result;
    }
}
