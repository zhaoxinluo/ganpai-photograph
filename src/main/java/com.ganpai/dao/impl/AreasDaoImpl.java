package com.ganpai.dao.impl;

import com.ganpai.dao.AreasDao;
import com.ganpai.mapper.AreasDOMapper;
import com.ganpai.model.AreasDO;
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
public class AreasDaoImpl implements AreasDao {

    @Autowired
    private AreasDOMapper mapper;

    @Override
    public int create(AreasDO edo) {

        return mapper.insert(edo);
    }

    @Override
    public int update(AreasDO edo){
        return mapper.updateByPrimaryKeySelective(edo);
    }

    @Override
    public List<AreasDO> list(AreasDO edo, long startIndex, int pageSize) {

        return mapper.list(edo,startIndex,pageSize);
    }

    @Override
    public long count(AreasDO edo) {
        return mapper.count(edo);
    }

    @Override
    public int deleteByPrimaryKey(Integer id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public AreasDO queryByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

}
