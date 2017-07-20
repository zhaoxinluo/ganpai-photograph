package com.ganpai.dao;

import com.ganpai.model.ProvincesDO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:26
 */
public interface ProvincesDao {

    int create(ProvincesDO edo);

    int update(ProvincesDO edo);

    List<ProvincesDO> list(ProvincesDO edo, long pageIndex, int pageSize);

    long count(ProvincesDO edo);

    int deleteByPrimaryKey(Integer id);

    ProvincesDO queryByPrimaryKey(Integer id);
}
