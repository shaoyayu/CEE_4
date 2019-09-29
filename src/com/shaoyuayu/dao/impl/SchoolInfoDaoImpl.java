package com.shaoyuayu.dao.impl;

import com.shaoyuayu.dao.SchoolInfoDao;
import com.shaoyuayu.entity.SchoolInfo;
import com.shaoyuayu.entity.school.School;
import com.shaoyuayu.entity.school.SchoolSc;
import com.shaoyuayu.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class SchoolInfoDaoImpl implements SchoolInfoDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 根据学校的名称查找相对于的学校
     * @param name
     * @return
     * 测试通过
     */
    @Override
    public SchoolInfo nameQuerySchool(String name) {
        String sql = "SELECT * FROM tb_school_info WHERE `name` = '"+name+"';";
        List<SchoolInfo> list = template.query(sql,new BeanPropertyRowMapper<>(SchoolInfo.class));
        if (list==null||list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }

    /**
     * 根据地区省/直辖市查找城市
     * @param localId
     * @return
     */
    @Override
    public List<Map<String, Object>> localIdQueryCitys(String localId) {
        String sql = "SELECT DISTINCT(city_name),city_id FROM tb_school_info WHERE province_name IN (SELECT `local` FROM tb_local WHERE data_bin = "+localId+");";
        List<Map<String,Object>> cityList = template.queryForList(sql);
        return cityList;
    }
    /**
     *根据城市的cityId查询学校
     * @param cityId
     * @param school_type
     * @return
     */
    @Override
    public List<SchoolInfo> cityIdQuerySchools(String cityId,String school_type) {
        String sql ;
        if (school_type.equals("1")){
            sql = "SELECT * FROM tb_school_info WHERE city_id = ? AND school_type_name = '普通本科';";
        }else if (school_type.equals("2")){
            sql = "SELECT * FROM tb_school_info WHERE city_id = ? AND school_type_name = '独立学院';";
        }else if (school_type.equals("3")){
            sql = "SELECT * FROM tb_school_info WHERE city_id = ? AND school_type_name = '中外合作办学';";
        }else if (school_type.equals("4")){
            sql = "SELECT * FROM tb_school_info WHERE city_id = ? AND school_type_name = '专科（高职）';";
        }else if (school_type.equals("5")){
            sql = "SELECT * FROM tb_school_info WHERE city_id = ? AND school_type_name = '其他';";
        }else {
            sql = "SELECT * FROM tb_school_info WHERE city_id = ? AND school_type_name = '普通本科';";
        }
        List<SchoolInfo> list = template.query(sql,new BeanPropertyRowMapper<>(SchoolInfo.class),cityId);
        return list;
    }
    /**
     * 查找相似的高校
     * @param school_name
     * @return
     */
    @Override
    public List<SchoolInfo> nameQuerySchools(String school_name) {
        String sql = "SELECT * FROM tb_school_info WHERE `name` LIKE '%"+school_name+"%';";
        List<SchoolInfo> list = template.query(sql,new BeanPropertyRowMapper<>(SchoolInfo.class));
        return list;
    }
    /**
     * 根据schoolInfo表中的id查询schools表中的数据
     * @param schoolId
     * @return
     */
    @Override
    public School schoolIdQuerySchool(String schoolId) {
        String sql = "SELECT * FROM tb_schools WHERE schoolName IN(\n" +
                "\tSELECT school_name FROM schools WHERE schools.school_id = ?);";
        List<School> list = template.query(sql,new BeanPropertyRowMapper<>(School.class),schoolId);
        if (list==null||list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }
    /**
     * 根据schoolInfo表中的id查询sc表中的数据
     * @param schoolId
     * @return
     */
    @Override
    public SchoolSc schoolIdQuerySc(String schoolId) {
        String sql = "SELECT * FROM tb_sc WHERE schoolName IN(\n" +
                "\tSELECT school_name FROM schools WHERE schools.school_id =  ?);";
        List<SchoolSc> list = template.query(sql,new BeanPropertyRowMapper<>(SchoolSc.class),schoolId);
        if (list==null||list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }

    /**
     * 查找学校的相关信息
     * @param schoolId
     * @return
     */
    @Override
    public SchoolInfo schoolIdQuerySchoolInfo(String schoolId) {
        String sql = "SELECT * FROM tb_school_info WHERE school_id = ?";
        List<SchoolInfo> list = template.query(sql,new BeanPropertyRowMapper<>(SchoolInfo.class),schoolId);
        if (list==null||list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }

    @Override
    public List<SchoolInfo> userQuerySchool(String mail) {
        String sql = "SELECT * FROM tb_school_info WHERE school_id IN(\n" +
                "\tSELECT user_collects.school_id FROM user_collects WHERE user_id = ?);";
        List<SchoolInfo> list = template.query(sql,new BeanPropertyRowMapper<>(SchoolInfo.class),mail);
        return list;
    }


    @Test
    public void test(){
        System.out.println(schoolIdQuerySc("44").toString());
    }
}
