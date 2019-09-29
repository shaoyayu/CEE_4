package com.shaoyuayu.util;

import com.shaoyuayu.dao.PsDao;
import com.shaoyuayu.dao.impl.PsDaoImpl;
import com.shaoyuayu.entity.Ps;
import org.junit.Test;

import java.util.List;

public class PsUtil {

    private PsDao psDao = new PsDaoImpl();

    /**
     * 调用dao的方法生成json数据响应页面
     *  数据格式：
     *      {"budget2012List": [],"budget2011List": [],"names": []}
     * @param provinces
     * @param yaer
     * @return
     */
    public String getPs(String provinces,String yaer){
        List<String> wls = psDao.queryLocalYearWl(provinces,yaer);
        List<Ps> psList = psDao.queryLocalPs(provinces,yaer);
        if (wls.size()==1){
            //使用第一种封装json方法
            return packaging1(psList);
        }else if (wls.size()==2){
            //使用第二种封装json方法
            return packaging2(psList);
        }else {
            //无数据返回
            return null;
        }
    }
    public String packaging1(List<Ps> psList){
        StringBuffer budget2012List = new StringBuffer("[");
        StringBuffer names = new StringBuffer("[");
        for (Ps ps : psList) {
            budget2012List = budget2012List.append(ps.getSectionPerson()+",");
            names = names.append("\""+ps.getWl()+ps.getPoint()+"分---累计人数["+ps.getAddUpPerson()+"]\",");
        }
        String str = budget2012List.substring(0,budget2012List.length()-1);
        String str1 = names.substring(0,names.length()-1);
        String json = "{\"budget2012List\": "+str+"],\"budget2011List\": [],\"names\": "+str1+"]}";
        return json;
    }
    public String packaging2(List<Ps> psList){
        StringBuffer budget2012List = new StringBuffer("[");
        StringBuffer budget2011List = new StringBuffer("[");
        StringBuffer names = new StringBuffer("[");
        //创建一个变量保存上一个分数，如果相等，
        for (Ps ps : psList) {
            if (ps.getWl().equals("文科")){
                budget2012List = budget2012List.append(ps.getSectionPerson()+",");
            }else {
                budget2012List = budget2012List.append("null,");
            }
            if (ps.getWl().equals("理科")){
                budget2011List = budget2011List.append(ps.getSectionPerson()+",");
            }else {
                budget2011List = budget2011List.append("null,");
            }
            names = names.append("\""+ps.getPoint()+"分---累计人数["+ps.getAddUpPerson()+"]\",");
        }
        String str = budget2012List.substring(0,budget2012List.length()-1);
        String str0 = budget2011List.substring(0,budget2011List.length()-1);
        String str1 = names.substring(0,names.length()-1);
        String json = "{\"budget2012List\": "+str+"],\"budget2011List\": "+str0+"],\"names\": "+str1+"]}";
        return json;
    }

    @Test
    public void test(){
        System.out.println(getPs("guizhou", "2018"));
    }
}
