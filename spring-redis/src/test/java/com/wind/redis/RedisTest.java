package com.wind.redis;

import com.wind.dao.UserDao;
import com.wind.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class RedisTest {

    // inject the template as ListOperations
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, String> template;

    @Autowired
    private UserDao userDao;


    @Test
    public void testSet(){
        /*template.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                byte [] key = "tempkey".getBytes();
                byte[] value = "tempvalue".getBytes();
                connection.set(key, value);
                return true;
            }
        });

        RedisCallback<Boolean> redisCallback = conn -> {
            byte [] key = "tempkey".getBytes();
            byte[] value = "tempvalue".getBytes();
            return conn.set(key, value);
        };

        template.execute(redisCallback);*/
        template.execute((RedisConnection conn) -> {
            byte [] key = "tempkey".getBytes();
            byte[] value = "tempvalue".getBytes();
            return conn.set(key, value);
        });

    }

    @Test
    public void testAdd(){
        User user = new User("111", "wind", "123");
        userDao.add(user);
    }
}
