package com.hand.hls.train.springbootdemo.service;

import com.hand.hls.train.springbootdemo.entity.User;
import java.util.List;

/**
 * <p>
 * 用户 service接口
 * </p>
 *
 * @author xinhao.fan@hand-china.com 2018/06/07 13:48
 */
public interface IUserService {

    /**
     * <p>查找所有用户<p/>
     *
     * @return List<User>
     */
    List<User> getUsers();

    /**
     * <p>根据id查找某个用户<p/>
     *
     * @param userId 用户id
     * @return User
     */
    User getUser(Integer userId);

    /**
     * <p>添加用户<p/>
     *
     * @param user 用户
     * @return User
     */
    User createUser(User user);

    /**
     * <p>更新用户<p/>
     *
     * @param user 用户
     * @return int
     */
    User updateUser(User user);

    /**
     * <p>删除用户<p/>
     *
     * @param user 用户id
     * @return int
     */
    int deleteUser(User user);


}
