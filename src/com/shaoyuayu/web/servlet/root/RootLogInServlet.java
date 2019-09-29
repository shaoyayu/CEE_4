package com.shaoyuayu.web.servlet.root;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 创建时间
 * =========================
 * 4.0添加管理员的登录模块
 *
 * 修复时间
 * =========================
 *
 */
@WebServlet(value ={"/root/rootLogIn.do"})
public class RootLogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello world");
        System.out.println("欢迎你，尊敬的管理员");
    }
}
