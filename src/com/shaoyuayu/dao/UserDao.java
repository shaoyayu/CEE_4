package com.shaoyuayu.dao;

import com.shaoyuayu.entity.User;

public interface UserDao {

    /**
     * 保存当前用户
     * @param user
     * @return
     */
    public String saveUser(User user);

    /**
     * 查询用户
     * @param main
     * @return
     */
    public User queryUser(String main);
}
