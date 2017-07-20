package com.ganpai.mapper;

import com.ganpai.model.DemandDO;
import com.ganpai.model.DemandDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemandDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DemandDO record);

    int insertSelective(DemandDO record);

    DemandDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DemandDO record);

    int updateByPrimaryKey(DemandDO record);

    List<DemandDO> list(@Param("record") DemandDO edo, @Param("startIndex") long startIndex,
                         @Param("pageSize") int pageSize);

    long count(@Param("record") DemandDO edo);
}