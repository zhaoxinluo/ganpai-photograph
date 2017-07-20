package com.ganpai.service;


import com.ganpai.common.PaginationData;
import com.ganpai.dto.AreasDTO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:33
 */
public interface AreasService {

    Integer create(AreasDTO dto);

    List<Integer> create(List<AreasDTO> dtos);

    Integer update(AreasDTO dto);

    PaginationData<AreasDTO> list(AreasDTO dto, int pageIndex, int pageSize);

    Integer deleteByPrimaryKey(Integer id);

    AreasDTO queryByPrimaryKey(Integer id);

}
