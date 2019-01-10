package com.lori.redisdemo.controller;

import com.lori.redisdemo.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("/redis/string/insert")
    public void insertString(){
        redisTemplate.opsForValue().set(Constants.REDIS_KEY,"first_redis-test");
    }

    @GetMapping("/redis/string/delete")
    public void deleteString(){
        boolean existFlag = redisTemplate.hasKey(Constants.REDIS_KEY);
        if (existFlag){
            redisTemplate.delete(Constants.REDIS_KEY);
        }
    }
}
