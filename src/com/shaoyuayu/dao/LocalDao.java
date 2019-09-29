package com.shaoyuayu.dao;

import com.shaoyuayu.entity.Local;

import java.util.List;

public interface LocalDao {

    /**
     * 根据地区id查询下面的省直辖市
     * @param localAreaID
     * @return
     */
    public List<Local> queryLocalArea(String localAreaID);

    /**
     *
     * @param localAreaID
     * @return
     */
    public Local queryLocalAreaNo(String localAreaID);

    /**
     * 根据地区的provinces查询地区
     * @param provinces
     * @return
     */
    public Local queryLocal(String provinces);

}
