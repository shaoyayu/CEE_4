package com.shaoyuayu.web.servlet;

import com.shaoyuayu.entity.SchoolInfo;
import com.shaoyuayu.entity.school.School;
import com.shaoyuayu.entity.school.SchoolSc;
import com.shaoyuayu.service.SchoolInfoService;
import com.shaoyuayu.service.impl.SchoolInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/schoolItem.html")
public class SchoolItemServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 获取学校的id
         *  开设查询学校的相关信息
         */
        String schoolId = request.getParameter("schoolId");
        if (schoolId!=null&&!schoolId.equals("")){
            //开始查询数据
            SchoolInfoService schoolInfoService = new SchoolInfoServiceImpl();
            //查找学校介绍表
            School school = schoolInfoService.schoolIdQuerySchool(schoolId);
            request.setAttribute("school",school);
            //查找学校联系表
            SchoolSc schoolSc = schoolInfoService.schoolIdQuerySc(schoolId);
            request.setAttribute("schoolSc",schoolSc);
            //查询学校的详细
            SchoolInfo schoolInfo = schoolInfoService.schoolIdQuerySchoolInfo(schoolId);
            request.setAttribute("schoolInfo",schoolInfo);
            request.getRequestDispatcher("schoolItem.jsp").forward(request,response);
        }else {
            response.sendRedirect("schools.html?localAreaID=3&provinces=guizhou");
        }

    }
}
