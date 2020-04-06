package com.zero.logistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.logistics.service.TWaybillService;
import com.zero.logistics.util.LayPage;
import com.zero.logistics.vo.OrderTableVO;
import com.zero.logistics.vo.WaybillDetailVO;
import com.zero.logistics.vo.WaybillTableVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (TWaybill)表控制层
 *
 * @author makejava
 * @since 2020-04-05 16:10:21
 */
@RestController
@RequestMapping("tWaybill")
public class TWaybillController {
    /**
     * 服务对象
     */
    @Resource
    private TWaybillService tWaybillService;

    /**
     * 获取页内容
     * @param page
     * @param limit
     * @param searchParams
     * @return
     */
    @RequestMapping("getPage")
    public LayPage<OrderTableVO> getPage(Integer page, Integer limit, String searchParams) {
        WaybillTableVO condition = JSONObject.parseObject(searchParams, WaybillTableVO.class);
        LayPage layPage = tWaybillService.getPage(page, limit, condition);
        return layPage;
    }

    @RequestMapping("getDetail")
    public WaybillDetailVO getDetail(Integer waybillId){
        if (waybillId == null)
            return null;
        WaybillDetailVO detail = tWaybillService.getDetail(waybillId);
        return detail;
    }
}