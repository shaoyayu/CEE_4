package com.shaoyuayu.service.impl;

import com.shaoyuayu.dao.LocalDao;
import com.shaoyuayu.dao.impl.LocalDaoIpml;
import com.shaoyuayu.entity.Local;
import com.shaoyuayu.service.LocalService;

import java.util.List;

public class LocalServiceImpl implements LocalService {

    private LocalDao localDao = new LocalDaoIpml();

    /**
     * 查询地区下面的省市
     * @param localAreaID
     * @return
     */
    @Override
    public List<Local> queryLocalArea(String localAreaID) {
        return localDao.queryLocalArea(localAreaID);
    }

    /**
     * 查询地区下面的默认省市
     * @param localAreaID
     * @return
     */
    @Override
    public Local queryLocalAreaNo(String localAreaID) {
        return localDao.queryLocalAreaNo(localAreaID);
    }

    /**
     * 根据地区的provinces查询地区
     * @param provinces
     * @return
     */
    @Override
    public Local queryLocal(String provinces) {
        return null;
    }


}
