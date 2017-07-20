package com.ganpai.service;


import com.ganpai.common.PaginationData;
import com.ganpai.dto.DemandDTO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:33
 */
public interface DemandService {

    Long create(DemandDTO dto);

    List<Long> create(List<DemandDTO> dtos);

    Integer update(DemandDTO dto);

    PaginationData<DemandDTO> list(DemandDTO dto, int pageIndex, int pageSize);

    Integer deleteByPrimaryKey(Long id);

    DemandDTO queryByPrimaryKey(Long id);

}
