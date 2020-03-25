package com.zero.logistics.controller;

import com.zero.logistics.entity.TResSort;
import com.zero.logistics.service.TResSortService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TResSort)表控制层
 *
 * @author makejava
 * @since 2020-03-19 20:21:27
 */
@RestController
@RequestMapping("tResSort")
public class TResSortController {
    /**
     * 服务对象
     */
    @Resource
    private TResSortService tResSortService;

    @RequestMapping("listAll")
    public List<TResSort> listAll(){
        List<TResSort> tResSorts = tResSortService.queryAllByLimit(0, 30);
        return tResSorts;
    }
}