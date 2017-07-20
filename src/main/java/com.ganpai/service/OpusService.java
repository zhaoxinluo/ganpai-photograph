package com.ganpai.service;


import com.ganpai.common.PaginationData;
import com.ganpai.dto.OpusDTO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:33
 */
public interface OpusService {

    Long create(OpusDTO dto);

    List<Long> create(List<OpusDTO> dtos);

    Integer update(OpusDTO dto);

    PaginationData<OpusDTO> list(OpusDTO dto, int pageIndex, int pageSize);

    Integer deleteByPrimaryKey(Long id);

    OpusDTO queryByPrimaryKey(Long id);

}
