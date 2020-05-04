package com.zero.logistics.speedlogistics;

import com.zero.logistics.dao.TDotDao;
import com.zero.logistics.dto.GeoDotDTO;
import com.zero.logistics.util.GeoApiUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpeedLogisticsApplicationTests {

    @Resource
    private TDotDao tDotDao;

    @Test
    public void contextLoads() {
        List<GeoDotDTO> dotList = tDotDao.getNearByAddressId(1);
        if (dotList.size() > 0){
            if (dotList.size() > 1){
                List<String> startAddrList = new ArrayList<>();
                dotList.forEach(d->startAddrList.add(d.getDotAddress()));
                int index = GeoApiUtil.getMinDistanceIndexByAddr(startAddrList, dotList.get(0).getEndAddress());
                System.out.println(index);
            }
        }
    }

}
