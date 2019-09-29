package com.shaoyuayu.service;

import com.shaoyuayu.entity.User;

public interface LoginService {

    /**
     * 用户登录模块
     * @param mail
     * @param token
     * @return
     */
    public User queryUser(String mail,String token);

}
