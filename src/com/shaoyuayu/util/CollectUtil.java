package com.shaoyuayu.util;

import org.junit.Test;

public class CollectUtil {

    public String verifyCollectStr(String addCollectId){
        String[] strings = addCollectId.split("=");
        if (strings.length==2){
            if (strings[0].equals("careerId")||strings[0].equals("schoolId")||strings[0].equals("rCareerId")||strings[0].equals("rSchoolId")){
                return "OK";
            }else {
                return "NO";
            }

        }else {
            return "NO";
        }
    }

    @Test
    public void test(){
        System.out.println(verifyCollectStr("careerId=454"));
    }
}
