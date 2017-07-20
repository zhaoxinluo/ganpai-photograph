package com.ganpai.dao;

import com.ganpai.model.CitiesDO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:26
 */
public interface CitiesDao {

    int create(CitiesDO edo);

    int update(CitiesDO edo);

    List<CitiesDO> list(CitiesDO edo, long pageIndex, int pageSize);

    long count(CitiesDO edo);

    int deleteByPrimaryKey(Integer id);

    CitiesDO queryByPrimaryKey(Integer id);
}
