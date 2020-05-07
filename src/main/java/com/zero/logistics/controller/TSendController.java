package com.zero.logistics.controller;

import com.zero.logistics.constants.Constant;
import com.zero.logistics.dto.SignDTO;
import com.zero.logistics.entity.TStaff;
import com.zero.logistics.service.TSendService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * (TSend)表控制层
 *
 * @author makejava
 * @since 2020-05-06 09:19:29
 */
@RestController
@RequestMapping("tSend")
public class TSendController {
    /**
     * 服务对象
     */
    @Resource
    private TSendService tSendService;

    @PostMapping("send")
    public boolean send(@RequestParam("orderId") int orderId, @RequestParam("waybillId") int waybillId, HttpSession session){
        TStaff staff = (TStaff) session.getAttribute(Constant.STAFF);
        return tSendService.send(orderId, waybillId, staff.getStaffId());
    }

    @PostMapping("sign")
    public boolean sign(@RequestBody SignDTO signDTO){
        return tSendService.sign(signDTO);
    }
}