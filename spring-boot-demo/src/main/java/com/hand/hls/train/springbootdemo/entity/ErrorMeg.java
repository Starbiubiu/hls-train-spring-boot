package com.hand.hls.train.springbootdemo.entity;

import org.springframework.validation.BindingResult;

/**
 * <p>
 * 错误信息实体类
 * </p>
 *
 * @author xinhao.fan@hand-china.com 2018/06/07 13:48
 */
public class ErrorMeg {

    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public void setMessage(BindingResult message) {
        this.message = message.getAllErrors().get(0).getDefaultMessage();
    }
}
