package com.zero.logistics.dao;

import com.zero.logistics.entity.TFeedback;
import com.zero.logistics.vo.FeedBackVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TFeedback)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-05 21:35:51
 */
public interface TFeedbackDao extends BaseDao<TFeedback> {

    public List<FeedBackVO> pageByVo(@Param("startRow") int startRow, @Param("pageSize") int pageSize,
                                     @Param("condition") Object condition);
}