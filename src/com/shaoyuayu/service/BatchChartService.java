package com.shaoyuayu.service;

public interface BatchChartService {
    /**
     * 根据地区查找对于
     * 5年的高考数据
     * 返回一个字符串给页面的JavaScript制图
     * @param local
     * @return
     */
    public String queryLocalBatch(String local);

}
