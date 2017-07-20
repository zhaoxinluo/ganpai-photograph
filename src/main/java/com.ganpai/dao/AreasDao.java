package com.ganpai.dao;

import com.ganpai.model.AreasDO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:26
 */
public interface AreasDao {

    int create(AreasDO edo);

    int update(AreasDO edo);

    List<AreasDO> list(AreasDO edo, long pageIndex, int pageSize);

    long count(AreasDO edo);

    int deleteByPrimaryKey(Integer id);

    AreasDO queryByPrimaryKey(Integer id);
}
