package com.zero.logistics.service.impl;

import com.zero.logistics.dao.TLogisticsDao;
import com.zero.logistics.entity.TLogistics;
import com.zero.logistics.service.ILogisticsService;
import com.zero.logistics.util.LayPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TLogistics)表服务实现类
 *
 * @author makejava
 * @since 2020-05-05 17:16:26
 */
@Service("tLogisticsService")
public class TLogisticsServiceImpl implements ILogisticsService {
    @Resource
    private TLogisticsDao tLogisticsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param logisticsId 主键
     * @return 实例对象
     */
    @Override
    public TLogistics queryById(Integer logisticsId) {
        return this.tLogisticsDao.queryById(logisticsId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TLogistics> queryAllByLimit(int offset, int limit) {
        return this.tLogisticsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tLogistics 实例对象
     * @return 实例对象
     */
    @Override
    public TLogistics insert(TLogistics tLogistics) {
        this.tLogisticsDao.insert(tLogistics);
        return tLogistics;
    }

    /**
     * 修改数据
     *
     * @param tLogistics 实例对象
     * @return 实例对象
     */
    @Override
    public TLogistics update(TLogistics tLogistics) {
        this.tLogisticsDao.update(tLogistics);
        return this.queryById(tLogistics.getLogisticsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param logisticsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer logisticsId) {
        return this.tLogisticsDao.deleteById(logisticsId) > 0;
    }

    @Override
    public LayPage<TLogistics> getPage(int page, int limit, TLogistics condition) {
        return null;
    }

    @Override
    public boolean batchDelete(List ids) {
        return false;
    }
}