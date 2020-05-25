package com.zero.logistics.service.impl;

import com.zero.logistics.entity.TFeedback;
import com.zero.logistics.dao.TFeedbackDao;
import com.zero.logistics.service.TFeedbackService;
import com.zero.logistics.util.LayPage;
import com.zero.logistics.vo.FeedBackVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (TFeedback)表服务实现类
 *
 * @author makejava
 * @since 2020-04-05 21:35:51
 */
@Service("tFeedbackService")
public class TFeedbackServiceImpl implements TFeedbackService {
    @Resource
    private TFeedbackDao tFeedbackDao;

    /**
     * 通过ID查询单条数据
     *
     * @param feedbackId 主键
     * @return 实例对象
     */
    @Override
    public TFeedback queryById(Integer feedbackId) {
        return this.tFeedbackDao.queryById(feedbackId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TFeedback> queryAllByLimit(int offset, int limit) {
        return this.tFeedbackDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tFeedback 实例对象
     * @return 实例对象
     */
    @Override
    public TFeedback insert(TFeedback tFeedback) {
        this.tFeedbackDao.insert(tFeedback);
        return tFeedback;
    }

    /**
     * 修改数据
     *
     * @param tFeedback 实例对象
     * @return 实例对象
     */
    @Override
    public TFeedback update(TFeedback tFeedback) {
        this.tFeedbackDao.update(tFeedback);
        return this.queryById(tFeedback.getFeedbackId());
    }

    /**
     * 通过主键删除数据
     *
     * @param feedbackId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer feedbackId) {
        return this.tFeedbackDao.deleteById(feedbackId) > 0;
    }

    @Override
    public LayPage<FeedBackVO> getPage(int page, int limit, FeedBackVO condition) {
        int count = tFeedbackDao.getCount(condition);
        List<FeedBackVO> data = tFeedbackDao.pageByVo((page - 1) * limit, limit, condition);
        LayPage<FeedBackVO> layPage = new LayPage<>(count, data);
        return layPage;
    }

    @Override
    public LayPage<TFeedback> getPage(int page, int limit, TFeedback condition) {
        return null;
    }

    @Override
    public boolean batchDelete(List ids) {
        return false;
    }

    @Override
    public boolean add(String feedbackContent, Integer customerId) {
        TFeedback tFeedback = new TFeedback();
        tFeedback.setCustomerId(customerId);
        tFeedback.setFeedbackContent(feedbackContent);
        tFeedback.setCreateTime(new Date());
        return tFeedbackDao.insert(tFeedback) > 0;
    }
}