package com.ganpai.service;


import com.ganpai.common.PaginationData;
import com.ganpai.dto.CollectionDTO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:33
 */
public interface CollectionService {

    Long create(CollectionDTO dto);

    List<Long> create(List<CollectionDTO> dtos);

    Integer update(CollectionDTO dto);

    PaginationData<CollectionDTO> list(CollectionDTO dto, int pageIndex, int pageSize);

    Integer deleteByPrimaryKey(Long id);

    CollectionDTO queryByPrimaryKey(Long id);

    Long count(CollectionDTO dto);

}
