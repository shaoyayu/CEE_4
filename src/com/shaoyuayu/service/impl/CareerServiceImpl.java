package com.shaoyuayu.service.impl;

import com.shaoyuayu.dao.CareerDao;
import com.shaoyuayu.dao.impl.CareerDaoImpl;
import com.shaoyuayu.entity.Career;
import com.shaoyuayu.service.CareerService;

import java.util.List;

public class CareerServiceImpl implements CareerService {
    CareerDao careerDao = new CareerDaoImpl();

    /**
     * 根据专业层次查询专业
     * @param major_1
     * @return
     */
    @Override
    public List<Career> queryCareer(String major_1) {
        return careerDao.queryCareer(major_1);
    }

    /**
     * 根据专业大类查询专业小类
     * @param major_2
     * @return
     */
    @Override
    public List<Career> queryCareer_1(String major_2) {
        return careerDao.queryCareer_1(major_2);
    }

    /**
     * 根据专业小类id查询专业
     * @param major_3
     * @return
     */
    @Override
    public List<Career> queryCareer_2(String major_3) {
        return careerDao.queryCareer_2(major_3);
    }

    @Override
    public List<Career> queryCaeerClass(String major_1, String className) {
        return careerDao.queryCaeerClass(major_1,className);
    }

    @Override
    public List<Career> queryCareers(String career_name) {
        return careerDao.queryCareers(career_name);
    }

    @Override
    public List<Career> userQueryCareer(String mail) {
        return careerDao.userQueryCareer(mail);
    }

}
