package com.shaoyuayu.dao;

import com.shaoyuayu.entity.Career;

import java.util.List;

public interface CareerDao {
    /**
     * 根据专业层次
     * @param major_1
     * @return
     */
    public List<Career> queryCareer(String major_1);
    /**
     * 根据专业大类的id查询专业小类
     * @param major_2
     * @return
     */
    public List<Career> queryCareer_1(String major_2);
    /**
     * 根据专业小类id查询专业
     * @param major_3
     * @return
     */
    public List<Career> queryCareer_2(String major_3);

    /**
     * 查询专业大类或是专业小类下面的默认值
     * @param major_1
     * @param major_2
     * @return
     */
    public String queryClasss(String major_1,String major_2);
    /**
     * 在首页上根据专业的小类添加专业数据
     * @param major_1
     * @param className
     * @return
     */
    public List<Career> queryCaeerClass(String major_1,String className);


    /**
     * 查找专业
     * @param career_name
     * @return
     */
    public List<Career> queryCareers(String career_name);

    /**
     * 查询用户收藏的专业
     * @param mail
     * @return
     */
    public List<Career> userQueryCareer(String mail);
}
