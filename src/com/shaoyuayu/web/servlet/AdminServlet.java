package com.shaoyuayu.web.servlet;

import com.shaoyuayu.service.root.DataLikeService;
import com.shaoyuayu.util.root.LikeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/admin.html")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LikeUtil likeUtil = new LikeUtil();
        request = likeUtil.addLike(request);
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LikeUtil likeUtil = new LikeUtil();
        request = likeUtil.addLike(request);
        request.getRequestDispatcher("admin.jsp").forward(request,response);
    }
}
