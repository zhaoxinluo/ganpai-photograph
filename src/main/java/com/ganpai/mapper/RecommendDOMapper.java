package com.ganpai.mapper;

import com.ganpai.model.RecommendDO;
import com.ganpai.model.RecommendDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecommendDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RecommendDO record);

    int insertSelective(RecommendDO record);

    RecommendDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RecommendDO record);

    int updateByPrimaryKey(RecommendDO record);

    List<RecommendDO> list(@Param("record") RecommendDO edo, @Param("startIndex") long startIndex,
                           @Param("pageSize") int pageSize);

    long count(@Param("record") RecommendDO edo);
}