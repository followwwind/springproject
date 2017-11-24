package com.wind.redis;

import org.junit.Test;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class RedisTest extends AbstractJUnit4SpringContextTests {

    @Resource(name = "connectionFactory")
    private JedisConnectionFactory connectionFactory;

    @Resource(name = "redisTemplate")
    private  StringRedisTemplate redisTemplate;

    @Test
    public void testPing(){
        RedisConnection redisConnection = connectionFactory.getConnection();
        String ping = redisConnection.ping();
        System.out.println(ping);
    }

    @Test
    public void testStr(){
        /*redisTemplate.execute(new RedisCallback<Boolean>() {
            @Nullable
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {

                return null;
            }
        });*/

        redisTemplate.execute((RedisConnection con) -> {
            byte[] key = "str".getBytes();
            byte[] value = "hello world".getBytes();
            con.set(key, value);
            return true;
        });


    }

    @Test
    public void testList(){
        redisTemplate.execute((RedisConnection con) -> {
            byte[] key = "list".getBytes();
            byte[] ele1 = "java".getBytes();
            byte[] ele2 = "c".getBytes();
            con.rPush(key, ele1, ele2);
            return true;
        });
    }

}
