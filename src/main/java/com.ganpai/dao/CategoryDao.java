package com.ganpai.dao;

import com.ganpai.model.CategoryDO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:26
 */
public interface CategoryDao {

    long create(CategoryDO edo);

    int update(CategoryDO edo);

    List<CategoryDO> list(CategoryDO edo, long pageIndex, int pageSize);

    long count(CategoryDO edo);

    int deleteByPrimaryKey(Long id);

    CategoryDO queryByPrimaryKey(Long id);
}
