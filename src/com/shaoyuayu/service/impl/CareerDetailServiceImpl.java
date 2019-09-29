package com.shaoyuayu.service.impl;

import com.shaoyuayu.dao.CareerDetailDao;
import com.shaoyuayu.dao.impl.CareerDetailDaoImpl;
import com.shaoyuayu.entity.careers.Pc_career_detail;
import com.shaoyuayu.entity.careers.Pc_jobdetail_3;
import com.shaoyuayu.service.CareerDetailService;

import java.util.List;


public class CareerDetailServiceImpl implements CareerDetailService {
    private CareerDetailDao careerDetailDao = new CareerDetailDaoImpl();
    @Override
    public Pc_career_detail queryPc_career_detail(String careerId) {
        return careerDetailDao.queryPc_career_detail(careerId);
    }

    @Override
    public List<Pc_jobdetail_3> queryPc_jobdetail_3(String careerId) {
        return careerDetailDao.queryPc_jobdetail_3(careerId);
    }

}
