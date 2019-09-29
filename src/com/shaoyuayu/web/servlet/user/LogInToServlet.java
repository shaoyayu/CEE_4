package com.shaoyuayu.web.servlet.user;

import com.shaoyuayu.dao.UserDao;
import com.shaoyuayu.dao.impl.UserDaoImpl;
import com.shaoyuayu.entity.User;
import com.shaoyuayu.service.MailService;
import com.shaoyuayu.service.impl.MailServiceImpl;
import com.shaoyuayu.util.MailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/LogInToToken.do")
public class LogInToServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_mail = request.getParameter("user_mail");
        if (user_mail==null||user_mail.equals("")){
            response.getWriter().println("请输入邮箱");
            response.getWriter().flush();
            response.getWriter().close();
        }else {
            //判断邮箱是不是合法的
            MailUtil mailUtil = new MailUtil();
            if (!mailUtil.verifyMail(user_mail)){
                response.getWriter().println("请输入正确的邮箱");
                response.getWriter().flush();
                response.getWriter().close();
            }
            //判断用户是不是存在
            UserDao userDao = new UserDaoImpl();
            User user = userDao.queryUser(user_mail);
            if (user==null){
                response.getWriter().println("用户尚未注册，请去注册");
                response.getWriter().flush();
                response.getWriter().close();
            }
            MailService mailService = new MailServiceImpl();
            String con = mailService.sendVerificationCode(user_mail,1);
            response.getWriter().println(con);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}
