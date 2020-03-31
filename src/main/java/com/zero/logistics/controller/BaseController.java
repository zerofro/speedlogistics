package com.zero.logistics.controller;

import com.zero.logistics.utils.LayPage;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Author zero
 * @Date 2020/3/29 11:13
 * @Version 1.0
 */
public interface BaseController<T> {

    @RequestMapping("getPage")
    public LayPage<T> getPage(Integer page, Integer limit, String searchParams);

    @RequestMapping("save")
    public boolean save(T obj);

    @RequestMapping("delete")
    public boolean delete(Integer id);

    @RequestMapping("batchDelete")
    public boolean batchDelete(Integer[] ids);
}
