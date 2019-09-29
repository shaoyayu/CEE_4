package com.shaoyuayu.dao;

public interface CollectDao  {

    /**
     * 查询用户是不是已经添加专业数据
     * @param main
     * @param career_id
     * @return
     */
    public String queryCollect(String main,String career_id);

    /**
     * 查询用户是不是已经添加有学校收藏
     * @param mail
     * @param career_id
     * @return
     */
    public String querySchool(String mail,String career_id);

    /**
     * 添加收藏专业
     * @param main
     * @param careerId
     * @return
     */
    public String addCollectCareer(String main,String careerId);
    /**
     * 添加收藏学校
     * @param main
     * @param careerId
     * @return
     */
    public String addCollectSchool(String main,String careerId);

    /**
     * 移除收藏的专业
     * @param main
     * @param careerId
     * @return
     */
    public String removeCollectCareer(String main,String careerId);

    /**
     * 移除收藏的学校
     * @param main
     * @param careerId
     * @return
     */
    public String removeCollectSchool(String main,String careerId);
}
