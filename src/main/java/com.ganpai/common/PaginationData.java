package com.ganpai.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by luyunfei on 17/04/2017.
 * 分页查询封装类
 * 用于前端分页查询时, 返回给前端的记录信息。可以单独使用，也可与ResponseResult配合使用
 */
public class PaginationData<T> implements Serializable {
    /**
     * 返回的记录
     */
    private List<T> rows;
    /**
     * 记录的总条数(例如: 数据库表中总共有10W条数据)
     */
    private long total;
    /**
     * 请求第几页数据(例如: 请求第5页记录)
     */
    private int pageIndex;
    /**
     * 请求一页返回多少条记录(例如: 请求每页显示50条记录)
     */
    private int pageSize;

    public PaginationData(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
