package com.shaoyuayu.service.impl;

import com.shaoyuayu.dao.UserDao;
import com.shaoyuayu.dao.impl.UserDaoImpl;
import com.shaoyuayu.entity.User;
import com.shaoyuayu.service.LoginService;
import com.shaoyuayu.service.MailService;

public class LonginServiceIpml implements LoginService {
    /**
     * 用户登录模块
     *  判断用户在用户表中知不是存在
     *  判断验证码是不是超时 判断验证码是不是正确
     *  全部正确返回一个用户
     * @param mail;
     * @param token
     * @return
     */
    @Override
    public User queryUser(String mail, String token) {
        User user = new User();
        MailService mailService = new MailServiceImpl();
        //查找用户是不是存在
        UserDao userDao = new UserDaoImpl();
        user = userDao.queryUser(mail);
        if (user==null){
            //查找过后没有当前的用户
            user.setId(-1);
            return user;
        }
        //查询验证码是不是正确的
        int t = mailService.queryTokenLegal(mail,1,token);
        if (t==-1){
            //验证码错误
            user.setId(-2);
            return user;
        }else if (t==0){
            //验证码超时
            user.setId(-3);
            return user;
        }
        return user;
    }
}
