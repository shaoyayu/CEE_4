package com.shaoyuayu.util;

import com.shaoyuayu.dao.CareerDao;
import com.shaoyuayu.dao.impl.CareerDaoImpl;
import com.shaoyuayu.entity.Career;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CareersUtil  {
    //根据专业大类的id查询专业
    private static CareerDao careerDao = new CareerDaoImpl();
    public static HttpServletRequest addCareeas(HttpServletRequest request){
        //获取专业本科/专科的选择
        String career1 = request.getParameter("major_1");
        String career2 = request.getParameter("major_2");
        String career3 = request.getParameter("major_3");
        if (career1==null){
            career1 = "1";
        }
        if (career2==null){
            //查找专业分层下面的第一个专业大类
            career2 = careerDao.queryClasss(career1,null);
        }
        if (career3==null){
            //查找专业大类下面的第一个专业小类
            career3 = careerDao.queryClasss(null,career2);
        }
        //添加选中状态
        request.setAttribute("major_1",career1);
        request.setAttribute("major_2",career2);
        request.setAttribute("major_3",career3);
        //添加专业层次下面的专业大类数据
        List<Career> careers_1 = careerDao.queryCareer(career1);
        List<Career> careers_2 = careerDao.queryCareer_1(career2);
        List<Career> careers_3 = careerDao.queryCareer_2(career3);
        request.setAttribute("careers_1",careers_1);
        request.setAttribute("careers_2",careers_2);
        request.setAttribute("careers_3",careers_3);
        return request;
    }
}
