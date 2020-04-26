package com.zero.logistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.logistics.dto.OrderTableDTO;
import com.zero.logistics.entity.TOrder;
import com.zero.logistics.service.TOrderService;
import com.zero.logistics.util.LayPage;
import com.zero.logistics.vo.OrderDetailVO;
import com.zero.logistics.vo.OrderTableVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * (TOrder)表控制层
 *
 * @author makejava
 * @since 2020-04-04 16:43:04
 */
@RestController
@RequestMapping("tOrder")
public class TOrderController {
    /**
     * 服务对象
     */
    @Resource
    private TOrderService tOrderService;


    /**
     * 获取页内容
     * @param page
     * @param limit
     * @param searchParams
     * @return
     */
    @RequestMapping("getPage")
    public LayPage<OrderTableVO> getPage(Integer page, Integer limit, String searchParams) {
        OrderTableDTO condition = JSONObject.parseObject(searchParams, OrderTableDTO.class);
        LayPage layPage = tOrderService.getPage(page, limit, condition);
        return layPage;
    }

    @RequestMapping("save")
    public boolean save(TOrder obj) {
        try {
            if (null != obj){
                if (null == obj.getOrderId())
                    tOrderService.insert(obj);
                else
                    tOrderService.update(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @RequestMapping("getDetail")
    public OrderDetailVO getDetail(Integer orderId){
        OrderDetailVO detail = tOrderService.getDetail(orderId);
        return detail;
    }

    @RequestMapping("delete")
    public boolean delete(Integer id) {
        boolean flag = tOrderService.deleteById(id);
        return flag;
    }

    @RequestMapping("batchDelete")
    public boolean batchDelete(Integer[] ids) {
        boolean flag = tOrderService.batchDelete(Arrays.asList(ids));
        return flag;
    }

    @PostMapping("commitOrder")
    public boolean commitOrder(@RequestBody TOrder order){
        return tOrderService.commitOrder(order);
    }
}