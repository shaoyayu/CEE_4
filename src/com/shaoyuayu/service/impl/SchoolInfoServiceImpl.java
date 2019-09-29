package com.shaoyuayu.service.impl;

import com.shaoyuayu.dao.SchoolInfoDao;
import com.shaoyuayu.dao.impl.SchoolInfoDaoImpl;
import com.shaoyuayu.entity.SchoolInfo;
import com.shaoyuayu.entity.school.School;
import com.shaoyuayu.entity.school.SchoolSc;
import com.shaoyuayu.service.SchoolInfoService;

import java.util.List;
import java.util.Map;

public class SchoolInfoServiceImpl implements SchoolInfoService {
    private SchoolInfoDao schoolInfoDao = new SchoolInfoDaoImpl();
    /**
     * 根据学校查询相同的校园
     * @param name
     * @return
     */
    @Override
    public SchoolInfo nameQuerySchool(String name) {
        return schoolInfoDao.nameQuerySchool(name);
    }

    /**
     * 根据省/直辖市id查询城市
     * @param localId
     * @return
     */
    @Override
    public List<Map<String, Object>> localIdQueryCitys(String localId) {
        return schoolInfoDao.localIdQueryCitys(localId);
    }

    /**
     * 根据城市id查询学校
     * @param cityId
     * @return
     */
    @Override
    public List<SchoolInfo> cityIdQuerySchools(String cityId,String school_type) {
        return schoolInfoDao.cityIdQuerySchools(cityId,school_type);
    }

    /**
     * 到数据库中查找相似的数据库
     * @param school_name
     * @return
     */
    @Override
    public List<SchoolInfo> nameQuerySchools(String school_name) {
        return schoolInfoDao.nameQuerySchools(school_name);
    }

    /**
     * 根据用户的选择的id出岔子school的数据
     * @param schoolId
     * @return
     */
    @Override
    public School schoolIdQuerySchool(String schoolId) {
        return schoolInfoDao.schoolIdQuerySchool(schoolId);
    }

    /**
     * 根据用户选择的学校查找想关联系方式
     * @param schoolId
     * @return
     */
    @Override
    public SchoolSc schoolIdQuerySc(String schoolId) {
        return schoolInfoDao.schoolIdQuerySc(schoolId);
    }

    /**
     * 查找学校的相关信息
     * @param schoolId
     * @return
     */
    @Override
    public SchoolInfo schoolIdQuerySchoolInfo(String schoolId) {
        return schoolInfoDao.schoolIdQuerySchoolInfo(schoolId);
    }

    @Override
    public List<SchoolInfo> userQuerySchool(String mail) {
        return schoolInfoDao.userQuerySchool(mail);
    }
}
