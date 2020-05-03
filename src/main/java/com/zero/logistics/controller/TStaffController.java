package com.zero.logistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.logistics.constants.Constant;
import com.zero.logistics.dto.StaffLoginDTO;
import com.zero.logistics.entity.TStaff;
import com.zero.logistics.service.TStaffService;
import com.zero.logistics.util.HttpRequestUtil;
import com.zero.logistics.util.LayPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * (TStaff)表控制层
 *
 * @author makejava
 * @since 2020-03-28 20:46:10
 */
@RestController
@RequestMapping("tStaff")
public class TStaffController {
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
    @RequestMapping("getPage")
    public LayPage<TStaff> getPage(Integer page, Integer limit, String searchParams) {
        TStaff tStaff = JSONObject.parseObject(searchParams, TStaff.class);
        LayPage layPage = tStaffService.getPage(page, limit, tStaff);
        return layPage;
    }

    @RequestMapping("save")
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

    @RequestMapping("delete")
    public boolean delete(Integer id) {
        boolean flag = tStaffService.deleteById(id);
        return flag;
    }

    @RequestMapping("batchDelete")
    public boolean batchDelete(Integer[] ids) {
        boolean flag = tStaffService.batchDelete(Arrays.asList(ids));
        return flag;
    }

    @RequestMapping("loginByWxId")
    public TStaff loginByWxId(String code, HttpSession session){
        //访问微信接口，获取openid
        String openid = getOpenId(code);
        if (null != openid){
            TStaff staff = tStaffService.queryByWxId(openid);
            if (null != staff)
                session.setAttribute(Constant.STAFF, staff);
            return staff;
        }
        return null;
    }

    /**
     * 获取微信openid
     * @param code
     * @return
     */
    private String getOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        String params = "appid="+ Constant.APPID+"&secret=" + Constant.SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        String result = HttpRequestUtil.sendGet(url, params);
        System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        return jsonObject.getString("openid");
    }

    @RequestMapping("loginByPwd")
    public TStaff loginByPwd(@RequestBody StaffLoginDTO staffLoginDTO, HttpSession session){
        TStaff staff = tStaffService.queryByPwd(staffLoginDTO);
        if (null!=staff){
            //账号密码匹配
            String openId = getOpenId(staffLoginDTO.getCode());
            staff.setWxId(openId);
            tStaffService.update(staff);
            session.setAttribute(Constant.STAFF, staff);
            return staff;
        }
        return null;
    }
}