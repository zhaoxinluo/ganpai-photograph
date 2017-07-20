package com.ganpai.dao.impl;

import com.ganpai.dao.RecommendDao;
import com.ganpai.mapper.RecommendDOMapper;
import com.ganpai.model.RecommendDO;
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
public class RecommendDaoImpl implements RecommendDao {

    @Autowired
    private RecommendDOMapper mapper;

    @Override
    public long create(RecommendDO edo) {

        return mapper.insert(edo);
    }

    @Override
    public int update(RecommendDO edo){
        return mapper.updateByPrimaryKeySelective(edo);
    }

    @Override
    public List<RecommendDO> list(RecommendDO edo, long startIndex, int pageSize) {

        return mapper.list(edo,startIndex,pageSize);
    }

    @Override
    public long count(RecommendDO edo) {
        return mapper.count(edo);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public RecommendDO queryByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

}
