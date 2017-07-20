package com.ganpai.mapper;

import com.ganpai.model.CommentDetailDO;
import com.ganpai.model.CommentDetailDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDetailDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommentDetailDO record);

    int insertSelective(CommentDetailDO record);

    CommentDetailDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommentDetailDO record);

    int updateByPrimaryKey(CommentDetailDO record);

    List<CommentDetailDO> list(@Param("record") CommentDetailDO edo, @Param("startIndex") long startIndex,
                           @Param("pageSize") int pageSize);

    long count(@Param("record") CommentDetailDO edo);
}