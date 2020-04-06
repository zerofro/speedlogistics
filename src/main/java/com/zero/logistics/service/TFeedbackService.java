package com.zero.logistics.service;

import com.zero.logistics.entity.TFeedback;
import com.zero.logistics.util.LayPage;
import com.zero.logistics.vo.FeedBackVO;

/**
 * (TFeedback)表服务接口
 *
 * @author makejava
 * @since 2020-04-05 21:35:51
 */
public interface TFeedbackService extends BaseService<TFeedback> {
    public LayPage<FeedBackVO> getPage(int page, int limit, FeedBackVO condition);
}