package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/cache/")
public class cacheController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate template;

    @RequestMapping(value = "saveInfo")
    public String saveCacheData(String message) {
        if (template.hasKey("message")) {
            template.delete("message");
            return "key已被删除";
        } else {
            template.opsForValue().append("message", message);
            return "使用Redis保存数据";
        }
    }

    @RequestMapping(value = "queryInfo")
    public String getValue() {
        if (!template.hasKey("message")) {
            return "Redis缓存中没有要查询的数据";
        } else {
            return "从缓存中获取的数据" + template.opsForValue().get("message").toString();
        }
    }

}

