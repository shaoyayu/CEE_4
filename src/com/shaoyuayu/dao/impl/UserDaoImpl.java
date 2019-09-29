package com.shaoyuayu.dao.impl;

import com.root.util.Log4jTest;
import com.shaoyuayu.dao.UserDao;
import com.shaoyuayu.entity.User;
import com.shaoyuayu.util.JDBCUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private static Logger logger = Logger.getLogger(Log4jTest.class);
    //获取template
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 保存用户
     * @param user
     * @return
     */
    @Override
    public String saveUser(User user) {
        String sql = "INSERT INTO user_id(mail,user_id)" +
                " VALUES(?,?);";
        int t = template.update(sql,user.getMail(),user.getUser_id());
        if (t>0){
            return "OK";
        }else {
            return "NO";
        }
    }

    /**
     * 查询用户
     * @param main
     * @return
     */
    @Override
    public User queryUser(String main) {
        String sql = "SELECT * FROM user_id WHERE mail = ?;";
        List<User> users = template.query(sql,new BeanPropertyRowMapper<>(User.class),main);
        if (users==null||users.size()==0){
            return null;
        }else {
            return users.get(0);
        }
    }
    @Test
    public void test(){
        System.out.println(this.queryUser("2416746596@qq.com").toString());
    }
}
