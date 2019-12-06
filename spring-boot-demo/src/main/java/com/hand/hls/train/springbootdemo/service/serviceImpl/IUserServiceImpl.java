package com.hand.hls.train.springbootdemo.service.serviceImpl;

import com.hand.hls.train.springbootdemo.cache.RedisCache;
import com.hand.hls.train.springbootdemo.entity.User;
import com.hand.hls.train.springbootdemo.mapper.UserMapper;
import com.hand.hls.train.springbootdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * <p>
 * 用户 service实现类
 * </p>
 *
 * @author xinhao.fan@hand-china.com 2018/06/07 13:48
 */
@Service
public class IUserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;

    private RedisCache redisCache;

    public IUserServiceImpl(RedisCache redisCache) {
        this.redisCache = redisCache;
        redisCache.init();
    }

    //数据库操作失败
    private final int FAILNUMBER = 0;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User getUser(Integer userId) {
       User user = redisCache.getValue(userId.toString());
        if(null != user){
            return user;
        }
        return userMapper.getUser(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User createUser(User user) {
        int i = userMapper.createUser(user);
        if(i == FAILNUMBER){
            return null;
        }
        redisCache.setValue(user);
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User updateUser(User user) {
        int i = userMapper.createUser(user);
        if(i == FAILNUMBER){
            return null;
        }
        redisCache.setValue(user);
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteUser(User user) {
        redisCache.remove(user);
        return userMapper.deleteUser(user.getUserId());
    }
}
