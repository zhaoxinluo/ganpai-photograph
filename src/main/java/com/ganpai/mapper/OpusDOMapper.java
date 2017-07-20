package com.ganpai.mapper;

import com.ganpai.model.OpusDO;
import com.ganpai.model.OpusDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OpusDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OpusDO record);

    int insertSelective(OpusDO record);

    OpusDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OpusDO record);

    int updateByPrimaryKey(OpusDO record);

    List<OpusDO> list(@Param("record") OpusDO edo, @Param("startIndex") long startIndex,
                           @Param("pageSize") int pageSize);

    long count(@Param("record") OpusDO edo);
}