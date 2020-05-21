package com.zero.logistics.controller;

import com.zero.logistics.constants.Constant;
import com.zero.logistics.dto.LogisticsAddDTO;
import com.zero.logistics.entity.TLogistics;
import com.zero.logistics.entity.TStaff;
import com.zero.logistics.service.ILogisticsService;
import com.zero.logistics.vo.LogisticsDetailVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

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

        TLogistics tLogistics = new TLogistics(logisticsAddDTO.getWaybillId(), staff.getStaffId(),
                logisticsAddDTO.getStartDotId(), logisticsAddDTO.getTargetDotId(),
                logisticsAddDTO.getLogisticsType());
        return logisticsService.insert(tLogistics).getLogisticsId() != null;
    }

    @GetMapping("listDetail/l_{waybillCode}")
    public List<LogisticsDetailVO> listDetail(@PathVariable String waybillCode){
        return logisticsService.listDetail(waybillCode);
    }
}