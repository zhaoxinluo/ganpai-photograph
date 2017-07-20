package com.ganpai.dao.impl;

import com.ganpai.dao.CitiesDao;
import com.ganpai.mapper.CitiesDOMapper;
import com.ganpai.model.CitiesDO;
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
public class CitiesDaoImpl implements CitiesDao {

    @Autowired
    private CitiesDOMapper mapper;

    @Override
    public int create(CitiesDO edo) {

        return mapper.insert(edo);
    }

    @Override
    public int update(CitiesDO edo){
        return mapper.updateByPrimaryKeySelective(edo);
    }

    @Override
    public List<CitiesDO> list(CitiesDO edo, long startIndex, int pageSize) {

        return mapper.list(edo,startIndex,pageSize);
    }

    @Override
    public long count(CitiesDO edo) {
        return mapper.count(edo);
    }

    @Override
    public int deleteByPrimaryKey(Integer id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public CitiesDO queryByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

}
