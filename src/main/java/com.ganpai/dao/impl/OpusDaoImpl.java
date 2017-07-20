package com.ganpai.dao.impl;

import com.ganpai.dao.OpusDao;
import com.ganpai.mapper.OpusDOMapper;
import com.ganpai.model.OpusDO;
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
public class OpusDaoImpl implements OpusDao {

    @Autowired
    private OpusDOMapper mapper;

    @Override
    public long create(OpusDO edo) {

        return mapper.insert(edo);
    }

    @Override
    public int update(OpusDO edo){
        return mapper.updateByPrimaryKeySelective(edo);
    }

    @Override
    public List<OpusDO> list(OpusDO edo, long startIndex, int pageSize) {

        return mapper.list(edo,startIndex,pageSize);
    }

    @Override
    public long count(OpusDO edo) {
        return mapper.count(edo);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public OpusDO queryByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

}
