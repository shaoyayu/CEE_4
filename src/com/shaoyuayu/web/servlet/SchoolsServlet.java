package com.shaoyuayu.web.servlet;

import com.shaoyuayu.entity.Local;
import com.shaoyuayu.entity.SchoolInfo;
import com.shaoyuayu.service.SchoolInfoService;
import com.shaoyuayu.service.impl.SchoolInfoServiceImpl;
import com.shaoyuayu.util.LocalUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "/schools.html")
public class SchoolsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义当前处于查找状态
        request.setAttribute("select",0);
        //获取查找的学校名字
        String school_name = request.getParameter("school_name");
        if (school_name==null||school_name.equals("")){
            //转发到默认选择
            response.sendRedirect("schools.html?localAreaID=3&provinces=guizhou");
        }else {
            SchoolInfoService schoolInfoService = new SchoolInfoServiceImpl();
            List<SchoolInfo> schoolInfoList = schoolInfoService.nameQuerySchools(school_name);
            request.setAttribute("schoolInfoList",schoolInfoList);
            request.getRequestDispatcher("/schools.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义当前处于查找状态
        request.setAttribute("select",1);
        String localAreaID = request.getParameter("localAreaID");
        String provinces = request.getParameter("provinces");
        request = LocalUtil.addLocal(request,localAreaID,provinces);
        //添加地区选择下面的城市数据
        Local local = (Local) request.getAttribute("staticLocal");
        //根据地区查找
        //创建城市数据
        SchoolInfoService schoolInfoService = new SchoolInfoServiceImpl();
        List<Map<String,Object>> citys;
        String city_id = request.getParameter("city_id");
        String staticCity;
        if (city_id == null||city_id.equals("")){
            //为空的情况下，根据省选择查找
            citys = schoolInfoService.localIdQueryCitys(local.getData_bin());
            //添加选择状态
            staticCity = citys.get(0).get("city_id").toString();
            request.setAttribute("staticCity",staticCity);
        }else {
            citys = schoolInfoService.localIdQueryCitys(local.getData_bin());
            staticCity = city_id;
            request.setAttribute("staticCity",staticCity);
        }
        //添加城市数据
        request.setAttribute("cityMapS",citys);
        //查询学校水平
        String school_type = request.getParameter("school_type");
        if (school_type==null||school_type.equals("")){
            school_type = "1";
        }
        //添加学校水平选择
        request.setAttribute("school_type",school_type);
        //添加学校信息
        List<SchoolInfo> schoolInfoList = schoolInfoService.cityIdQuerySchools(staticCity,school_type);
        request.setAttribute("schoolInfoList",schoolInfoList);
        request.getRequestDispatcher("/schools.jsp").forward(request,response);
    }
}
