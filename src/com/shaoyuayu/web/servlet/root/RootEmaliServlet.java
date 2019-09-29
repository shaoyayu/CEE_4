package com.shaoyuayu.web.servlet.root;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 5.0功能，管理员的邮箱管理模块开发
 * ==============================
 * 完成对邮件系统的开发 2019年9月29日21:02:31
 */

@WebServlet(value = {"/RootEmaliServlet"})
public class RootEmaliServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("邮件系统开发完成");
    }
}
