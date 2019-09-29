package com.shaoyuayu.dao;

import com.shaoyuayu.entity.Ps;

import java.util.List;

public interface PsDao {

    /**
     * 查询地省市年份的wl科情况
     * @param provinces
     * @param year
     * @return
     */
    public List<String> queryLocalYearWl(String provinces,String year);

    /**
     * 查询地区下面的值
     *  可能会有能存异常
     * @param provinces
     * @param year
     * @return
     */
    public List<Ps> queryLocalPs(String provinces,String year);
    //根据科类查询成绩
}
