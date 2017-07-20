package com.ganpai.mapper;

import com.ganpai.model.AreasDO;
import com.ganpai.model.AreasDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreasDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AreasDO record);

    int insertSelective(AreasDO record);

    AreasDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AreasDO record);

    int updateByPrimaryKey(AreasDO record);

    List<AreasDO> list(@Param("record") AreasDO edo, @Param("startIndex") long startIndex,
                           @Param("pageSize") int pageSize);

    long count(@Param("record") AreasDO edo);
}