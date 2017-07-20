package com.ganpai.mapper;

import com.ganpai.model.ProvincesDO;
import com.ganpai.model.ProvincesDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProvincesDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProvincesDO record);

    int insertSelective(ProvincesDO record);

    ProvincesDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProvincesDO record);

    int updateByPrimaryKey(ProvincesDO record);

    List<ProvincesDO> list(@Param("record") ProvincesDO edo, @Param("startIndex") long startIndex,
                           @Param("pageSize") int pageSize);

    long count(@Param("record") ProvincesDO edo);
}