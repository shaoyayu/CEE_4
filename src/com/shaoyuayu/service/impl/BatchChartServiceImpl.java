package com.shaoyuayu.service.impl;


import com.shaoyuayu.dao.BatchsDao;
import com.shaoyuayu.dao.impl.BatchsDaoImpl;
import com.shaoyuayu.entity.Batchs;
import com.shaoyuayu.service.BatchChartService;

import java.util.ArrayList;
import java.util.List;

public class BatchChartServiceImpl implements BatchChartService {
    @Override
    public String queryLocalBatch(String local) {
        BatchsDao batchsDao = new BatchsDaoImpl();
        List<Batchs> batches2018 = batchsDao.localQueryBachs(local,2018);
        List<Batchs> batches2017 = batchsDao.localQueryBachs(local,2017);
        List<Batchs> batches2016 = batchsDao.localQueryBachs(local,2016);
        List<Batchs> batches2015 = batchsDao.localQueryBachs(local,2015);
        List<Batchs> batches2014 = batchsDao.localQueryBachs(local,2014);
        int[] ints2018 = paixun(batches2018);
        int[] ints2017 = paixun(batches2017);
        int[] ints2016 = paixun(batches2016);
        int[] ints2015 = paixun(batches2015);
        int[] ints2014 = paixun(batches2014);
        String str = "['product', '理科-本科一批', '理科-本科二批', '文科-本科一批', '文科-本科二批'],\n";
        String s = "";
        if (ints2018==null||ints2018.length==0){
            s=s.concat("['2018',0,0,0,0],\n");
        }else {
            s=s.concat("['2018',"+ints2018[0]+","+ints2018[1]+","+ints2018[2]+","+ints2018[3]+","+"],\n");
        }
        str = str.concat(s);
        s = "";
        if (ints2017==null||ints2017.length==0){
            s=s.concat("['2017',0,0,0,0],\n");
        }else {
            s=s.concat("['2017',"+ints2017[0]+","+ints2017[1]+","+ints2017[2]+","+ints2017[3]+","+"],\n");
        }
        str = str.concat(s);
        s = "";
        if (ints2016==null||ints2016.length==0){
            s=s.concat("['2016',0,0,0,0],\n");
        }else {
            s=s.concat("['2016',"+ints2016[0]+","+ints2016[1]+","+ints2016[2]+","+ints2016[3]+","+"],\n");
        }
        str = str.concat(s);
        s = "";
        if (ints2015==null||ints2015.length==0){
            s=s.concat("['2015',0,0,0,0],\n");
        }else {
            s=s.concat("['2015',"+ints2015[0]+","+ints2015[1]+","+ints2015[2]+","+ints2015[3]+","+"],\n");
        }
        str = str.concat(s);
        s = "";
        if (ints2014==null||ints2014.length==0){
            s=s.concat("['2014',0,0,0,0],\n");
        }else {
            s=s.concat("['2014',"+ints2014[0]+","+ints2014[1]+","+ints2014[2]+","+ints2014[3]+","+"]\n");
        }
        str = str.concat(s);
        s = "";
        return str;
    }
    public int[] paixun(List<Batchs> batches){
        int[] ints = new int[4];
        List<Integer> integersLK = new ArrayList<>();
        List<Integer> integersWK = new ArrayList<>();
        List<Integer> integersQT = new ArrayList<>();
        for (int i = 0; i < batches.size(); i++) {
            if (batches.get(i).getWl().equals("理科")){
                //integersLK.add(Integer.valueOf(batches.get(i).getMINscore()));
                integersLK.add(Integer.valueOf(batches.get(i).getMINscore()));
            }else if (batches.get(i).getWl().equals("文科")){
                integersWK.add(Integer.valueOf(batches.get(i).getMINscore()));
            }else {
                integersQT.add(Integer.valueOf(batches.get(i).getMINscore()));
            }
        }
        integersLK = getRankInts(integersLK);
        integersWK = getRankInts(integersWK);
        if (getInt(integersLK)==null||getInt(integersWK)==null){
            return null;
        }
        ints[0] = getInt(integersLK)[0];
        ints[1] = getInt(integersLK)[1];
        ints[2] = getInt(integersWK)[0];
        ints[3] = getInt(integersWK)[1];
        return ints;
    }
    public List<Integer> getRankInts(List<Integer> integers){
        if (integers.size()==0){
            return integers;
        }
        for (int i = 0; i < integers.size(); i++) {
            for (int j = 0; j < integers.size()-1-i; j++) {
                if (integers.get(j+1)<integers.get(j)){
                    int temp = integers.get(j+1);
                    integers.set(j+1,integers.get(j));
                    integers.set(j,temp);
                }
            }
        }
        return integers;
    }
    public int[] getInt(List<Integer> integers){
        int[] iii = new int[2];
        if (integers.size()>=2){
            iii[0] = integers.get(integers.size()-1);
            iii[1] = integers.get(integers.size()-2);
            return iii;
        }else {
            return iii;
        }
    }
}
