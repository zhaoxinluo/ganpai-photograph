package com.ganpai.dao;

import com.ganpai.model.AttentionDO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:26
 */
public interface AttentionDao {

    long create(AttentionDO edo);

    int update(AttentionDO edo);

    List<AttentionDO> list(AttentionDO edo, long pageIndex, int pageSize);

    long count(AttentionDO edo);

    int deleteByPrimaryKey(Long id);

    AttentionDO queryByPrimaryKey(Long id);
}
