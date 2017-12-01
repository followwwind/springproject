package com.wind.redis;

import redis.clients.jedis.Jedis;

/**
 * Redis client测试
 * @author com.wind
 */
public class ClientTest {

    public static void connect(){
        Jedis jedis = new Jedis("127.0.0.1", 6479);
        System.out.println(jedis.ping());
    }

    public static void main(String[] args) {
        connect();
    }
}
