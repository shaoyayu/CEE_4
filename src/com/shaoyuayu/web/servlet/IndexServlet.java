package com.shaoyuayu.web.servlet;

import com.shaoyuayu.entity.Batchs;
import com.shaoyuayu.entity.Career;
import com.shaoyuayu.entity.SchoolInfo;
import com.shaoyuayu.service.BatchsService;
import com.shaoyuayu.service.CareerService;
import com.shaoyuayu.service.SchoolInfoService;
import com.shaoyuayu.service.impl.BatchsServiceImpl;
import com.shaoyuayu.service.impl.CareerServiceImpl;
import com.shaoyuayu.service.impl.SchoolInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "/index.html")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //在页面上显示3所高校 清华大学，贵州大学，贵州民族大学
        SchoolInfoService schoolInfoService = new SchoolInfoServiceImpl();
        List<SchoolInfo> schoolInfoList = new ArrayList<>();
        schoolInfoList.add(schoolInfoService.nameQuerySchool("清华大学"));
        schoolInfoList.add(schoolInfoService.nameQuerySchool("贵州大学"));
        schoolInfoList.add(schoolInfoService.nameQuerySchool("贵州民族大学"));
        request.setAttribute("schoolInfoList",schoolInfoList);
        //添加声控分数线
        BatchsService batchsService = new BatchsServiceImpl();
        List<Batchs> GZBatchs = batchsService.localQueryBachs("贵州",2018);
        List<Batchs> BJBatchs = batchsService.localQueryBachs("北京",2018);
        List<Batchs> HBBatchs = batchsService.localQueryBachs("湖北",2018);
        request.setAttribute("GZBatchs",GZBatchs);
        request.setAttribute("BJBatchs",BJBatchs);
        request.setAttribute("HBBatchs",HBBatchs);
        //添加专业数据
        CareerService careerService = new CareerServiceImpl();
        List<Career> computersCareers = careerService.queryCaeerClass("1","计算机类");
        request.setAttribute("computersCareers",computersCareers);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
