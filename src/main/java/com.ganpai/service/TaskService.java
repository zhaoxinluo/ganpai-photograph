package com.ganpai.service;


import com.ganpai.common.PaginationData;
import com.ganpai.dto.TaskDTO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:33
 */
public interface TaskService {

    Long create(TaskDTO dto);

    List<Long> create(List<TaskDTO> dtos);

    Integer update(TaskDTO dto);

    PaginationData<TaskDTO> list(TaskDTO dto, int pageIndex, int pageSize);

    Integer deleteByPrimaryKey(Long id);

    TaskDTO queryByPrimaryKey(Long id);

}
