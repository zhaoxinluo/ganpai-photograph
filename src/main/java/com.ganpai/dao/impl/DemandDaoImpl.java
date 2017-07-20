package com.ganpai.dao.impl;

import com.ganpai.dao.DemandDao;
import com.ganpai.mapper.DemandDOMapper;
import com.ganpai.model.DemandDO;
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
public class DemandDaoImpl implements DemandDao {

    @Autowired
    private DemandDOMapper mapper;

    @Override
    public long create(DemandDO edo) {

        return mapper.insert(edo);
    }

    @Override
    public int update(DemandDO edo){
        return mapper.updateByPrimaryKeySelective(edo);
    }

    @Override
    public List<DemandDO> list(DemandDO edo, long startIndex, int pageSize) {

        return mapper.list(edo,startIndex,pageSize);
    }

    @Override
    public long count(DemandDO edo) {
        return mapper.count(edo);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public DemandDO queryByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

}
