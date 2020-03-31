package com.zero.logistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.logistics.entity.TStaff;
import com.zero.logistics.service.TStaffService;
import com.zero.logistics.utils.LayPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * (TStaff)表控制层
 *
 * @author makejava
 * @since 2020-03-28 20:46:10
 */
@RestController
@RequestMapping("tStaff")
public class TStaffController implements BaseController<TStaff> {
    /**
     * 服务对象
     */
    @Resource
    private TStaffService tStaffService;

    /**
     * 获取页内容
     * @param page
     * @param limit
     * @param searchParams
     * @return
     */
    @Override
    public LayPage<TStaff> getPage(Integer page, Integer limit, String searchParams) {
        TStaff tStaff = JSONObject.parseObject(searchParams, TStaff.class);
        LayPage layPage = tStaffService.getPage(page, limit, tStaff);
        return layPage;
    }

    @Override
    public boolean save(TStaff obj) {
        try {
            if (null != obj){
                if (null == obj.getStaffId())
                    tStaffService.insert(obj);
                else
                    tStaffService.update(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag = tStaffService.deleteById(id);
        return flag;
    }

    @Override
    public boolean batchDelete(Integer[] ids) {
        boolean flag = tStaffService.batchDelete(Arrays.asList(ids));
        return flag;
    }
}