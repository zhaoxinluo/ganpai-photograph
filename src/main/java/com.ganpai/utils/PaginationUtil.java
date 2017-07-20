package com.ganpai.utils;

/**
 * Created by luyunfei on 21/04/2017.
 * 分页工具
 */
public class PaginationUtil {

    private static final int defaultPageSize = 50;

    /**
     * 通过页码(1开始), 页面尺寸 来获得SQL查询的开始记录索引
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public static long getDbStartIndex(int pageIndex, int pageSize) {

        long result = pageIndex > 0 ? (pageIndex - 1) * pageSize : pageSize;

        return result;
    }
}
