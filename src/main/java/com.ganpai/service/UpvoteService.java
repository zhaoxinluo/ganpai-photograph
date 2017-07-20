package com.ganpai.service;


import com.ganpai.common.PaginationData;
import com.ganpai.dto.UpvoteDTO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:33
 */
public interface UpvoteService {

    Long create(UpvoteDTO dto);

    List<Long> create(List<UpvoteDTO> dtos);

    Integer update(UpvoteDTO dto);

    PaginationData<UpvoteDTO> list(UpvoteDTO dto, int pageIndex, int pageSize);

    Integer deleteByPrimaryKey(Long id);

    UpvoteDTO queryByPrimaryKey(Long id);

    Long count(UpvoteDTO dto);

}
