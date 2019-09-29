package com.shaoyuayu.web.servlet;

import com.shaoyuayu.entity.Local;
import com.shaoyuayu.util.LocalUtil;
import com.shaoyuayu.util.ProvinceUtil;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "/stairScore.html")
public class StairScoreServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        //获取当前的地区选择
        String localAreaID = request.getParameter("localAreaID");
        //要是localAreaID为空时候重定向到505见面
        if (localAreaID!=null) {
            //获取省市provinces
            String provinces = request.getParameter("provinces");
            request = LocalUtil.addLocal(request, localAreaID, provinces);
            //拿取request域中取local
            Local local = (Local) request.getAttribute("staticLocal");
            //查询省市下面的数据
            request = ProvinceUtil.uploadBatchsData(local.getLocal(),1,request);
            //查询地区下面的年份和wl课情况，以便在页面上好显示信息
            request.getRequestDispatcher("/stairScore.jsp").forward(request,response);
        }else {

        }

    }
}
