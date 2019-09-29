package com.shaoyuayu.dao.impl;

import com.shaoyuayu.dao.MailDao;
import com.shaoyuayu.entity.Token;
import com.shaoyuayu.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MailDaoImpl implements MailDao {
    //获取template
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 保存验证码到数据库中
     * @param token
     * @return
     */
    @Override
    public String preserveVerification(Token token) {
        System.out.println(token.toString());
        String sql = "INSERT INTO user_token(token,mail,useful_life,begin,type)" +
                " VALUES(?,?,?,?,?);";
        if (template.update(sql,token.getToken(),token.getMail(),token.getUseful_life(),token.getBegin(),token.getType())==1){
            return "OK";
        }else {
            return "NO";
        }

    }

    /**
     * 删除验证码
     * @param token
     * @return
     */
    @Override
    public String deleteVerification(Token token) {
        return null;
    }

    /**
     *根据用户的token查询用户表下面
     * 是不是含有数据，有就返回
     * @param token
     * @return
     */
    @Override
    public Token queryVerification(Token token) {
        String sql = "SELECT * FROM user_token WHERE mail = ? AND type = ?;";
        List<Token> tokens = template.query(sql,new BeanPropertyRowMapper<>(Token.class),token.getMail(),token.getType());
        if (tokens!=null && tokens.size()!=0){
            return tokens.get(0);
        }else {
            return null;
        }
    }

    /**
     *  根据用id修改用户的类型
     *      的token
     * @param id
     * @param token
     * @return
     */
    @Override
    public String revampVerification(int id,int type,Token token) {
        String sql = "UPDATE user_token SET token = '"+token.getToken()+"',`begin` = '"+token.getBegin()+"' WHERE id = "+id+" AND type = "+type+";";
        if (template.update(sql)==1){
            return "OK";
        }else {
            return "NO";
        }
    }


}
