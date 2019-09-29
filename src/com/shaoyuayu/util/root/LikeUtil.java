package com.shaoyuayu.util.root;

import com.shaoyuayu.service.root.DataLikeService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class LikeUtil {

    public HttpServletRequest addLike(HttpServletRequest request){
        //点赞。通过cookie
        String like  =request.getParameter("like");
        Cookie[] cookies = request.getCookies();
        Cookie user_id = null;
        Cookie JSESSIONID = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user_id")){
                user_id = cookie;
            }
            if (cookie.getName().equals("JSESSIONID")){
                JSESSIONID = cookie;
            }
        }
        //保存到数据库
        DataLikeService dataLikeService = new DataLikeService();
        String likeItem = dataLikeService.addLikeData(JSESSIONID,user_id);
        request.setAttribute("likeItem",likeItem);
        return request;
    }

}
