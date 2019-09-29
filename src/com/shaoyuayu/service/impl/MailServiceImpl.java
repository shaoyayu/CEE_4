package com.shaoyuayu.service.impl;

import com.root.util.Log4jTest;
import com.shaoyuayu.dao.MailDao;
import com.shaoyuayu.dao.impl.MailDaoImpl;
import com.shaoyuayu.entity.Token;
import com.shaoyuayu.service.MailService;
import com.shaoyuayu.util.DateUtil;
import com.shaoyuayu.util.MailUtil;
import org.apache.log4j.Logger;
import org.junit.Test;


public class MailServiceImpl implements MailService {
    private static Logger logger = Logger.getLogger(Log4jTest.class);
    /**
     * 发送验证码
     * 1、判断验证码是否合法
     * 2、发送验证码
     * 3、发送成功-->>将Mail和verification保存到数据库中
     * @param mail
     * @return
     */
    //创建MailUtil对象
    private MailUtil mailUtil = new MailUtil();
    @Override
    public String sendVerificationCode(String mail,int type) {
        if (mailUtil.verifyMail(mail)){
            /**
             * 根据注册类型拿取对于短消息内容
             */
            String context = "";
            String to= "";
            if (type==0){
                //获取注册模板
                context = mailUtil.getMailNoteTemplate(type);
                to = mailUtil.getToken();
                context = String.format(context,mail,to);
            }else if (type==1){
                //获取登录模板
                context = mailUtil.getMailNoteTemplate(type);
                to = mailUtil.getToken();
                context = String.format(context,mail,to);
            }else {
            }
            /**
             * 查询
             */
            Token token = new Token();
            token.setMail(mail);
            token.setBegin(DateUtil.getTime());
            token.setToken(to);
            token.setType(type);
            token.setUseful_life(90);
            try {
                mailUtil.sendToken(mail,context,token);
            }catch (Exception e){
                return null;
            }
            preserveVerification(token);
            return "验证码发送至你的邮箱";
        }else {
            return "邮箱输入错误";
        }
    }

    /**
     * 保存验证码到数据库中
     * @param token
     * @return
     */
    @Override
    public String preserveVerification(Token token) {
        /**
         * 先查询数据库中是不是含有用户
         *      当前类型的用户验证码，
         *      要是有，修改验证码，
         *      没有，添加验证码
         */
        MailDao mailDao = new MailDaoImpl();
        Token token1 = mailDao.queryVerification(token);
        if (token1 == null){
            //添加数据
            System.out.println(mailDao.preserveVerification(token)+"添加数据");
        }else {
            //修改
            System.out.println(mailDao.revampVerification(token1.getId(),token1.getType(),token)+"修改数据");
        }
       return "添加";
    }

    /**
     * 查询验证码是不是正确和过时
     * @param mail
     * @param type
     * @param token
     * @return
     */
    @Override
    public int queryTokenLegal(String mail, int type, String token) {
        Token token1 = new Token();
        token1.setMail(mail);
        token1.setType(type);
        MailDao mailDao = new MailDaoImpl();
        Token token2 = mailDao.queryVerification(token1);
        if (token2==null){
            //验证码错误
            return -1;
        }
        if (!token2.getToken().equals(token)){
            //验证码错误
            return -1;
        }
        //验证验证码是不是超时的
        if (DateUtil.overtimeCode(token2.getBegin(),DateUtil.getTime(),90)){
            return 0;
        }
        return 1;
    }

    /**
     * 测试类
     */
    @Test
    public void test(){
        System.out.println(this.sendVerificationCode("2416746596@qq.com",0));
    }
}
