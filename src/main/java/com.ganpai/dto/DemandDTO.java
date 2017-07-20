package com.ganpai.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class DemandDTO implements Serializable{
    /**
     * 备注: 主键
     * 字段名: demand.id
     */
    private Long id;

    /**
     * 备注: 发布者id
     * 字段名: demand.user_id
     */
    private Long userId;

    /**
     * 备注: 发布者id
     * 字段名: demand.category_id
     */
    private Long categoryId;

    /**
     * 备注: 发布者登录名
     * 字段名: demand.login_name
     */
    private String loginName;

    /**
     * 备注: 发布者电话
     * 字段名: demand.mobile
     */
    private String mobile;

    /**
     * 备注: 服务商地域限制
     * 字段名: demand.region_restrict
     */
    private String regionRestrict;

    /**
     * 备注: 需求描述
     * 字段名: demand.demand_desc
     */
    private String demandDesc;

    /**
     * 备注: 设计周期
     * 字段名: demand.design_cyc
     */
    private String designCyc;

    /**
     * 备注: 设计风格
     * 字段名: demand.design_style
     */
    private String designStyle;

    /**
     * 备注: 具体需求
     * 字段名: demand.demand_specific
     */
    private String demandSpecific;

    /**
     * 备注: 价格
     * 字段名: demand.price
     */
    private BigDecimal price;

    /**
     * 备注: 创建时间
     * 字段名: demand.create_time
     */
    private Date createTime;

    /**
     * 备注: 需求完成时间
     * 字段名: demand.end_time
     */
    private Date endTime;

    /**
     * 备注: 是否被接受(0,否, 1,是)
     * 字段名: demand.is_accept
     */
    private Byte isAccept;

    /**
     * 备注: 是否删除(0,不删除  1, 删除)
     * 字段名: demand.is_del
     */
    private Byte isDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getRegionRestrict() {
        return regionRestrict;
    }

    public void setRegionRestrict(String regionRestrict) {
        this.regionRestrict = regionRestrict == null ? null : regionRestrict.trim();
    }

    public String getDemandDesc() {
        return demandDesc;
    }

    public void setDemandDesc(String demandDesc) {
        this.demandDesc = demandDesc == null ? null : demandDesc.trim();
    }

    public String getDesignCyc() {
        return designCyc;
    }

    public void setDesignCyc(String designCyc) {
        this.designCyc = designCyc == null ? null : designCyc.trim();
    }

    public String getDesignStyle() {
        return designStyle;
    }

    public void setDesignStyle(String designStyle) {
        this.designStyle = designStyle == null ? null : designStyle.trim();
    }

    public String getDemandSpecific() {
        return demandSpecific;
    }

    public void setDemandSpecific(String demandSpecific) {
        this.demandSpecific = demandSpecific == null ? null : demandSpecific.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getIsAccept() {
        return isAccept;
    }

    public void setIsAccept(Byte isAccept) {
        this.isAccept = isAccept;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

}
