package com.zero.logistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.logistics.constants.Constant;
import com.zero.logistics.dto.CustomerIdentityDTO;
import com.zero.logistics.entity.TCustomer;
import com.zero.logistics.service.TCustomerService;
import com.zero.logistics.util.HttpRequestUtil;
import com.zero.logistics.util.LayPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * (TCustomer)表控制层
 *
 * @author makejava
 * @since 2020-03-17 18:18:20
 */
@Controller
@RequestMapping("tCustomer")
public class TCustomerController {
    /**
     * 服务对象
     */
    @Resource
    private TCustomerService tCustomerService;
    @Resource
    private HttpRequestUtil httpRequestUtil;

    @RequestMapping("login")
    @ResponseBody
    public TCustomer login(String code, HttpSession session){
        //访问微信接口，获取openid
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        String params = "appid="+ Constant.APPID+"&secret=" + Constant.SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        String result = httpRequestUtil.sendGet(url, params);
        System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String openid = jsonObject.getString("openid");
        //判断该用户是否是新用户
        if (openid!=null){
            TCustomer tCustomer = tCustomerService.queryByWxId(openid);
            if (tCustomer == null){
                //添加新用户
                tCustomer = new TCustomer();
                tCustomer.setWxId(openid);
                tCustomerService.insert(tCustomer);
            }
            session.setAttribute(Constant.CUSTOMER, tCustomer);
            return tCustomer;
        }
        return null;
    }

    @RequestMapping("setWxName")
    @ResponseBody
    public boolean setWxName(TCustomer tCustomer){
        if (tCustomer == null || tCustomer.getWxName() == null)
            return false;
        boolean flag = tCustomerService.setWxName(tCustomer);
        return flag;
    }

    @RequestMapping("getPage")
    @ResponseBody
    public LayPage<TCustomer> getPage(Integer page, Integer limit, String searchParams){
        TCustomer tCustomer = JSONObject.parseObject(searchParams, TCustomer.class);
        LayPage<TCustomer> layPage = tCustomerService.getPage(page, limit, tCustomer);
        return layPage;
    }


    @RequestMapping("doEdit")
    @ResponseBody
    public boolean doModify(TCustomer tCustomer){
        try {
            tCustomerService.update(tCustomer);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(Integer customerId){
        boolean flag = tCustomerService.deleteById(customerId);
        return flag;
    }

    @RequestMapping("batchDelete")
    @ResponseBody
    public boolean batchDelete(Integer[] customerIds){
        if (null == customerIds || customerIds.length == 0)
            return false;
        List<Integer> customerIdList = Arrays.asList(customerIds);
        boolean flag = tCustomerService.batchDelete(customerIdList);
        return flag;
    }

    @PostMapping("bindPhone")
    @ResponseBody
    public boolean bindPhone(@RequestBody String phone, HttpSession session){
        TCustomer customer = (TCustomer) session.getAttribute(Constant.CUSTOMER);
        if (tCustomerService.modifyPhone(phone, customer.getCustomerId())){
            customer.setCustomerPhone(phone);
            session.setAttribute(Constant.CUSTOMER, customer);
            return true;
        }
        return false;
    }

    @PostMapping("realIdentity")
    @ResponseBody
    public boolean realIdentity(@RequestBody CustomerIdentityDTO customerIdentityDTO, HttpSession session){
        TCustomer customer = (TCustomer) session.getAttribute(Constant.CUSTOMER);
        customerIdentityDTO.setCustomerId(customer.getCustomerId());
        if (tCustomerService.realIdentity(customerIdentityDTO)){
            customer.setRealName(customerIdentityDTO.getRealName());
            customer.setRealNum(customerIdentityDTO.getRealNum());
            session.setAttribute(Constant.CUSTOMER, customer);
            return true;
        }
        return false;
    }
}