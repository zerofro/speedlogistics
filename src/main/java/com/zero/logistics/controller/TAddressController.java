package com.zero.logistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.logistics.entity.TAddress;
import com.zero.logistics.service.TAddressService;
import com.zero.logistics.util.LayPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TAddress)表控制层
 *
 * @author makejava
 * @since 2020-03-18 18:10:04
 */
@Controller
@RequestMapping("tAddress")
public class TAddressController {
    /**
     * 服务对象
     */
    @Resource
    private TAddressService tAddressService;

    @RequestMapping("saveAddress")
    @ResponseBody
    public Integer saveAddress(TAddress address){
        if (address.getAddressId() == null)
            tAddressService.insert(address);
        else
            tAddressService.update(address);
        return address.getAddressId();
    }

    @RequestMapping("getById")
    @ResponseBody
    public TAddress getById(Integer addressId){
        TAddress tAddress = tAddressService.queryById(addressId);
        return tAddress;
    }

    @RequestMapping("getAddressBook")
    @ResponseBody
    public List<TAddress> getAddressBook(Integer type, Integer customerId, String ownerName){
        List<TAddress> tAddresses = tAddressService.getAddressBook(type, customerId, ownerName);
        return tAddresses;
    }

    @RequestMapping("delById")
    @ResponseBody
    public boolean delById(Integer addressId){
        boolean flag = tAddressService.deleteById(addressId);
        return flag;
    }

    @RequestMapping("getPage")
    @ResponseBody
    public LayPage<TAddress> getPage(Integer page, Integer limit, String searchParams){
        TAddress tAddress = JSONObject.parseObject(searchParams, TAddress.class);
        LayPage<TAddress> layPage = tAddressService.getPage(page, limit, tAddress);
        return layPage;
    }

}