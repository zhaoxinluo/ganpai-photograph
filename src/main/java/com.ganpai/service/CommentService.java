package com.ganpai.service;


import com.ganpai.common.PaginationData;
import com.ganpai.dto.CommentDTO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:33
 */
public interface CommentService {

    Long create(CommentDTO dto);

    List<Long> create(List<CommentDTO> dtos);

    Integer update(CommentDTO dto);

    PaginationData<CommentDTO> list(CommentDTO dto, int pageIndex, int pageSize);

    Integer deleteByPrimaryKey(Long id);

    CommentDTO queryByPrimaryKey(Long id);

}
