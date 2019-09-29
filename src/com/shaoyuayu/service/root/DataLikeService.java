package com.shaoyuayu.service.root;

import com.shaoyuayu.dao.root.Data_LikeDao;

import javax.servlet.http.Cookie;

/**
 * 点赞类
 */
public class DataLikeService {
    /**
     * 添加赞数
     */
    private Data_LikeDao data_likeDao = new Data_LikeDao();

    public String addLikeData(Cookie JSESSIONID,Cookie user_id){
        //添加
        int t;
        if (user_id==null){
             t = data_likeDao.addLike(JSESSIONID.getValue(),"");
        }else {
            t = data_likeDao.addLike(JSESSIONID.getValue(),user_id.getValue());
        }

        //查询最大的点赞数给用户
        return String.valueOf(data_likeDao.queryMaxLIke()+t);
    }

}
