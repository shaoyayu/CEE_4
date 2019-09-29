package com.shaoyuayu.util;

import com.shaoyuayu.dao.CareerDetailDao;
import com.shaoyuayu.dao.impl.CareerDetailDaoImpl;
import com.shaoyuayu.entity.careers.Pc_jobdetail_1;
import com.shaoyuayu.entity.careers.Pc_jobdetail_3;
import org.junit.Test;
import org.springframework.beans.factory.support.ManagedMap;

import java.util.List;
import java.util.Map;

public class CareerDetailUtil {

    CareerDetailDao detailDao = new CareerDetailDaoImpl();
    //生成就业分布的两个字符串
    public Map<String,String> queryPc_jobdetail_1Name(String careerId){
        Map<String,String> pc_jobdetailMap = new ManagedMap<>();
        List<Pc_jobdetail_1> jobdetail_1s = detailDao.queryPc_jobdetail_1(careerId);
        String data = "[";
        for (Pc_jobdetail_1 jobdetail_1 : jobdetail_1s) {
            data = data.concat("'"+jobdetail_1.getName()+"',");
        }
        data = data.substring(0,data.length()-1);
        data = data.concat("]");
        pc_jobdetailMap.put("jobdetai1_name",data);
        String data_1 = "[";
        for (Pc_jobdetail_1 jobdetail_1 : jobdetail_1s) {
            data_1 = data_1.concat("{value:"+jobdetail_1.getRate()+", name:'"+jobdetail_1.getName()+"'},");
        }
        data_1 = data_1.substring(0,data_1.length()-1);
        data_1 = data_1.concat("]");
        pc_jobdetailMap.put("jobdetai1_data",data_1);
        return pc_jobdetailMap;
    }

    public Map<String,String> queryPc_jobdetail_3Name(String careerId) {
        Map<String,String> pc_jobdetail_3Map = new ManagedMap<>();
        List<Pc_jobdetail_3> pc_jobdetail_3s = detailDao.queryPc_jobdetail_3(careerId);
        String detail_pos = "[";
        for (Pc_jobdetail_3 pc_jobdetail_3 : pc_jobdetail_3s) {
            detail_pos = detail_pos.concat("'"+pc_jobdetail_3.getDetail_pos()+"',");
        }
        detail_pos = detail_pos.substring(0,detail_pos.length()-1);
        detail_pos = detail_pos.concat("]");
        pc_jobdetail_3Map.put("pc_jobdetail_3Name",detail_pos);
        String rates = "[";
        for (Pc_jobdetail_3 pc_jobdetail_3 : pc_jobdetail_3s) {
            rates = rates.concat("{value:"+pc_jobdetail_3.getRate()+", name:'"+pc_jobdetail_3.getDetail_pos()+"'},");
        }
        rates = rates.substring(0,rates.length()-1);
        rates = rates.concat("]");
        pc_jobdetail_3Map.put("pc_jobdetail_3Data",rates);
        return pc_jobdetail_3Map;
    }
    @Test
    public void test(){
        System.out.println(queryPc_jobdetail_3Name("1").toString());
        return;
    }
}
