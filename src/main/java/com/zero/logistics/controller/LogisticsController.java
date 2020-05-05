package com.zero.logistics.controller;

import com.zero.logistics.dto.LogisticsAddDTO;
import com.zero.logistics.service.ILogisticsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    public boolean add(@RequestBody LogisticsAddDTO logisticsAddDTO){
        return false;
    }
}