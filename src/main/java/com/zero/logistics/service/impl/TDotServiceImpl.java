package com.zero.logistics.service.impl;

import com.zero.logistics.entity.TDot;
import com.zero.logistics.dao.TDotDao;
import com.zero.logistics.service.TDotService;
import com.zero.logistics.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TDot)表服务实现类
 *
 * @author makejava
 * @since 2020-03-22 20:17:55
 */
@Service("tDotService")
public class TDotServiceImpl implements TDotService {
    @Resource
    private TDotDao tDotDao;

    /**
     * 通过ID查询单条数据
     *
     * @param dotId 主键
     * @return 实例对象
     */
    @Override
    public TDot queryById(Integer dotId) {
        return this.tDotDao.queryById(dotId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TDot> queryAllByLimit(int offset, int limit) {
        return this.tDotDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tDot 实例对象
     * @return 实例对象
     */
    @Override
    public TDot insert(TDot tDot) {
        this.tDotDao.insert(tDot);
        return tDot;
    }

    /**
     * 修改数据
     *
     * @param tDot 实例对象
     * @return 实例对象
     */
    @Override
    public TDot update(TDot tDot) {
        this.tDotDao.update(tDot);
        return this.queryById(tDot.getDotId());
    }

    /**
     * 通过主键删除数据
     *
     * @param dotId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer dotId) {
        return this.tDotDao.deleteById(dotId) > 0;
    }

    @Override
    public Page<TDot> getPage(int pageNum, int pageSize, String condition) {
        int count = tDotDao.getCount(condition);
        List<TDot> list = tDotDao.pageByCondition((pageNum - 1) * pageSize, pageSize, condition);
        Page<TDot> page = new Page<>(pageNum, pageSize, count, list);
        return page;
    }
}