package com.zero.logistics.dao;

import com.zero.logistics.dto.SignDTO;
import com.zero.logistics.entity.TSend;
import com.zero.logistics.vo.SendVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TSend)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-06 16:39:01
 */
public interface TSendDao {

    /**
     * 通过ID查询单条数据
     *
     * @param sendId 主键
     * @return 实例对象
     */
    TSend queryById(Long sendId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TSend> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tSend 实例对象
     * @return 对象列表
     */
    List<TSend> queryAll(TSend tSend);

    /**
     * 新增数据
     *
     * @param tSend 实例对象
     * @return 影响行数
     */
    int insert(TSend tSend);

    /**
     * 修改数据
     *
     * @param tSend 实例对象
     * @return 影响行数
     */
    int update(TSend tSend);

    /**
     * 通过主键删除数据
     *
     * @param sendId 主键
     * @return 影响行数
     */
    int deleteById(Long sendId);

    /**
     * 根据运单id获取派件信息
     * @param waybillId
     * @return
     */
    public SendVO getByWaybillId(int waybillId);

    /**
     * 签收
     * @param signDTO
     * @return
     */
    public int sign(SignDTO signDTO);
}