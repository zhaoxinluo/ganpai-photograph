package com.ganpai.dao.impl;

import com.ganpai.dao.CommentDetailDao;
import com.ganpai.mapper.CommentDetailDOMapper;
import com.ganpai.model.CommentDetailDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:28
 */
@Repository
public class CommentDetailDaoImpl implements CommentDetailDao {

    @Autowired
    private CommentDetailDOMapper mapper;

    @Override
    public long create(CommentDetailDO edo) {

        return mapper.insert(edo);
    }

    @Override
    public int update(CommentDetailDO edo){
        return mapper.updateByPrimaryKeySelective(edo);
    }

    @Override
    public List<CommentDetailDO> list(CommentDetailDO edo, long startIndex, int pageSize) {

        return mapper.list(edo,startIndex,pageSize);
    }

    @Override
    public long count(CommentDetailDO edo) {
        return mapper.count(edo);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public CommentDetailDO queryByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

}
