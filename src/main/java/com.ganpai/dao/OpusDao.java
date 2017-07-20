package com.ganpai.dao;

import com.ganpai.model.OpusDO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:26
 */
public interface OpusDao {

    long create(OpusDO edo);

    int update(OpusDO edo);

    List<OpusDO> list(OpusDO edo, long pageIndex, int pageSize);

    long count(OpusDO edo);

    int deleteByPrimaryKey(Long id);

    OpusDO queryByPrimaryKey(Long id);
}
