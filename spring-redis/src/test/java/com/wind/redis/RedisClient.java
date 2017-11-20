package com.wind.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedisClient {

    //redis对String进行操作
    public static void redisString(Jedis jedis){
        System.out.println(jedis.get("str"));
    }
    //redis对List进行操作
    public static void redisList(Jedis jedis){
        List<String> list=jedis.lrange("list", 0, 10);
        for(String ele:list){
            System.out.println(ele);
        }
    }
    //redis对Map进行操作
    public static void redisMap(Jedis jedis){
        Set<String> keys=jedis.hkeys("hash");
        List<String> values=jedis.hvals("hash");
        Map<String, String> maps=jedis.hgetAll("hash");
        System.out.println(keys);
        System.out.println(values);
        System.out.println(maps);
    }
    //redis对Set进行操作
    public static void redisSet(Jedis jedis){
        Set<String> sets=jedis.smembers("set");
        System.out.println(sets);
    }
    public static void main(String[] args) {
        Jedis jedis=new Jedis("localhost",  6379);
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        System.out.println("Server is running: "+jedis.ping());
        System.out.println(jedis.keys("*"));
        redisMap(jedis);
    }

}
