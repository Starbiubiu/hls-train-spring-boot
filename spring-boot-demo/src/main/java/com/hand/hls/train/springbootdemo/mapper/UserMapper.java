package com.hand.hls.train.springbootdemo.mapper;

import com.hand.hls.train.springbootdemo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * <p>
 * 用户 mapper接口
 * </p>
 *
 * @author xinhao.fan@hand-china.com 2018/06/07 13:48
 */
@Repository
public interface UserMapper {


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
     * @return int
     */
    int createUser(User user);

    /**
     * <p>更新用户<p/>
     *
     * @param user 用户
     * @return int
     */
    int updateUser(User user);

    /**
     * <p>删除用户<p/>
     *
     * @param userId 用户id
     * @return int
     */
    int deleteUser(Integer userId);


}
