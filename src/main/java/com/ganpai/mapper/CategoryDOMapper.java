package com.ganpai.mapper;

import com.ganpai.model.CategoryDO;
import com.ganpai.model.CategoryDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CategoryDO record);

    int insertSelective(CategoryDO record);

    CategoryDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CategoryDO record);

    int updateByPrimaryKey(CategoryDO record);

    List<CategoryDO> list(@Param("record") CategoryDO edo, @Param("startIndex") long startIndex,
                           @Param("pageSize") int pageSize);

    long count(@Param("record") CategoryDO edo);
}