package com.shaoyuayu.service;

public interface CollectService {
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
