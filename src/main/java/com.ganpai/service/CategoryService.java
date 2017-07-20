package com.ganpai.service;


import com.ganpai.common.PaginationData;
import com.ganpai.dto.CategoryDTO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:33
 */
public interface CategoryService {

    Long create(CategoryDTO dto);

    List<Long> create(List<CategoryDTO> dtos);

    Integer update(CategoryDTO dto);

    PaginationData<CategoryDTO> list(CategoryDTO dto, int pageIndex, int pageSize);

    Integer deleteByPrimaryKey(Long id);

    CategoryDTO queryByPrimaryKey(Long id);

}
