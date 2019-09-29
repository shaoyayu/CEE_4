package com.shaoyuayu.dao.impl;

import com.shaoyuayu.dao.CollectDao;
import com.shaoyuayu.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class CollectDaoImpl implements CollectDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public String queryCollect(String main, String career_id) {
        //查询用户是不是添加有专业收藏
        String sql = "SELECT * FROM user_collectc WHERE user_id = ? AND career_id = ?;";
        try {
            List<Map<String,Object>> list = template.queryForList(sql,main,career_id);
            if (list==null||list.size()==0){
                return "0";
            }else {
                return "1";
            }
        }catch (Exception e){
            return "0";
        }
    }

    @Override
    public String querySchool(String mail, String career_id) {
        //查询用户是不是添加有学校收藏
        String sql = "SELECT * FROM user_collects WHERE user_id = ? AND school_id = ?;";
        try {
            List<Map<String,Object>> list = template.queryForList(sql,mail,career_id);
            if (list==null||list.size()==0){
                return "0";
            }else {
                return "1";
            }
        }catch (Exception e){
            return "0";
        }
    }

    @Override
    public String addCollectCareer(String main, String careerId) {

        //添加用户的专业收藏
        String sql = "INSERT INTO user_collectc(user_id,career_id) VALUES(?,?);";
        int i = template.update(sql,main,careerId);
        return i+"";
    }

    @Override
    public String addCollectSchool(String main, String careerId) {
        //添加用户的学校收藏
        String sql = "INSERT INTO user_collects(user_id,school_id) VALUES(?,?);";
        int i = template.update(sql,main,careerId);
        return i+"";
    }

    @Override
    public String removeCollectCareer(String main, String careerId) {
        //移除用户的额专业收藏
        String sql = "DELETE FROM user_collectc WHERE user_id = ? AND career_id = ?;";
        int i = template.update(sql,main,careerId);
        return i+"";
    }

    /**
     *
     * @param main
     * @param careerId
     * @return
     */
    @Override
    public String removeCollectSchool(String main, String careerId) {
        //移除用户的学校收藏
        String sql = "DELETE FROM user_collects WHERE user_id = ? AND school_id = ?;";
        int i = template.update(sql,main,careerId);
        return i+"";
    }
    @Test
    public void test(){
        System.out.println(removeCollectCareer("2416746586@qq.com", 1 + ""));
    }
}
