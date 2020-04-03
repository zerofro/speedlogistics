package com.zero.logistics.controller;

import com.zero.logistics.entity.TPrice;
import com.zero.logistics.service.TPriceService;
import com.zero.logistics.utils.LayPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (TPrice)表控制层
 *
 * @author makejava
 * @since 2020-03-31 21:17:58
 */
@RestController
@RequestMapping("tPrice")
public class TPriceController {
    /**
     * 服务对象
     */
    @Resource
    private TPriceService tPriceService;

    @RequestMapping("getPage")
    public LayPage<TPrice> getPage(Integer page, Integer limit, String province) {
        LayPage<TPrice> layPage = null;
        if (null != province && "" != province){
            TPrice tPrice = tPriceService.queryByProvince(province);
            List<TPrice> data = new ArrayList<>();
            if (null != tPrice)
                data.add(tPrice);
            layPage = new LayPage<>(1, data);
        }else
            layPage = tPriceService.getPage(page, limit, null);
        return layPage;
    }

    @RequestMapping("save")
    public Integer save(TPrice obj) {
        try {
            if (null != obj){
                if (null == obj.getPriceId()){
                    //判断是否存在该省份的数据
                    TPrice tPrice = tPriceService.queryByProvince(obj.getProvince());
                    //存在
                    if (null != tPrice)
                        return -1;
                    //不存在
                    tPriceService.insert(obj);
                }
                else
                    tPriceService.update(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @RequestMapping("delete")
    public boolean delete(Integer id) {
        boolean flag = tPriceService.deleteById(id);
        return flag;
    }

    @RequestMapping("batchDelete")
    public boolean batchDelete(Integer[] ids) {
        boolean flag = tPriceService.batchDelete(Arrays.asList(ids));
        return flag;
    }
}