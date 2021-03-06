package com.zero.logistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.logistics.constants.Constant;
import com.zero.logistics.entity.TLogistics;
import com.zero.logistics.entity.TStaff;
import com.zero.logistics.service.TWaybillService;
import com.zero.logistics.util.LayPage;
import com.zero.logistics.vo.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    @GetMapping("listPackage")
    public List<StaffPackageVO> listPackage(HttpSession session){
        TStaff staff = (TStaff) session.getAttribute(Constant.STAFF);
        return tWaybillService.listPackage(staff.getDotId());
    }

    @GetMapping("packageDetail/w_{waybillId}")
    public PackageDetailVO packageDetail(@PathVariable int waybillId){
        return tWaybillService.packageDetail(waybillId);
    }

    @GetMapping("getDetailByCode/w_{code}")
    public PackageDetailVO getDetailByCode(@PathVariable String code){
        return tWaybillService.getDetailByCode(code);
    }

    @PostMapping("doPackage")
    public boolean doPackage(@RequestParam("orderId") Integer orderId ,@RequestParam("waybillId") Integer waybillId, HttpSession session){
        TStaff staff = (TStaff) session.getAttribute(Constant.STAFF);
        TLogistics tLogistics = new TLogistics(waybillId, staff.getStaffId(), null, staff.getDotId(), -1);
        return tWaybillService.doPackage(orderId, tLogistics);
    }

    @GetMapping("getByCode/w_{waybillCode}")
    public WaybillListVO getByCode(@PathVariable String waybillCode){
        return tWaybillService.getByCode(waybillCode);
    }

    @GetMapping("checkCode/w_{waybillCode}")
    public Integer checkCode(@PathVariable String waybillCode){
        return tWaybillService.checkCode(waybillCode);
    }
}