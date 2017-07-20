package com.ganpai.dao;

import com.ganpai.model.UpvoteDO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:26
 */
public interface UpvoteDao {

    long create(UpvoteDO edo);

    int update(UpvoteDO edo);

    List<UpvoteDO> list(UpvoteDO edo, long pageIndex, int pageSize);

    long count(UpvoteDO edo);

    int deleteByPrimaryKey(Long id);

    UpvoteDO queryByPrimaryKey(Long id);
}
