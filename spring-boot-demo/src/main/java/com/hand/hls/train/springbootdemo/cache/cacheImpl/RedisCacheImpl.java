package com.hand.hls.train.springbootdemo.cache.cacheImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hand.hls.train.springbootdemo.cache.RedisCache;
import com.hand.hls.train.springbootdemo.entity.User;
import com.hand.hls.train.springbootdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * redisCache实现类
 * </p>
 *
 * @author xinhao.fan@hand-china.com 2019/12/5 22:41
 */
@Component
public class RedisCacheImpl implements RedisCache {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> init() {
        List<User> list = userMapper.getUsers();
        if(null != list){
            for (User user:list) {
                setValue(user);
            }
        }
        return list;
    }

    @Override
    public User getValue(String key) {
        String str = (String) redisTemplate.opsForHash().get("redis_db",key);
        try {
            if (str != null) {
                return new ObjectMapper().readValue(str, User.class);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setValue(User user) {
        if (user.getUserId() != null) {
            try {
                redisTemplate.opsForHash().put("redis_db", user.getUserId().toString(), new ObjectMapper().writeValueAsString(user));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remove(User user) {
        redisTemplate.opsForHash().delete("redis_db", user.getUserId().toString());
    }

    @Override
    public void clear() {
        redisTemplate.delete("redis_db");
    }

    @Override
    public void reflush() {
        clear();
        init();
    }

    @Override
    public List<User> getUsers() {
        clear();
        return init();
    }
}
