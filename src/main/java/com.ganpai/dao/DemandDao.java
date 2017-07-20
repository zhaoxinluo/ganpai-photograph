package com.ganpai.dao;

import com.ganpai.model.DemandDO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:26
 */
public interface DemandDao {

    long create(DemandDO edo);

    int update(DemandDO edo);

    List<DemandDO> list(DemandDO edo, long pageIndex, int pageSize);

    long count(DemandDO edo);

    int deleteByPrimaryKey(Long id);

    DemandDO queryByPrimaryKey(Long id);
}
