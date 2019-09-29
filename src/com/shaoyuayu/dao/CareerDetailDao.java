package com.shaoyuayu.dao;

import com.shaoyuayu.entity.careers.Pc_career_detail;
import com.shaoyuayu.entity.careers.Pc_jobdetail_1;
import com.shaoyuayu.entity.careers.Pc_jobdetail_3;

import java.util.List;

public interface CareerDetailDao {
    /**
     * 根据专业id查询专业详情
     * @param careerId
     * @return
     */
    public Pc_career_detail queryPc_career_detail(String careerId);
    /**
     * 根据专业的id查询的就业方向
     * @param careerId
     * @return
     */
    public List<Pc_jobdetail_1> queryPc_jobdetail_1(String careerId);

    /**
     * 根据专业的id查询的岗位方向
     * @param careerId
     * @return
     */
    public List<Pc_jobdetail_3> queryPc_jobdetail_3(String careerId);

    
    
}
