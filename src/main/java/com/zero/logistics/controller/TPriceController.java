package com.zero.logistics.controller;

import com.zero.logistics.entity.TPrice;
import com.zero.logistics.service.TPriceService;
import com.zero.logistics.utils.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * (TPrice)表控制层
 *
 * @author makejava
 * @since 2020-03-24 20:55:05
 */
@Controller
@RequestMapping("tPrice")
public class TPriceController {
    /**
     * 服务对象
     */
    @Resource
    private TPriceService tPriceService;

    @RequestMapping("add")
    public String add(TPrice tPrice){
        tPriceService.insert(tPrice);
        return "redirect:/priceList";
    }

    @RequestMapping("getPage")
    @ResponseBody
    public Page<TPrice> getPage(Integer pageNum, String condition){
        Page<TPrice> page = tPriceService.getPage(pageNum, 10, condition);
        return page;
    }
}