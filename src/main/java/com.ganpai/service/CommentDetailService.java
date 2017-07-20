package com.ganpai.service;


import com.ganpai.common.PaginationData;
import com.ganpai.dto.CommentDetailDTO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:33
 */
public interface CommentDetailService {

    Long create(CommentDetailDTO dto);

    List<Long> create(List<CommentDetailDTO> dtos);

    Integer update(CommentDetailDTO dto);

    PaginationData<CommentDetailDTO> list(CommentDetailDTO dto, int pageIndex, int pageSize);

    Integer deleteByPrimaryKey(Long id);

    CommentDetailDTO queryByPrimaryKey(Long id);

}
