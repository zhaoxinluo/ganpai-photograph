package com.ganpai.service;


import com.ganpai.common.PaginationData;
import com.ganpai.dto.ProvincesDTO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:33
 */
public interface ProvincesService {

    Integer create(ProvincesDTO dto);

    List<Integer> create(List<ProvincesDTO> dtos);

    Integer update(ProvincesDTO dto);

    PaginationData<ProvincesDTO> list(ProvincesDTO dto, int pageIndex, int pageSize);

    Integer deleteByPrimaryKey(Integer id);

    ProvincesDTO queryByPrimaryKey(Integer id);

}
