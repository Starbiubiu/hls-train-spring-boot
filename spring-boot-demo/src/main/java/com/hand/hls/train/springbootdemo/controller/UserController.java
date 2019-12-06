package com.hand.hls.train.springbootdemo.controller;

import com.hand.hls.train.springbootdemo.entity.User;
import com.hand.hls.train.springbootdemo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


/**
 * <p>
 * 用户 controller
 * </p>
 *
 * @author xinhao.fan@hand-china.com 2018/06/07 13:48
 */
@Api(value = "用户",tags = {"用户操作"})
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;

    @ApiOperation("查询所有用户")
    @GetMapping
    public List<User> getUsers(){

        return userService.getUsers();
    }

    @ApiOperation("根据用户id查找用户")
    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable("userId") Integer userId){
        return userService.getUser(userId);
    }

    @ApiOperation("插入新用户")
    @PostMapping
    public User createUser(@RequestBody @Valid User user){
        return userService.createUser(user);
    }

    @ApiOperation("更新用户信息")
    @PutMapping
    public User updateUser(@RequestBody @Valid User user){
        return  userService.updateUser(user);
    }

    @ApiOperation("根据用户id删除用户")
    @DeleteMapping(value = "/s{userId}")
    public int deleteUser(@RequestBody @Valid User user){
        return userService.deleteUser(user);
    }




}
