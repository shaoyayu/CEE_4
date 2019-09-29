package com.shaoyuayu.service;

import java.util.List;
import java.util.Map;

public interface SchoolDetailService {

    /**
     * 查询学校的名称
     * @param schoolId
     * @return
     */
    public String querySchoolName(String schoolId);

    /**
     * 查找学校开设的本科专业
     * @param schoolId
     * @return
     */
    public List<Map<String,Object>> querySchoolCareerWL_1(String schoolId);

    /**
     * 查找学校开设的专科专业
     * @param schoolId
     * @return
     */
    public List<Map<String,Object>> querySchoolCareerWL_2(String schoolId);

    /**
     *
     * @param schoolId
     * @return
     */
    public String querySchoolAcademy(String schoolId);

}
