package com.zero.logistics.util;

import java.util.List;

/**
 * @ClassName LayPage
 * @Description TODO
 * @Author zero
 * @Date 2020/3/25 15:17
 * @Version 1.0
 */
public class LayPage<T> {
    private String code;
    private String msg;
    private Integer count;
    private List<T> data;

    public LayPage() {
    }

    public LayPage(Integer count, List<T> data) {
        this.code = "0";
        this.msg = "true";
        this.count = count;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}