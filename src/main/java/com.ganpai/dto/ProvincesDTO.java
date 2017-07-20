package com.ganpai.dto;

import java.io.Serializable;

/**
 * 表名: provinces
 */
public class ProvincesDTO implements Serializable{
    /**
     * 字段名: provinces.id
     */
    private Integer id;

    /**
     * 字段名: provinces.province_id
     */
    private Long provinceId;

    /**
     * 字段名: provinces.province
     */
    private String province;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId ;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

}