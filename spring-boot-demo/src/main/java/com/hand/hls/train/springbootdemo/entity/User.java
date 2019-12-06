package com.hand.hls.train.springbootdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * <p>
 * 用户实体类
 * </p>
 *
 * @author xinhao.fan@hand-china.com 2018/06/07 13:48
 */
@ApiModel(value = "用户实体")
public class User{

    @ApiModelProperty(name = "userId",notes="用户的Id")
    private Integer userId; //用户id
    @ApiModelProperty(name = "userName",notes = "用户姓名")
    @NotBlank(message = "username can not be null")
    private String userName; //用户姓名
//    @Range(min = 1,max = 200,message = "年龄最小1岁，最大200岁 ")
    @ApiModelProperty(name = "age",notes = "用户年龄")
    @Max(value = 200,message = "age max 200")
    private Integer userAge; //用户年龄
    @ApiModelProperty(name = "createTime",notes = "用户创建时间")
    private Date createTime; //用户创建时间

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
