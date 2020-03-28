package com.zero.logistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.logistics.entity.TDot;
import com.zero.logistics.service.TDotService;
import com.zero.logistics.utils.LayPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * (TDot)表控制层
 *
 * @author makejava
 * @since 2020-03-22 20:17:55
 */
@Controller
@RequestMapping("tDot")
public class TDotController {
    /**
     * 服务对象
     */
    @Resource
    private TDotService tDotService;

    @RequestMapping("add")
    @ResponseBody
    public boolean add(TDot tDot){
        try {
            tDotService.insert(tDot);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @RequestMapping("getPage")
    @ResponseBody
    public LayPage<TDot> getPage(Integer page, Integer limit, String searchParams){
        TDot tDot = JSONObject.parseObject(searchParams, TDot.class);
        LayPage<TDot> layPage = tDotService.getPage(page, limit, tDot);
        return layPage;
    }

    @RequestMapping("toEdit")
    public String toModify(Integer dotId, Model model){
        TDot tDot = tDotService.queryById(dotId);
        model.addAttribute("dot", tDot);
        return "dot/edit";
    }

    @RequestMapping("doModify")
    public String doModify(TDot tDot){
        tDotService.update(tDot);
        return "redirect:/dotList";
    }

    @RequestMapping("delete")
    @ResponseBody
    public boolean delete(Integer dotId){
        boolean flag = tDotService.deleteById(dotId);
        return flag;
    }
}