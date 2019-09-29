package com.shaoyuayu.service;

import com.shaoyuayu.entity.careers.Pc_career_detail;
import com.shaoyuayu.entity.careers.Pc_jobdetail_3;

import java.util.List;

public interface CareerDetailService {
    /**
     * 根据专业id查询专业详情
     * @param careerId
     * @return
     */
    public Pc_career_detail queryPc_career_detail(String careerId);

    /**
     * 根据专业ID查询岗位
     * @param careerId
     * @return
     */
    public List<Pc_jobdetail_3> queryPc_jobdetail_3(String careerId);


}
