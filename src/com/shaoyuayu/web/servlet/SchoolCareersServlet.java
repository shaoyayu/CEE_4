package com.shaoyuayu.web.servlet;

import com.shaoyuayu.entity.SchoolInfo;
import com.shaoyuayu.entity.school.School;
import com.shaoyuayu.entity.school.SchoolSc;
import com.shaoyuayu.service.SchoolDetailService;
import com.shaoyuayu.service.SchoolInfoService;
import com.shaoyuayu.service.impl.SchoolDetailServiceImpl;
import com.shaoyuayu.service.impl.SchoolInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "/schoolCareers.html")
public class SchoolCareersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的学校id
        String schoolId = request.getParameter("schoolId");
        if (schoolId!=null&&!schoolId.equals("")){
            //查询学校名称
            SchoolDetailService schoolDetailService = new SchoolDetailServiceImpl();
            String schoolName = schoolDetailService.querySchoolName(schoolId);
            request.setAttribute("schoolName",schoolName);
            request.setAttribute("schoolId",schoolId);
            //查询学校开设的本科专业
            List<Map<String,Object>> schoolCareerWL_1 = schoolDetailService.querySchoolCareerWL_1(schoolId);
            //查询学校开设的专科专业
            List<Map<String,Object>> schoolCareerWL_2 = schoolDetailService.querySchoolCareerWL_2(schoolId);
            request.setAttribute("schoolCareerWL_1",schoolCareerWL_1);
            request.setAttribute("schoolCareerWL_2",schoolCareerWL_2);
            request.getRequestDispatcher("schoolCareers.jsp").forward(request,response);
        }else {
            response.sendRedirect("schools.html?localAreaID=3&provinces=guizhou");
        }
    }
}
