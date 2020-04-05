package com.zero.logistics.util;

import java.util.List;

/**
 * @ClassName Page
 * @Description TODO
 * @Author zero
 * @Date 2020/2/8 16:35
 * @Version 1.0
 */
public class Page<T> {
    private int pageNum;    //指定页数
    private int pageSize;   //页内最大记录数
    private int count;      //总记录条数
    private int totalPage;  //总页数
    private List<T> list;   //数据列表

    public Page() {
    }

    public Page(int pageNum, int pageSize, int count, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.count = count;
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPage() {
        return count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}