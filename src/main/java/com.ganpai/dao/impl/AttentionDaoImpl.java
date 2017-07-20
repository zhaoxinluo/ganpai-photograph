package com.ganpai.dao.impl;

import com.ganpai.dao.AttentionDao;
import com.ganpai.mapper.AttentionDOMapper;
import com.ganpai.model.AttentionDO;
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
public class AttentionDaoImpl implements AttentionDao {

    @Autowired
    private AttentionDOMapper mapper;

    @Override
    public long create(AttentionDO edo) {

        return mapper.insert(edo);
    }

    @Override
    public int update(AttentionDO edo){
        return mapper.updateByPrimaryKeySelective(edo);
    }

    @Override
    public List<AttentionDO> list(AttentionDO edo, long startIndex, int pageSize) {

        return mapper.list(edo,startIndex,pageSize);
    }

    @Override
    public long count(AttentionDO edo) {
        return mapper.count(edo);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public AttentionDO queryByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

}
