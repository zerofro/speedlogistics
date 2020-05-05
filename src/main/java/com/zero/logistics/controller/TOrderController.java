package com.zero.logistics.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zero.logistics.constants.Constant;
import com.zero.logistics.dto.OrderTableDTO;
import com.zero.logistics.entity.TCustomer;
import com.zero.logistics.entity.TOrder;
import com.zero.logistics.entity.TStaff;
import com.zero.logistics.service.TOrderService;
import com.zero.logistics.util.LayPage;
import com.zero.logistics.vo.OrderDetailVO;
import com.zero.logistics.vo.OrderTableVO;
import com.zero.logistics.vo.OrdersVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public Integer commitOrder(@RequestBody TOrder order){
        return tOrderService.commitOrder(order);
    }

    @GetMapping("list/o_{state}")
    public List<TOrder> list(@PathVariable int state,HttpSession session){
        return tOrderService.list(((TCustomer)session.getAttribute(Constant.CUSTOMER)).getCustomerId(), state);
    }

    @GetMapping("cancel/o_{orderId}")
    public boolean cancel(@PathVariable int orderId){
        return tOrderService.cancel(orderId);
    }

    @GetMapping("listByDotId/o_{dotId}")
    public List<OrdersVO> listByDotId(@PathVariable int dotId){
        return tOrderService.listByDotId(dotId);
    }

    @PostMapping("ordersBatch")
    public boolean ordersBatch(@RequestParam String orderIdsStr, HttpSession session){
        JSONArray jsonArray = JSON.parseArray(orderIdsStr);
        List<Integer> orderIds = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            orderIds.add(jsonArray.getInteger(i));
        }
        TStaff staff = (TStaff) session.getAttribute(Constant.STAFF);
        return orderIds.size()==0?false:tOrderService.orderBatch(orderIds, staff.getDotId());
    }
}