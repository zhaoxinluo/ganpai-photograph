package com.ganpai.mapper;

import com.ganpai.model.CitiesDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CitiesDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CitiesDO record);

    int insertSelective(CitiesDO record);

    CitiesDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CitiesDO record);

    int updateByPrimaryKey(CitiesDO record);

    List<CitiesDO> list(@Param("record") CitiesDO edo, @Param("startIndex") long startIndex,
                           @Param("pageSize") int pageSize);

    long count(@Param("record") CitiesDO edo);
}