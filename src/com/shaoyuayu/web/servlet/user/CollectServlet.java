package com.shaoyuayu.web.servlet.user;

import com.shaoyuayu.dao.UserDao;
import com.shaoyuayu.dao.impl.UserDaoImpl;
import com.shaoyuayu.entity.Career;
import com.shaoyuayu.entity.SchoolInfo;
import com.shaoyuayu.entity.User;
import com.shaoyuayu.service.CareerService;
import com.shaoyuayu.service.CollectService;
import com.shaoyuayu.service.SchoolDetailService;
import com.shaoyuayu.service.SchoolInfoService;
import com.shaoyuayu.service.impl.CareerServiceImpl;
import com.shaoyuayu.service.impl.CollectServiceImpl;
import com.shaoyuayu.service.impl.SchoolInfoServiceImpl;
import com.shaoyuayu.util.CollectUtil;
import com.shaoyuayu.util.DESUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/collect.html")
public class CollectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户的收藏
        Cookie[] cookies = request.getCookies();
        String user_idCookie =  null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user_id")){
                user_idCookie = cookie.getValue();
            }
        }
        if (user_idCookie==null){
            //当前用户不存在登录。从定向到用户登录见面
            response.sendRedirect(request.getContextPath()+"/login.html");
        }else {
            user_idCookie = DESUtil.DESDecript(user_idCookie,"shaoyayu");
            //判断用户是不是存在
            UserDao userDao = new UserDaoImpl();
            if (userDao.queryUser(user_idCookie)==null){
                //当前用户不存在
                response.sendRedirect(request.getContextPath()+"/500.html");
            }
            String addCollectId = request.getParameter("addCollect");
            if (addCollectId==null&&addCollectId.equals("")){
                response.sendRedirect(request.getContextPath()+"/500.html");
            }else {
                CollectUtil collectUtil = new CollectUtil();
                if(collectUtil.verifyCollectStr(addCollectId).equals("OK")){
                    //解析收藏或者删除数据
                    CollectService collectService = new CollectServiceImpl();
                    String[] data = addCollectId.split("=");
                    if (data[0].equals("careerId")){
                        //添加专业收藏
                        collectService.addCollectCareer(user_idCookie,data[1]);
                        doGet(request,response);
                    } else if (data[0].equals("schoolId")) {
                        //添加用户收藏学校
                        collectService.addCollectSchool(user_idCookie,data[1]);
                        doGet(request,response);
                    }else if (data[0].equals("rCareerId")){
                        //删除用户的收藏的专业
                        collectService.removeCollectCareer(user_idCookie,data[1]);
                        doGet(request,response);
                    }else if (data[0].equals("rSchoolId")){
                        //删除用户收藏的学校
                        collectService.removeCollectSchool(user_idCookie,data[1]);
                        doGet(request,response);
                    }else {
                        //找不到用户的操作数据
                        response.sendRedirect(request.getContextPath()+"/500.html");
                    }
                }else {
                    response.sendRedirect(request.getContextPath()+"/500.html");
                }
            }
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //禁止缓存
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires",0);
        //获取用户的cookie中的user_id查询用户收藏的数据
        //获取用户的收藏
        Cookie[] cookies = request.getCookies();
        String user_idCookie =  null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user_id")){
                user_idCookie = cookie.getValue();
            }
        }
        if (user_idCookie==null){
            //当前用户不存在登录。从定向到用户登录见面
            response.sendRedirect(request.getContextPath()+"/login.html");
        }else {
            user_idCookie = DESUtil.DESDecript(user_idCookie,"shaoyayu");
            //查找用户添加用户的数据
            UserDao userDao = new UserDaoImpl();
            User user = userDao.queryUser(user_idCookie);
            request.setAttribute("user",user);
            //添加用户的收藏专业模块
            CareerService careerService = new CareerServiceImpl();
            List<Career> lists = careerService.userQueryCareer(user.getMail());
            request.setAttribute("careerList",lists);
            //添加用户收藏的学校模块
            SchoolInfoService schoolInfoService = new SchoolInfoServiceImpl();
            List<SchoolInfo> schoolInfoList = schoolInfoService.userQuerySchool(user.getMail());
            request.setAttribute("schoolInfoList",schoolInfoList);
            request.getRequestDispatcher("collect.jsp").forward(request,response);
        }

    }
}
