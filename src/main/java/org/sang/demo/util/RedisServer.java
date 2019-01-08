package org.sang.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by CJF on 2018-12-19.
 */
@Component
public class RedisServer {
    @Autowired
    RedisTemplate redisTemplate;

    public Object get(String key){
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    public void set(String key, String value) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value);
    }

    public void set(String key, String value, Long expireTime) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value);
        redisTemplate.expire(key, expireTime, TimeUnit.MILLISECONDS);
    }

    public void remove (String key) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        redisTemplate.delete(key);
    }
}
