package com.ganpai.dao.impl;

import com.ganpai.dao.CommentDao;
import com.ganpai.mapper.CommentDOMapper;
import com.ganpai.model.CommentDO;
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
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private CommentDOMapper mapper;

    @Override
    public long create(CommentDO edo) {

        return mapper.insert(edo);
    }

    @Override
    public int update(CommentDO edo){
        return mapper.updateByPrimaryKeySelective(edo);
    }

    @Override
    public List<CommentDO> list(CommentDO edo, long startIndex, int pageSize) {

        return mapper.list(edo,startIndex,pageSize);
    }

    @Override
    public long count(CommentDO edo) {
        return mapper.count(edo);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public CommentDO queryByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

}
