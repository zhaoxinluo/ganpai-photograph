package com.ganpai.dao;

import com.ganpai.model.TaskDO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:26
 */
public interface TaskDao {

    long create(TaskDO edo);

    int update(TaskDO edo);

    List<TaskDO> list(TaskDO edo, long pageIndex, int pageSize);

    long count(TaskDO edo);

    int deleteByPrimaryKey(Long id);

    TaskDO queryByPrimaryKey(Long id);
}
