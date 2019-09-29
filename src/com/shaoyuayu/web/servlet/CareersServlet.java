package com.shaoyuayu.web.servlet;

import com.shaoyuayu.entity.Career;
import com.shaoyuayu.service.CareerService;
import com.shaoyuayu.service.impl.CareerServiceImpl;
import com.shaoyuayu.util.CareersUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/careers.html")
public class CareersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String career_name = request.getParameter("career_name");
        if (career_name==null||career_name.equals("")){
            response.sendRedirect("careers.html?major_1=1");
        }else {
            CareerService careerService = new CareerServiceImpl();
            List<Career> careers_3 = careerService.queryCareers(career_name);
            request.setAttribute("careers_3",careers_3);
            request.getRequestDispatcher("/careers.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //给见面页添加数据
        request = CareersUtil.addCareeas(request);
        request.setAttribute("select",1);
        request.getRequestDispatcher("/careers.jsp").forward(request,response);
    }
}
