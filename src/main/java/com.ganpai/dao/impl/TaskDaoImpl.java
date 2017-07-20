package com.ganpai.dao.impl;

import com.ganpai.dao.TaskDao;
import com.ganpai.mapper.TaskDOMapper;
import com.ganpai.model.TaskDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:28
 */
@Repository
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private TaskDOMapper mapper;

    @Override
    public long create(TaskDO edo) {

        return mapper.insert(edo);
    }

    @Override
    public int update(TaskDO edo){
        return mapper.updateByPrimaryKeySelective(edo);
    }

    @Override
    public List<TaskDO> list(TaskDO edo, long startIndex, int pageSize) {
        return mapper.list(edo,startIndex,pageSize);
    }

    @Override
    public long count(TaskDO edo) {
        return mapper.count(edo);
    }

    @Override
    public int deleteByPrimaryKey(Long id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public TaskDO queryByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

}
