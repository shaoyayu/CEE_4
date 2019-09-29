package com.shaoyuayu.service;

public interface RegisterSaveService {

    /**
     * 把用户输入的账号和验证码去数据库校验
     *  正确就添加用户
     *  失败返回
     * @param mail
     * @param token
     * @return
     */
    public int addUser(String mail,String token);

}
