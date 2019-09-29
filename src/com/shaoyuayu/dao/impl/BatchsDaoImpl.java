package com.shaoyuayu.dao.impl;

import com.shaoyuayu.dao.BatchsDao;
import com.shaoyuayu.entity.Batchs;
import com.shaoyuayu.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class BatchsDaoImpl implements BatchsDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     *
     * @param local 地区
     * @param year 年份,为零的时候查询所有
     * @return
     */
    @Override
    public List<Batchs> localQueryBachs(String local, int year) {
        String sql = "";
        List<Batchs> batches;
        if (year==0) {
            sql = "SELECT `local`,syear,batch,wl,MINscore FROM tb_batchs WHERE `local` = ?;";
            batches = template.query(sql,new BeanPropertyRowMapper<>(Batchs.class),local);
        }else {
            sql = "SELECT `local`,syear,batch,wl,MINscore FROM tb_batchs WHERE `local` = ? AND syear = ?;";
            batches = template.query(sql,new BeanPropertyRowMapper<>(Batchs.class),local,year);
        }
        return batches;
    }
    @Test
    public void test(){
        for (Batchs batch : localQueryBachs("贵州",2018)) {
            System.out.println(batch.toString());
        }
    }
}
