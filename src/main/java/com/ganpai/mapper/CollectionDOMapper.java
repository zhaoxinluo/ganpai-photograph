package com.ganpai.mapper;

import com.ganpai.model.CollectionDO;
import com.ganpai.model.CollectionDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CollectionDO record);

    int insertSelective(CollectionDO record);

    CollectionDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CollectionDO record);

    int updateByPrimaryKey(CollectionDO record);

    List<CollectionDO> list(@Param("record") CollectionDO edo, @Param("startIndex") long startIndex,
                           @Param("pageSize") int pageSize);

    long count(@Param("record") CollectionDO edo);
}