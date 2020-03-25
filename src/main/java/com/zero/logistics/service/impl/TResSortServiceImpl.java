package com.zero.logistics.service.impl;

import com.zero.logistics.dao.TResSortDao;
import com.zero.logistics.entity.TResSort;
import com.zero.logistics.service.TResSortService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TResSort)表服务实现类
 *
 * @author makejava
 * @since 2020-03-19 20:21:27
 */
@Service("tResSortService")
public class TResSortServiceImpl implements TResSortService {
    @Resource
    private TResSortDao tResSortDao;

    /**
     * 通过ID查询单条数据
     *
     * @param resSortId 主键
     * @return 实例对象
     */
    @Override
    public TResSort queryById(Integer resSortId) {
        return this.tResSortDao.queryById(resSortId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TResSort> queryAllByLimit(int offset, int limit) {
        return this.tResSortDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tResSort 实例对象
     * @return 实例对象
     */
    @Override
    public TResSort insert(TResSort tResSort) {
        this.tResSortDao.insert(tResSort);
        return tResSort;
    }

    /**
     * 修改数据
     *
     * @param tResSort 实例对象
     * @return 实例对象
     */
    @Override
    public TResSort update(TResSort tResSort) {
        this.tResSortDao.update(tResSort);
        return this.queryById(tResSort.getResSortId());
    }

    /**
     * 通过主键删除数据
     *
     * @param resSortId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer resSortId) {
        return this.tResSortDao.deleteById(resSortId) > 0;
    }
}