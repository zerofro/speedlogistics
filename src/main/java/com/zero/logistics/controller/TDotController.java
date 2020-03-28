package com.zero.logistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.logistics.entity.TDot;
import com.zero.logistics.service.TDotService;
import com.zero.logistics.utils.LayPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * (TDot)表控制层
 *
 * @author makejava
 * @since 2020-03-22 20:17:55
 */
@RestController
@RequestMapping("tDot")
public class TDotController {
    /**
     * 服务对象
     */
    @Resource
    private TDotService tDotService;

    /**
     * 保存网点的信息
     * @param tDot
     * @return
     */
    @RequestMapping("save")
    public boolean save(TDot tDot){
        try {
            if (null != tDot){
                if (null == tDot.getDotId())
                    tDotService.insert(tDot);
                else
                    tDotService.update(tDot);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 获取页内容
     * @param page
     * @param limit
     * @param searchParams
     * @return
     */
    @RequestMapping("getPage")
    public LayPage<TDot> getPage(Integer page, Integer limit, String searchParams){
        TDot tDot = JSONObject.parseObject(searchParams, TDot.class);
        LayPage<TDot> layPage = tDotService.getPage(page, limit, tDot);
        return layPage;
    }

    /**
     * 删除单条记录
     * @param dotId
     * @return
     */
    @RequestMapping("delete")
    public boolean delete(Integer dotId){
        boolean flag = tDotService.deleteById(dotId);
        return flag;
    }

    @RequestMapping("batchDelete")
    public boolean batchDelete(Integer[] dotIds){
        boolean flag = tDotService.batchDelete(Arrays.asList(dotIds));
        return flag;
    }
}