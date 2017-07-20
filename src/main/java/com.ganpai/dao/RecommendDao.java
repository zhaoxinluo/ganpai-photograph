package com.ganpai.dao;

import com.ganpai.model.RecommendDO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:26
 */
public interface RecommendDao {

    long create(RecommendDO edo);

    int update(RecommendDO edo);

    List<RecommendDO> list(RecommendDO edo, long pageIndex, int pageSize);

    long count(RecommendDO edo);

    int deleteByPrimaryKey(Long id);

    RecommendDO queryByPrimaryKey(Long id);
}
