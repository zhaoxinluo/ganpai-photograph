package com.ganpai.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@Component
public class RedisClient {
    @Autowired
    private JedisPool jedisPool;

    /**
     * 普通set方法
     * @param key
     * @param value
     * @throws Exception
     */
    public void set(String key, String value) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }


    /**
     * 普通set方法 并设置超时时间
     * @param key
     * @param seconds
     * @param value
     * @throws Exception
     */
    public void setex(String key,int seconds, String value) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.setex(key,seconds, value);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }

    /**
     * 普通get方法
     * @param key
     * @return
     * @throws Exception
     */
    public String get(String key) throws Exception  {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }

    /**
     * hset  hash set  定义hash范围, 设置key  对应 value
     * @param hash
     * @param key
     * @param value
     */
    public void hset(String hash,String key,String value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hset(hash,key,value);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }

    /**
     * hget 从hash 范围 获取 对应 key  的value
     * @param hash
     * @param key
     * @return
     * @throws Exception
     */
    public String hget(String hash,String key) throws Exception  {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hget(hash,key);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }

    /***
     * 设置key超时时间
     * @param key
     * @param seconds
     * @return
     */
    public  Long  expire(String key , int seconds){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.expire(key,seconds);
        } finally {
            //返还到连接池
            jedis.close();
        }
    }

}
