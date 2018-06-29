package com.springboot.swgger.redis;

import com.springboot.swgger.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

public class RedisTest {
    private Jedis jedis;

    @Test
    public void test(){
        //连接redis服务器(在这里是连接本地的)
        jedis = new Jedis("127.0.0.1", 6379);
        //权限认证
//        jedis.auth("cuihai");
        System.out.println("连接服务成功");

        System.out.println(""+jedis.get("name"));
    }
}
