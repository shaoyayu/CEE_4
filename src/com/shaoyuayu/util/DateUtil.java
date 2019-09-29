package com.shaoyuayu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 项目测试类
 * Created by shaoyayu on 2019/4/26.
 */
public class DateUtil {

    public static void main(String[] args) {

        System.out.println(overtimeCode("2019-05-30 00:34:01", getTime(), 90));
    }

    public static String getTime(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    public static boolean overtimeCode(String firstTime,String lastTime,long overtime){
        System.err.println(lastTime);
        boolean flag=false;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date one;
        Date two;
        try {
            one = df.parse(firstTime);
            two = df.parse(lastTime);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff = time2 - time1;
            System.err.println(diff);
            if(diff/1000>overtime){
                flag=true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
