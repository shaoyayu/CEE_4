package com.shaoyuayu.web.servlet.user;

import com.shaoyuayu.dao.MailDao;
import com.shaoyuayu.dao.UserDao;
import com.shaoyuayu.dao.impl.MailDaoImpl;
import com.shaoyuayu.dao.impl.UserDaoImpl;
import com.shaoyuayu.entity.User;
import com.shaoyuayu.service.RegisterSaveService;
import com.shaoyuayu.service.impl.RegisterSaveServiceImpl;
import com.shaoyuayu.util.MailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/registerSave.do")
public class RegisterSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 响应注册发送的账号和验证码
         */
        String user_name = request.getParameter("user_name");
        String user_token = request.getParameter("user_token");
        if (user_name==null||user_name.equals("")){
            request.setAttribute("ages","请输入账号");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
        if (user_token==null||user_token.equals("")){
            request.setAttribute("ages","请输入验证码");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
        /**
         * 进行验证码验证和用户验证
         */
        MailUtil mailUtil = new MailUtil();
        if (!mailUtil.verifyMail(user_name)){
            request.setAttribute("ages","请输入正确的邮箱");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
        RegisterSaveService registerSaveService = new RegisterSaveServiceImpl();
        int ages = registerSaveService.addUser(user_name,user_token);
        if (ages==-2){
            request.setAttribute("ages","验证码超时");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }else if (ages==-1){
            request.setAttribute("ages","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }else if (ages==0){
            request.setAttribute("ages","注册失败");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }else if (ages==2){
            request.setAttribute("ages","用户被注册");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }else {
            //注册成功查询用户id封装到cookie中，生命周期为24消息
            UserDao userDao = new UserDaoImpl();
            User user = userDao.queryUser(user_name);
            //给用户添加cookie
            Cookie cookie = new Cookie("user_id",user.getUser_id());
            cookie.setMaxAge(3*60*60);
            response.addCookie(cookie);
            response.sendRedirect("index.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //转发到登录页面
        resp.sendRedirect("index.html");
    }
}
