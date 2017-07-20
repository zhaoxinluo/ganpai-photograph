package com.ganpai.dto;

import java.io.Serializable;

/**
 * 表名: areas
 */
public class AreasDTO implements Serializable{
    /**
     * 字段名: areas.id
     */
    private Integer id;

    /**
     * 字段名: areas.area_id
     */
    private Long areaId;

    /**
     * 字段名: areas.area
     */
    private String area;

    /**
     * 字段名: areas.city_id
     */
    private Long cityId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId ;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId ;
    }

}