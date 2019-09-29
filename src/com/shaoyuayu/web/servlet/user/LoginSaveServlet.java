package com.shaoyuayu.web.servlet.user;

import com.shaoyuayu.entity.User;
import com.shaoyuayu.service.LoginService;
import com.shaoyuayu.service.impl.LonginServiceIpml;
import com.shaoyuayu.util.MailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录保存页面
 */
@WebServlet(name = "/loginSave.do")
public class LoginSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户的登录请求
        String user_mail = request.getParameter("user_name");
        MailUtil mailUtil = new MailUtil();
        //判断是不是输入了邮箱
        if (user_mail==null){
            request.setAttribute("ages","请输入邮箱");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        //判断邮箱是不是合法的
        if (!mailUtil.verifyMail(user_mail)){
            request.setAttribute("ages","请输入正确的邮箱");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        String token = request.getParameter("token");
        if (token==null){
            request.setAttribute("ages","请输入验证码");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        LoginService loginService = new LonginServiceIpml();
        User user = loginService.queryUser(user_mail,token);
        if (user.getId()==-1){
            request.setAttribute("ages","该账号尚未注册");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else if (user.getId()==-2){
            request.setAttribute("ages","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else if (user.getId()==-3){
            request.setAttribute("ages","验证码超时");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            Cookie cookie = new Cookie("user_id",user.getUser_id());
            //添加3个小时cookie有效时间
            cookie.setMaxAge(3*60*60);
            response.addCookie(cookie);
            response.sendRedirect("index.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}
