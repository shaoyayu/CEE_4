package com.shaoyuayu.service.impl;

import com.shaoyuayu.dao.CollectDao;
import com.shaoyuayu.dao.impl.CollectDaoImpl;
import com.shaoyuayu.service.CollectService;

public class CollectServiceImpl implements CollectService {
    private CollectDao collectDao = new CollectDaoImpl();
    @Override
    public String addCollectCareer(String main, String careerId) {
        if (collectDao.queryCollect(main,careerId).equals("0")){
            return collectDao.addCollectCareer(main,careerId);
        }else {
            System.out.println("专业已经被收藏");
            return 0+"";
        }

    }

    @Override
    public String addCollectSchool(String main, String careerId) {
        if (collectDao.querySchool(main,careerId).equals("0")){
            return collectDao.addCollectSchool(main,careerId);
        }else {
            return "0";
        }

    }

    @Override
    public String removeCollectCareer(String main, String careerId) {
        if (collectDao.queryCollect(main,careerId).equals("1")){
            return collectDao.removeCollectCareer(main,careerId);
        }else {
            return "0";
        }
    }

    @Override
    public String removeCollectSchool(String main, String careerId) {
        if (collectDao.querySchool(main,careerId).equals("1")){
            return collectDao.removeCollectSchool(main,careerId);
        }else {
            return "0";
        }

    }
}
