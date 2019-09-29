package com.shaoyuayu.service.impl;

import com.shaoyuayu.dao.SchoolDetailDao;
import com.shaoyuayu.dao.impl.SchoolDetailDaoImpl;
import com.shaoyuayu.service.SchoolDetailService;

import java.util.List;
import java.util.Map;

public class SchoolDetailServiceImpl implements SchoolDetailService {
    private SchoolDetailDao schoolDetailDao = new SchoolDetailDaoImpl();
    /**
     * 查询学校的名字
     * @param schoolId
     * @return
     */
    @Override
    public String querySchoolName(String schoolId) {
        return schoolDetailDao.querySchoolName(schoolId);
    }

    /**
     * 查询学校开设的本科专业
     * @param schoolId
     * @return
     */
    @Override
    public List<Map<String, Object>> querySchoolCareerWL_1(String schoolId) {
        return schoolDetailDao.querySchoolCareerWL_1(schoolId);
    }

    /**
     * 查询学校开设专科专业
     * @param schoolId
     * @return
     */
    @Override
    public List<Map<String, Object>> querySchoolCareerWL_2(String schoolId) {
        return schoolDetailDao.querySchoolCareerWL_2(schoolId);
    }

    /**
     * 查询学校开设的学院内容
     * @param schoolId
     * @return
     */
    @Override
    public String querySchoolAcademy(String schoolId) {
        return schoolDetailDao.querySchoolAcademy(schoolId);
    }
}
