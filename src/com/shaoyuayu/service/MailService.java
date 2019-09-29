package com.shaoyuayu.service;

import com.shaoyuayu.entity.Token;

public interface MailService {
    /**
     * 发送验证码
     * @param mail
     * @return
     */
    public String sendVerificationCode(String mail,int key);

    /**
     * 保存验证码
     * 1、每一个用户只能有两种类型的验证码：
     *          1、登录    2、注册
     *     1-->>
     *      查询用户是不是含有当前的验证码类型，
     *      有--->>>修改
     *      没有--->>>添加
     *        （不得重合）
     * @param token
     * @return
     */
    public String preserveVerification(Token token);

    /**
     * 根据用户的电子邮箱，查询类型，和验证码
     * @param mail
     * @param type
     * @param token
     * @return
     */
    public int queryTokenLegal(String mail,int type,String token);

}
