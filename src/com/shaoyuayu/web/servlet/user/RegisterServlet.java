package com.shaoyuayu.web.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/register.html")
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires",0);
        request.getRequestDispatcher("/register.jsp").forward(request,response);
    }
}
