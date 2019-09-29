package com.shaoyuayu.web.servlet.user;

import com.shaoyuayu.dao.UserDao;
import com.shaoyuayu.dao.impl.UserDaoImpl;
import com.shaoyuayu.entity.User;
import com.shaoyuayu.service.MailService;
import com.shaoyuayu.service.impl.MailServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/RegisterToToken.do")
public class RegisterToServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        String user_mail = request.getParameter("user_mail");
        if (user_mail==null||user_mail.equals("")){
            response.getWriter().println("请输入邮箱");
            response.getWriter().flush();
            response.getWriter().close();
        }else {
            //判断是不是有当前的用户
            UserDao userDao = new UserDaoImpl();
            User user = userDao.queryUser(user_mail);
            if (user!=null){
                response.getWriter().println("用户已经注册，请登录");
                response.getWriter().flush();
                response.getWriter().close();
            }else {
                MailService mailService = new MailServiceImpl();
                String con = mailService.sendVerificationCode(user_mail,0);

                response.getWriter().println(con);
                response.getWriter().flush();
                response.getWriter().close();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.sendRedirect("index.html");
    }
}
