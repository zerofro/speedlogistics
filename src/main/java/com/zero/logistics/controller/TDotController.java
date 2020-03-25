package com.zero.logistics.controller;

import com.zero.logistics.entity.TDot;
import com.zero.logistics.service.TDotService;
import com.zero.logistics.utils.Page;
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
    public String add(TDot tDot){
        tDotService.insert(tDot);
        return "redirect:/dotList";
    }

    @RequestMapping("getPage")
    @ResponseBody
    public Page<TDot> getPage(Integer pageNum, String condition){
        Page<TDot> page = tDotService.getPage(pageNum, 10, condition);
        return page;
    }

    @RequestMapping("toModify")
    public String toModify(Integer dotId, Model model){
        TDot tDot = tDotService.queryById(dotId);
        model.addAttribute("dot", tDot);
        return "/dot/modify";
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