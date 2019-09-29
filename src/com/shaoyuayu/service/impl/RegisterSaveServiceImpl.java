package com.shaoyuayu.service.impl;

import com.shaoyuayu.dao.UserDao;
import com.shaoyuayu.dao.impl.UserDaoImpl;
import com.shaoyuayu.entity.User;
import com.shaoyuayu.service.MailService;
import com.shaoyuayu.service.RegisterSaveService;
import com.shaoyuayu.util.DESUtil;

public class RegisterSaveServiceImpl implements RegisterSaveService {
    /**
     * 根据用户的账号和验证码进行校验
     *  1.成功
     *  2.失败
     * @param mail
     * @param token
     * @return
     */
    @Override
    public int addUser(String mail, String token) {
        /**
         * 1，根据mail和用户的token查询表
         * token对象
         *  有，验证有效时间
         *      合法：保存用户信息到数据库中
         *      不合法：返回用户验证码过期
         *  没有，返回失败
         *
         */
        MailService mailService = new MailServiceImpl();
        int ro = mailService.queryTokenLegal(mail,0,token);
        if (ro==1){
            //创建用户
            User user = new User();
            user.setMail(mail);
            //对用户的账号加密
            user.setUser_id(DESUtil.DESEncript(mail,"shaoyayu"));
            UserDao userDao = new UserDaoImpl();
            //查询用户是不是已经被注册了
            if (userDao.queryUser(mail)!=null){
                //用户已经被注册
                return 2;
            }
            //保存用户信息
            if (userDao.saveUser(user).equals("OK")){
                //注册成功
                return 1;
            }else {
                //注册失败
                return 0;
            }
        }else {
            if (ro==0){
                //验证码超时
                return -2;
            }else {
                //验证码错误
                return -1;
            }
        }
    }
}
