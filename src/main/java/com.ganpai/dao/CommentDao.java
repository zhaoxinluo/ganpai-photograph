package com.ganpai.dao;

import com.ganpai.model.CommentDO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:26
 */
public interface CommentDao {

    long create(CommentDO edo);

    int update(CommentDO edo);

    List<CommentDO> list(CommentDO edo, long pageIndex, int pageSize);

    long count(CommentDO edo);

    int deleteByPrimaryKey(Long id);

    CommentDO queryByPrimaryKey(Long id);
}
