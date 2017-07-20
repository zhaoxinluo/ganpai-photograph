package com.ganpai.dto;

import java.io.Serializable;

/**
 * 表名: cities
 */
public class CitiesDTO implements Serializable{
    /**
     * 字段名: cities.id
     */
    private Integer id;

    /**
     * 字段名: cities.city_id
     */
    private Long cityId;

    /**
     * 字段名: cities.city
     */
    private String city;

    /**
     * 字段名: cities.province_id
     */
    private Long provinceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId ;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId ;
    }
}