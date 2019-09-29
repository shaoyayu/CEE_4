package com.shaoyuayu.dao;

import com.shaoyuayu.entity.Batchs;

import java.util.List;

public interface BatchsDao {
    /**
     * 根据地区和年份查询控档分数线
     * @param local 地区
     * @param year 年份,为零的时候查询所有
     * @return
     */
    public List<Batchs> localQueryBachs(String local, int year);
}
