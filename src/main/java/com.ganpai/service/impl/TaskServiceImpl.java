package com.ganpai.service.impl;

import com.ganpai.common.PaginationData;
import com.ganpai.dao.TaskDao;
import com.ganpai.dto.TaskDTO;
import com.ganpai.enmu.DelEnum;
import com.ganpai.model.TaskDO;
import com.ganpai.service.TaskService;
import com.ganpai.utils.PaginationUtil;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    final BeanCopier inCopier = BeanCopier.create(TaskDTO.class, TaskDO.class, false);

    final BeanCopier outCopier = BeanCopier.create( TaskDO.class, TaskDTO.class,false);


    @Autowired
    public TaskDao dao;


    private TaskDO convert(TaskDTO dto) {
        TaskDO result = new TaskDO();
        inCopier.copy(dto, result, null);
        return result;
    }

    private TaskDTO convert(TaskDO edo) {
        TaskDTO result = new TaskDTO();
        outCopier.copy(edo, result, null);
        return result;
    }

    private List<TaskDTO> convert(List<TaskDO> doList) {
        List<TaskDTO> result = new ArrayList<>();
        if (doList!=null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Override
    public Long create(TaskDTO dto) {
        TaskDO edo = convert(dto);
        dao.create(edo);
        return edo.getId();
    }

    @Override
    public List<Long> create(List<TaskDTO> dtos) {
        List<Long> ids = new ArrayList<>();
        if(dtos!=null&&!dtos.isEmpty()){
            for(TaskDTO dto:dtos){
                TaskDO edo = convert(dto);
                dao.create(edo);
                ids.add(edo.getId());
            }
        }
        return ids;
    }

    @Override
    public Integer update(TaskDTO dto) {
        Integer rows = dao.update(convert(dto));
        return rows;
    }

    @Override
    public PaginationData<TaskDTO> list(TaskDTO dto, int pageIndex, int pageSize) {

        TaskDO edo = convert(dto);
        edo.setIsDel(DelEnum.NO_DEL.getCode());
        List<TaskDO> data = dao.list(edo, PaginationUtil.getDbStartIndex(pageIndex, pageSize), pageSize);
        long total = dao.count(edo);

        PaginationData<TaskDTO> result = new PaginationData(pageIndex, pageSize);
        result.setRows(convert(data));
        result.setTotal(total);

        return result;
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {
        int result = dao.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public TaskDTO queryByPrimaryKey(Long id) {
        return convert(dao.queryByPrimaryKey(id));
    }
}
