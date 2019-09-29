package com.shaoyuayu.dao;

import com.shaoyuayu.entity.Token;

public interface MailDao {
    /**
     * 保存验证码到数据库中
     * @param token
     * @return
     */
    public String preserveVerification(Token token);

    /**
     * 删除无效的验证码
     * @param token
     * @return
     */
    public String deleteVerification(Token token);

    /**
     * 查找当前下面是不是含有用户的验证码
     *
     * @param token
     * @return
     */
    public Token queryVerification(Token token);

    /**
     * 根据用户的id
     * 修改用户的token
     * @param id
     * @param token
     * @return
     */
    public String revampVerification(int id,int type,Token token);
}
