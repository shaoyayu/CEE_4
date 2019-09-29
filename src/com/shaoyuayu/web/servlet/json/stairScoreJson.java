package com.shaoyuayu.web.servlet.json;

import com.shaoyuayu.util.PsUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/json/stairScoreJson.json")
public class stairScoreJson extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取某年省市下面的一分一档响应
        //获取省市的provinces和年份
        String provinces = request.getParameter("provinces");
        String year = request.getParameter("year");
        PsUtil psUtil = new PsUtil();
        String json = psUtil.getPs(provinces,year);
        response.getWriter().println(json);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
