package com.ganpai.mapper;

import com.ganpai.model.AttentionDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttentionDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AttentionDO record);

    int insertSelective(AttentionDO record);

    AttentionDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AttentionDO record);

    int updateByPrimaryKey(AttentionDO record);

    List<AttentionDO> list(@Param("record") AttentionDO edo, @Param("startIndex") long startIndex,
                              @Param("pageSize") int pageSize);

    long count(@Param("record") AttentionDO edo);
}