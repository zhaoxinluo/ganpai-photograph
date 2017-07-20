package com.ganpai.service;


import com.ganpai.common.PaginationData;
import com.ganpai.dto.RecommendDTO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:33
 */
public interface RecommendService {

    Long create(RecommendDTO dto);

    List<Long> create(List<RecommendDTO> dtos);

    Integer update(RecommendDTO dto);

    PaginationData<RecommendDTO> list(RecommendDTO dto, int pageIndex, int pageSize);

    Integer deleteByPrimaryKey(Long id);

    RecommendDTO queryByPrimaryKey(Long id);

    Long count(RecommendDTO dto);

}
