package com.hand.hls.train.springbootdemo.cache;

import com.hand.hls.train.springbootdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * <p>
 * redisCache 接口
 * </p>
 *
 * @author xinhao.fan@hand-china.com 2019/12/5 21:01
 */
public interface RedisCache {


    /**
     * <p>初始化  读取缓存数据<p/>
     *
     * @return List
     */
    List<User> init();

    /**
     * <p>根据键的名字获取对应value的值<p/>
     *
     * @param key 键的名字
     * @return T
     */
    User getValue(String key);

    /**
     * <p>设值value<p/>
     *
     * @param key 键的名字
     */
    void setValue(User key);

    /**
     * <p>根据条件删除缓存内数据<p/>
     *
     * @param user 用户
     */
    void remove(User user);

    /**
     * <p>清空缓存<p/>
     */
    void clear();

    /**
     * <p>书信缓存  清空缓存后重新读取<p/>
     */
    void reflush();


    /**
     * <p>查询所有用户信息<p/>
     * @return List<User>
     */
    List<User> getUsers();

}
