package com.shaoyuayu.service.impl;

import com.shaoyuayu.dao.BatchsDao;
import com.shaoyuayu.dao.impl.BatchsDaoImpl;
import com.shaoyuayu.entity.Batchs;
import com.shaoyuayu.service.BatchsService;

import java.util.List;

public class BatchsServiceImpl implements BatchsService {
    private BatchsDao batchsDao = new BatchsDaoImpl();

    /**
     * 根据地区的年份查询省控分数线
     * @param local 地区
     * @param year 年份,为零的时候查询所有
     * @return
     */
    @Override
    public List<Batchs> localQueryBachs(String local, int year) {
        return batchsDao.localQueryBachs(local,year);
    }
}
