package com.zero.logistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.logistics.service.TFeedbackService;
import com.zero.logistics.util.LayPage;
import com.zero.logistics.vo.FeedBackVO;
import com.zero.logistics.vo.OrderTableVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (TFeedback)表控制层
 *
 * @author makejava
 * @since 2020-04-05 21:35:51
 */
@RestController
@RequestMapping("tFeedback")
public class TFeedbackController {
    /**
     * 服务对象
     */
    @Resource
    private TFeedbackService tFeedbackService;

    @RequestMapping("getPage")
    public LayPage<OrderTableVO> getPage(Integer page, Integer limit, String searchParams) {
        FeedBackVO condition = JSONObject.parseObject(searchParams, FeedBackVO.class);
        LayPage layPage = tFeedbackService.getPage(page, limit, condition);
        return layPage;
    }
}