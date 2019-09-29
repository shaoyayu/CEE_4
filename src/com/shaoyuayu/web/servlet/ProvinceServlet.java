package com.shaoyuayu.web.servlet;

import com.shaoyuayu.entity.Local;
import com.shaoyuayu.service.BatchChartService;
import com.shaoyuayu.service.impl.BatchChartServiceImpl;
import com.shaoyuayu.util.LocalUtil;
import com.shaoyuayu.util.ProvinceUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/province.html" )
public class ProvinceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前的地区选择
        String localAreaID = request.getParameter("localAreaID");
        //要是localAreaID为空时候重定向到505见面
        if (localAreaID!=null){
            //获取省市provinces
            String provinces = request.getParameter("provinces");
            request = LocalUtil.addLocal(request,localAreaID,provinces);
            //拿取request域中取local
            Local local = (Local) request.getAttribute("staticLocal");
            //查询省市下面的数据
            request = ProvinceUtil.uploadBatchsData(local.getLocal(),0,request);
            //准备图表的数据
            BatchChartService batchChartService = new BatchChartServiceImpl();
            String tubiaoData = batchChartService.queryLocalBatch(local.getLocal());
            request.setAttribute("tubiaoData",tubiaoData);
            request.getRequestDispatcher("/province.jsp").forward(request,response);
        }else {

        }
    }
}
