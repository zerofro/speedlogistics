package com.zero.logistics.controller;

import com.zero.logistics.constants.Constant;
import com.zero.logistics.entity.TAdmin;
import com.zero.logistics.service.TAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * (TAdmin)表控制层
 *
 * @author makejava
 * @since 2020-04-26 09:49:37
 */
@Controller
@RequestMapping("tAdmin")
public class TAdminController {
    /**
     * 服务对象
     */
    @Resource
    private TAdminService tAdminService;

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute(Constant.ADMIN);
        return "/sys/login";
    }

    @PostMapping("login")
    @ResponseBody
    public boolean login(TAdmin tAdmin, HttpSession session){
        TAdmin admin = tAdminService.login(tAdmin);
        if (null != admin){
            session.setAttribute(Constant.ADMIN, admin);
            return true;
        }
        return false;
    }
}