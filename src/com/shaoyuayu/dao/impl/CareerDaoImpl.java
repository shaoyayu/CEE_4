package com.shaoyuayu.dao.impl;

import com.shaoyuayu.dao.CareerDao;
import com.shaoyuayu.entity.Career;
import com.shaoyuayu.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class CareerDaoImpl implements CareerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据专业层次，查询下面的专业大类
     * @param major_1
     * @return
     */
    @Override
    public List<Career> queryCareer(String major_1) {
        String sql = "SELECT DISTINCT(level2_name),level2 FROM careers_info WHERE level1 = ?;";
        List<Career> careerList = template.query(sql,new BeanPropertyRowMapper<>(Career.class),major_1);
        return careerList;
    }

    /**
     * 根据专业大类查询专业小类
     * @param major_2
     * @return
     */
    @Override
    public List<Career> queryCareer_1(String major_2) {
        String sql = "SELECT DISTINCT(level3),level3_name FROM careers_info WHERE level2 = ?;";
        List<Career> careerList = template.query(sql,new BeanPropertyRowMapper<>(Career.class),major_2);
        return careerList;
    }

    /**
     * 根据专业小类id查询专业
     * @param major_3
     * @return
     */
    @Override
    public List<Career> queryCareer_2(String major_3) {
        String sql = "SELECT * FROM careers_info WHERE level3 = ?;";
        List<Career> careerList = template.query(sql,new BeanPropertyRowMapper<>(Career.class),major_3);
        return careerList;
    }

    /**
     *
     * @param major_1
     * @param major_2
     * @return
     */
    @Override
    public String queryClasss(String major_1, String major_2) {
        String sql;
        String str;
        if (major_1!=null){
            sql = "SELECT DISTINCT(level2),level2_name FROM careers_info WHERE level1 = ? LIMIT 1;";
            List<Career> map = template.query(sql,new BeanPropertyRowMapper<>(Career.class),major_1);
            str = map.get(0).getLevel2();
        }else {
            sql = "SELECT DISTINCT(level3),level3_name FROM careers_info WHERE level2 = ? LIMIT 1;";
            List<Career> map = template.query(sql,new BeanPropertyRowMapper<>(Career.class),major_2);
            str = map.get(0).getLevel3();

        }
        return str;
    }

    /**
     *
     * @param major_1
     * @param className
     * @return
     */
    @Override
    public List<Career> queryCaeerClass(String major_1, String className) {
        String sql = "SELECT * FROM careers_info WHERE level3_name = ? AND level1 = ?;";
        List<Career> list = template.query(sql,new BeanPropertyRowMapper<>(Career.class),className,major_1);
        return list;
    }

    /**
     *查找用户的专业
     * @param career_name
     * @return
     */
    @Override
    public List<Career> queryCareers(String career_name) {
        String sql = "SELECT * FROM careers_info WHERE level2_name LIKE ? OR level3 LIKE ? OR `name` LIKE ?;";
        List<Career> list = template.query(sql,new BeanPropertyRowMapper<>(Career.class),"%"+career_name+"%","%"+career_name+"%","%"+career_name+"%");
        return list;
    }

    /**
     * 查询用户添加的专业
     * @param mail
     * @return
     */
    @Override
    public List<Career> userQueryCareer(String mail) {
        String sql = "SELECT * FROM careers_info WHERE special_id IN(\n" +
                "\tSELECT career_id FROM user_collectc WHERE user_id = ?);";
        List<Career> careerList = template.query(sql,new BeanPropertyRowMapper<>(Career.class),mail);
        return careerList;
    }

    @Test
    public void test(){
        for (Career career : queryCareers("计算机")) {
            System.out.println(career);
        }
    }
}
