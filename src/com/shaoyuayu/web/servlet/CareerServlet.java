package com.shaoyuayu.web.servlet;

import com.shaoyuayu.entity.careers.Pc_career_detail;
import com.shaoyuayu.entity.careers.Pc_jobdetail_3;
import com.shaoyuayu.service.CareerDetailService;
import com.shaoyuayu.service.impl.CareerDetailServiceImpl;
import com.shaoyuayu.util.CareerDetailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "/career.html")
public class CareerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取专业的id加载数据
        String careerId = request.getParameter("careerId");
        System.out.println(careerId);
        //根据专业ID查询专业详情信息
        CareerDetailService detailService = new CareerDetailServiceImpl();
        Pc_career_detail pc_career_detail = detailService.queryPc_career_detail(careerId);
        request.setAttribute("pc_career_detail",pc_career_detail);
        //添加就业方向的信息
        CareerDetailUtil detailUtil = new CareerDetailUtil();
        Map<String,String> Pc_jobdetail_1Map = detailUtil.queryPc_jobdetail_1Name(careerId);
        request.setAttribute("jobdetai1_name",Pc_jobdetail_1Map.get("jobdetai1_name"));
        request.setAttribute("jobdetai1_data",Pc_jobdetail_1Map.get("jobdetai1_data"));
        Map<String,String> Pc_jobdetail_3Map = detailUtil.queryPc_jobdetail_3Name(careerId);
        request.setAttribute("pc_jobdetail_3Name",Pc_jobdetail_3Map.get("pc_jobdetail_3Name"));
        request.setAttribute("pc_jobdetail_3Data",Pc_jobdetail_3Map.get("pc_jobdetail_3Data"));
        List<Pc_jobdetail_3> pc_jobdetail_3s = detailService.queryPc_jobdetail_3(careerId);
        request.setAttribute("pc_jobdetail_3s",pc_jobdetail_3s);
        request.getRequestDispatcher("/career.jsp").forward(request,response);
    }
}
