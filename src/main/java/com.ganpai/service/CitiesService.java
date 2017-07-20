package com.ganpai.service;


import com.ganpai.common.PaginationData;
import com.ganpai.dto.CitiesDTO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:33
 */
public interface CitiesService {

    Integer create(CitiesDTO dto);

    List<Integer> create(List<CitiesDTO> dtos);

    Integer update(CitiesDTO dto);

    PaginationData<CitiesDTO> list(CitiesDTO dto, int pageIndex, int pageSize);

    Integer deleteByPrimaryKey(Integer id);

    CitiesDTO queryByPrimaryKey(Integer id);

}
