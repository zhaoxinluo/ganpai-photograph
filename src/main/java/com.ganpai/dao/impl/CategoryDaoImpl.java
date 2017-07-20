package com.ganpai.dao.impl;

import com.ganpai.dao.CategoryDao;
import com.ganpai.mapper.CategoryDOMapper;
import com.ganpai.model.CategoryDO;
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
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private CategoryDOMapper mapper;

    @Override
    public long create(CategoryDO edo) {

        return mapper.insert(edo);
    }

    @Override
    public int update(CategoryDO edo){
        return mapper.updateByPrimaryKeySelective(edo);
    }

    @Override
    public List<CategoryDO> list(CategoryDO edo, long startIndex, int pageSize) {

        return mapper.list(edo,startIndex,pageSize);
    }

    @Override
    public long count(CategoryDO edo) {
        return mapper.count(edo);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public CategoryDO queryByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

}
