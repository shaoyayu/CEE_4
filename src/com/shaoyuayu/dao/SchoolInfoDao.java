package com.shaoyuayu.dao;

import com.shaoyuayu.entity.SchoolInfo;
import com.shaoyuayu.entity.school.School;
import com.shaoyuayu.entity.school.SchoolSc;

import java.util.List;
import java.util.Map;

public interface SchoolInfoDao {

    /**
     * 根据学校的名称查找学校
     * @param name
     * @return
     */
    public SchoolInfo nameQuerySchool(String name);

    /**
     * 根据地区id查询下面的城市
     * @param localId
     * @return
     */
    public List<Map<String,Object>> localIdQueryCitys(String localId);

    /**
     *根据城市的cityId查询学校
     * @param cityId
     * @return
     */
    public List<SchoolInfo> cityIdQuerySchools(String cityId,String school_type);

    /**
     * 查找相似的高校
     * @param school_name
     * @return
     */
    public List<SchoolInfo> nameQuerySchools(String school_name);

    /**
     * 根据schoolInfo表中的id查询schools表中的数据
     * @param schoolId
     * @return
     */
    public School schoolIdQuerySchool(String schoolId);

    /**
     * 根据schoolInfo表中的id查询sc表中的数据
     * @param schoolId
     * @return
     */
    public SchoolSc schoolIdQuerySc(String schoolId);

    /**
     * 根据id查询下数据
     * @param schoolId
     * @return
     */
    public SchoolInfo schoolIdQuerySchoolInfo(String schoolId);

    /**
     * 查找用户收藏的学校
     * @param mail
     * @return
     */
    public List<SchoolInfo> userQuerySchool(String mail);
}
