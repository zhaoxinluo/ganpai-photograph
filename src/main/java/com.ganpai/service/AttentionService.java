package com.ganpai.service;


import com.ganpai.common.PaginationData;
import com.ganpai.dto.AttentionDTO;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:33
 */
public interface AttentionService {

    Long create(AttentionDTO dto);

    List<Long> create(List<AttentionDTO> dtos);

    Integer update(AttentionDTO dto);

    PaginationData<AttentionDTO> list(AttentionDTO dto, int pageIndex, int pageSize);

    Integer deleteByPrimaryKey(Long id);

    AttentionDTO queryByPrimaryKey(Long id);

}
