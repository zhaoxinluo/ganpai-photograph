package com.ganpai.mapper;

import com.ganpai.model.UpvoteDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpvoteDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UpvoteDO record);

    int insertSelective(UpvoteDO record);

    UpvoteDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UpvoteDO record);

    int updateByPrimaryKey(UpvoteDO record);

    List<UpvoteDO> list(@Param("record") UpvoteDO edo, @Param("startIndex") long startIndex,
                        @Param("pageSize") int pageSize);

    long count(@Param("record") UpvoteDO edo);
}