package com.shaoyuayu.util;

import com.shaoyuayu.dao.LocalDao;
import com.shaoyuayu.dao.impl.LocalDaoIpml;
import com.shaoyuayu.entity.Local;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LocalUtil {
    /**
     * 跟request添加地区选择数据
     * @param request
     * @param localAreaID
     * @return
     */
    private static LocalDao localDao = new LocalDaoIpml();
    public static HttpServletRequest addLocal(HttpServletRequest request,String localAreaID,String provinces){
        //查询localAreaID下面的地区
        List<Local> locals = localDao.queryLocalArea(localAreaID);
        //添加到request域中
        request.setAttribute("locals",locals);
        //添加地区添加一个选中状态
        request.setAttribute("localAreaID",localAreaID);
        /**
         *
         *判断省市是不是选择状态
         * 有，直接添加
         * 没有，默认一个选中状态
         */
        if (provinces!=null){
            Local local = localDao.queryLocal(provinces);
            request.setAttribute("provinces",local.getProvinces());
            //添加一个省市名称
            request.setAttribute("local",local.getLocal());
            request.setAttribute("staticLocal",local);
        }else {
            //取出一个默认城市
            Local local = localDao.queryLocalAreaNo(localAreaID);
            request.setAttribute("provinces",local.getProvinces());
            request.setAttribute("staticLocal",local);
        }
        return request;
    }

}
