package com.zero.logistics.service;

import com.zero.logistics.dto.SignDTO;
import com.zero.logistics.entity.TSend;
import java.util.List;

/**
 * (TSend)表服务接口
 *
 * @author makejava
 * @since 2020-05-06 09:19:29
 */
public interface TSendService {

    /**
     * 通过ID查询单条数据
     *
     * @param sendId 主键
     * @return 实例对象
     */
    TSend queryById(Long sendId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TSend> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tSend 实例对象
     * @return 实例对象
     */
    TSend insert(TSend tSend);

    /**
     * 修改数据
     *
     * @param tSend 实例对象
     * @return 实例对象
     */
    TSend update(TSend tSend);

    /**
     * 通过主键删除数据
     *
     * @param sendId 主键
     * @return 是否成功
     */
    boolean deleteById(Long sendId);

    public boolean send(int orderId, int waybillId, int staffId);

    boolean sign(SignDTO signDTO);
}