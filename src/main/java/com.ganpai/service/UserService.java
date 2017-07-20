package com.ganpai.service;


import com.ganpai.common.PaginationData;
import com.ganpai.dto.UserDTO;

import java.util.List;

/**
 * Description:
 * <p>
 * Created with wms-obd-center.
 * User: zhaoxl
 * Date: 2017/7/9
 * Time: 10:33
 */
public interface UserService {

    Long create(UserDTO dto);

    List<Long> create(List<UserDTO> dtos);

    Integer update(UserDTO dto);

    PaginationData<UserDTO> list(UserDTO dto, int pageIndex, int pageSize);

    Integer deleteByPrimaryKey(Long id);

    UserDTO queryByPrimaryKey(Long id);

}
