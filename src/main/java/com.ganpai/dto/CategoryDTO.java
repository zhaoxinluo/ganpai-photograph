package com.ganpai.dto;

import java.io.Serializable;

/**
 * 表名: category
 */
public class CategoryDTO  implements Serializable {
    /**
     * 备注: 主键id
     * 字段名: category.id
     */
    private Long id;

    /**
     * 备注: 分类编码
     * 字段名: category.code
     */
    private String code;

    /**
     * 备注: 分类名称
     * 字段名: category.name
     */
    private String name;

    /**
     * 备注: 父分类id
     * 字段名: category.pid
     */
    private Long pid;

    /**
     * 备注: 是否删除(0 删除,1 不删除)
     * 字段名: category.is_del
     */
    private Byte isDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }
}