package com.shaoyuayu.dao.impl;

import com.shaoyuayu.dao.CareerDetailDao;
import com.shaoyuayu.entity.Career;
import com.shaoyuayu.entity.careers.Pc_career_detail;
import com.shaoyuayu.entity.careers.Pc_jobdetail_1;
import com.shaoyuayu.entity.careers.Pc_jobdetail_3;
import com.shaoyuayu.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 根据专业的id查询专业的详细信息
 */
public class CareerDetailDaoImpl implements CareerDetailDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 根据专业ID查询专业的详细
     * @param careerId
     * @return
     */
    @Override
    public Pc_career_detail queryPc_career_detail(String careerId) {
        String sql = "SELECT * FROM pc_career_detail WHERE id = ?;";
        List<Pc_career_detail> list = template.query(sql,new BeanPropertyRowMapper<>(Pc_career_detail.class),careerId);
        return list.get(0);
    }

    @Override
    public List<Pc_jobdetail_1> queryPc_jobdetail_1(String careerId) {
        String sql = "SELECT * FROM pc_jobdetail_1 WHERE special_id = ?;";
        List<Pc_jobdetail_1> list = template.query(sql,new BeanPropertyRowMapper<>(Pc_jobdetail_1.class),careerId);
        return list;
    }

    @Override
    public List<Pc_jobdetail_3> queryPc_jobdetail_3(String careerId) {
        String sql = "SELECT * FROM pc_jobdetail_3 WHERE special_id = ?;";
        List<Pc_jobdetail_3> list = template.query(sql,new BeanPropertyRowMapper<>(Pc_jobdetail_3.class),careerId);
        return list;
    }

    @Test
    public void test(){
        for (Pc_jobdetail_1 pc_jobdetail_1 : queryPc_jobdetail_1("1")) {
            System.out.println(pc_jobdetail_1.toString());
        }
    }

}
