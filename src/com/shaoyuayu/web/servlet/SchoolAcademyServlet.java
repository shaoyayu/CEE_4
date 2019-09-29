package com.shaoyuayu.web.servlet;

import com.shaoyuayu.service.SchoolDetailService;
import com.shaoyuayu.service.impl.SchoolDetailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/schoolAcademy.html")
public class SchoolAcademyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String schoolId = request.getParameter("schoolId");
        if (schoolId!=null&&!schoolId.equals("")){
            //查询学校名称
            SchoolDetailService schoolDetailService = new SchoolDetailServiceImpl();
            String schoolName = schoolDetailService.querySchoolName(schoolId);
            request.setAttribute("schoolName",schoolName);
            request.setAttribute("schoolId",schoolId);
            //查询学校开设的本科专业
           String content = schoolDetailService.querySchoolAcademy(schoolId);
           request.setAttribute("content",content);
            request.getRequestDispatcher("schoolAcademy.jsp").forward(request,response);
        }else {
            response.sendRedirect("schools.html?localAreaID=3&provinces=guizhou");
        }
    }
}
