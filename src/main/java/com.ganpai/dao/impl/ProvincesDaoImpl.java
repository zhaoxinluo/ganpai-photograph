package com.ganpai.dao.impl;

import com.ganpai.dao.ProvincesDao;
import com.ganpai.mapper.ProvincesDOMapper;
import com.ganpai.model.ProvincesDO;
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
public class ProvincesDaoImpl implements ProvincesDao {

    @Autowired
    private ProvincesDOMapper mapper;

    @Override
    public int create(ProvincesDO edo) {

        return mapper.insert(edo);
    }

    @Override
    public int update(ProvincesDO edo){
        return mapper.updateByPrimaryKeySelective(edo);
    }

    @Override
    public List<ProvincesDO> list(ProvincesDO edo, long startIndex, int pageSize) {

        return mapper.list(edo,startIndex,pageSize);
    }

    @Override
    public long count(ProvincesDO edo) {
        return mapper.count(edo);
    }

    @Override
    public int deleteByPrimaryKey(Integer id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public ProvincesDO queryByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

}
