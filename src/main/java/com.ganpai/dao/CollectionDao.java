package com.ganpai.dao;

import com.ganpai.model.CollectionDO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:26
 */
public interface CollectionDao {

    long create(CollectionDO edo);

    int update(CollectionDO edo);

    List<CollectionDO> list(CollectionDO edo, long pageIndex, int pageSize);

    long count(CollectionDO edo);

    int deleteByPrimaryKey(Long id);

    CollectionDO queryByPrimaryKey(Long id);
}
