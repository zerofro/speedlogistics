package com.zero.logistics.controller;

import com.zero.logistics.constants.Constant;
import com.zero.logistics.dto.LogisticsAddDTO;
import com.zero.logistics.entity.TLogistics;
import com.zero.logistics.entity.TStaff;
import com.zero.logistics.service.ILogisticsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LogisticsController
 * @Description TODO
 * @Author 郑思华
 * @Date 2020/5/5 17:13
 * @Version 1.0
 */
@RestController
@RequestMapping("/logistics")
public class LogisticsController {
    @Resource
    private ILogisticsService logisticsService;

    @PostMapping("add")
    public boolean add(@RequestBody LogisticsAddDTO logisticsAddDTO, HttpSession session){
        TStaff staff = (TStaff) session.getAttribute(Constant.STAFF);
        if (logisticsAddDTO.getLogisticsType() == 0)
            logisticsAddDTO.setStartDotId(staff.getDotId());
        else if (logisticsAddDTO.getLogisticsType() == 1)
            logisticsAddDTO.setTargetDotId(staff.getDotId());

        TLogistics tLogistics = new TLogistics(logisticsAddDTO.getWaybillId(), staff.getStaffId(), logisticsAddDTO.getStartDotId(), logisticsAddDTO.getTargetDotId(), logisticsAddDTO.getLogisticsType());
        return logisticsService.insert(tLogistics).getLogisticsId() != null;
    }
}