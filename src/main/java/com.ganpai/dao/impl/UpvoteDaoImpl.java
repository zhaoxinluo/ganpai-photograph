package com.ganpai.dao.impl;

import com.ganpai.dao.UpvoteDao;
import com.ganpai.mapper.UpvoteDOMapper;
import com.ganpai.model.UpvoteDO;
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
public class UpvoteDaoImpl implements UpvoteDao {

    @Autowired
    private UpvoteDOMapper mapper;

    @Override
    public long create(UpvoteDO edo) {

        return mapper.insert(edo);
    }

    @Override
    public int update(UpvoteDO edo){
        return mapper.updateByPrimaryKeySelective(edo);
    }

    @Override
    public List<UpvoteDO> list(UpvoteDO edo, long startIndex, int pageSize) {

        return mapper.list(edo,startIndex,pageSize);
    }

    @Override
    public long count(UpvoteDO edo) {
        return mapper.count(edo);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public UpvoteDO queryByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

}
