package com.shaoyuayu.dao.impl;

import com.shaoyuayu.dao.PsDao;
import com.shaoyuayu.entity.Ps;
import com.shaoyuayu.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PsDaoImpl implements PsDao {
    //获取template
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 查询地区下面的是文理科还是单科情况
     * @param provinces
     * @param year
     * @return
     */
    @Override
    public List<String> queryLocalYearWl(String provinces, String year) {
        String sql = "SELECT DISTINCT(wl) FROM tb_ps WHERE syear = ?  AND `local` IN(SELECT `local` FROM tb_local WHERE provinces = ? );";
        List<String> list = template.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                String wlStr = resultSet.getString(1);
                return wlStr;
            }
        },year,provinces);
        return list;
    }

    /**
     * 按照排序吧分数拿出来
     * （需要测试数据的准确性）
     * @param provinces
     * @param year
     * @return
     */
    @Override
    public List<Ps> queryLocalPs(String provinces, String year) {
        String sql = "SELECT * from tb_ps WHERE syear = ?  AND `local` IN(SELECT `local` FROM tb_local WHERE provinces = ? ) ORDER BY point DESC;";
        List<Ps> list = template.query(sql,new BeanPropertyRowMapper<>(Ps.class),year,provinces);
        return list;
    }
    @Test
    public void test(){
        for (Ps ps : queryLocalPs("shanghai","2018")) {
            System.out.println(ps.toString());
        }
    }
}
