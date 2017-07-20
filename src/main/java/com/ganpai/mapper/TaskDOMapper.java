package com.ganpai.mapper;

import com.ganpai.model.TaskDO;
import com.ganpai.model.TaskDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TaskDO record);

    int insertSelective(TaskDO record);

    TaskDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaskDO record);

    int updateByPrimaryKey(TaskDO record);

    List<TaskDO> list(@Param("record") TaskDO edo, @Param("startIndex") long startIndex,
                         @Param("pageSize") int pageSize);

    long count(@Param("record") TaskDO edo);
}