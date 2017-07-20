package com.ganpai.dao;

import com.ganpai.model.CommentDetailDO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:26
 */
public interface CommentDetailDao {

    long create(CommentDetailDO edo);

    int update(CommentDetailDO edo);

    List<CommentDetailDO> list(CommentDetailDO edo, long pageIndex, int pageSize);

    long count(CommentDetailDO edo);

    int deleteByPrimaryKey(Long id);

    CommentDetailDO queryByPrimaryKey(Long id);
}
