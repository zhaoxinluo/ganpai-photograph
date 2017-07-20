package com.ganpai.dao.impl;

import com.ganpai.dao.CollectionDao;
import com.ganpai.mapper.CollectionDOMapper;
import com.ganpai.model.CollectionDO;
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
public class CollectionDaoImpl implements CollectionDao {

    @Autowired
    private CollectionDOMapper mapper;

    @Override
    public long create(CollectionDO edo) {

        return mapper.insert(edo);
    }

    @Override
    public int update(CollectionDO edo){
        return mapper.updateByPrimaryKeySelective(edo);
    }

    @Override
    public List<CollectionDO> list(CollectionDO edo, long startIndex, int pageSize) {

        return mapper.list(edo,startIndex,pageSize);
    }

    @Override
    public long count(CollectionDO edo) {
        return mapper.count(edo);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public CollectionDO queryByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

}
