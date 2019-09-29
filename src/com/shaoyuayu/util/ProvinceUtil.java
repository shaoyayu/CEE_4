package com.shaoyuayu.util;

import com.shaoyuayu.entity.Batchs;
import com.shaoyuayu.entity.Local;
import com.shaoyuayu.service.BatchsService;
import com.shaoyuayu.service.impl.BatchsServiceImpl;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ProvinceUtil {
    /**
     * 控档分数线数据
     * @param local
     * @param i 0，全部 1，添加18年，和17年
     * @param request
     * @return
     */
    public static HttpServletRequest uploadBatchsData(String local, int i,  HttpServletRequest request){
        BatchsService batchsService = new BatchsServiceImpl();

        List<Batchs> batches2018 = batchsService.localQueryBachs(local,2018);
        List<Batchs> batches2017 = batchsService.localQueryBachs(local,2017);
        request.setAttribute("batches2018",batches2018);
        request.setAttribute("batches2017",batches2017);
        if (i==0){
            List<Batchs> batches2016 = batchsService.localQueryBachs(local,2016);
            List<Batchs> batches2015 = batchsService.localQueryBachs(local,2015);
            List<Batchs> batches2014 = batchsService.localQueryBachs(local,2014);
            request.setAttribute("batches2016",batches2016);
            request.setAttribute("batches2015",batches2015);
            request.setAttribute("batches2014",batches2014);
        }
        return request;
    }

}
