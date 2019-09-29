package com.shaoyuayu.dao.impl;

import com.shaoyuayu.dao.SchoolDetailDao;
import com.shaoyuayu.util.JDBCUtils;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class SchoolDetailDaoImpl implements SchoolDetailDao {

    //获取template
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 查询新学校名称
     * @param schoolId
     * @return
     */
    @Override
    public String querySchoolName(String schoolId) {
        String sql = "SELECT school_name FROM schools WHERE school_id = ?";
        Map<String,Object> map = template.queryForMap(sql,schoolId);
        return map.get("school_name").toString();
    }

    /**
     * 查询学校开设的本科专业
     * @param schoolId
     * @return
     */
    @Override
    public List<Map<String, Object>> querySchoolCareerWL_1(String schoolId) {
        String sql = "SELECT special_name FROM pc_specials WHERE type_name = '本科' AND school_id = ?;";
        List<Map<String,Object>> list = template.queryForList(sql,schoolId);
        return list;
    }

    /**
     * 查询学校下面的专科专业
     * @param schoolId
     * @return
     */
    @Override
    public List<Map<String, Object>> querySchoolCareerWL_2(String schoolId) {
        String sql = "SELECT special_name FROM pc_specials WHERE type_name = '专科（高职）' AND school_id = ?;";
        List<Map<String,Object>> list = template.queryForList(sql,schoolId);
        return list;
    }

    /**
     * 查询学校下面开设的院校
     * @param schoolId
     * @return
     */
    @Override
    public String querySchoolAcademy(String schoolId) {
        String sql = "SELECT content FROM department WHERE school_id = ?;";
        try {
            Map<String,Object> map = template.queryForMap(sql,schoolId);
            return map.get("content").toString();
        }catch (EmptyResultDataAccessException e){
            return "暂无数据";
        }

    }

    @Test
    public void test(){
        System.out.println(querySchoolAcademy("1266"));
    }
}
