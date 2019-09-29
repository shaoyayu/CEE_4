package com.shaoyuayu.dao.impl;

import com.shaoyuayu.dao.LocalDao;
import com.shaoyuayu.entity.Local;
import com.shaoyuayu.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class LocalDaoIpml implements LocalDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 根据地区的id查询
     *  地区下面的省/直辖市
     * @param localAreaID
     * @return
     */
    @Override
    public List<Local> queryLocalArea(String localAreaID) {
        String sql = "SELECT * FROM tb_local WHERE localAreaID = ?;";
        List<Local> locals = template.query(sql,new BeanPropertyRowMapper<>(Local.class),localAreaID);
        return locals;
    }

    /**
     * 查找地区下面第一省市
     * @param localAreaID
     * @return
     */
    @Override
    public Local queryLocalAreaNo(String localAreaID) {
        String sql = "SELECT * FROM tb_local WHERE localAreaID=? LIMIT 1 ";
        List<Local> locals = template.query(sql,new BeanPropertyRowMapper<>(Local.class),localAreaID);
        return locals.get(0);
    }
    /**
     * 根据地区的provinces查询地区
     * @param provinces
     * @return
     */
    public Local queryLocal(String provinces) {
        String sql = "SELECT * FROM tb_local WHERE provinces = ?;";
        List<Local> locals = template.query(sql,new BeanPropertyRowMapper<>(Local.class),provinces);
        return locals.get(0);
    }

    @Test
    public void test(){
        System.err.println(queryLocalAreaNo("3").toString());
        for (Local local : queryLocalArea("3")) {
            System.out.println(local.toString());
        }
    }
}
