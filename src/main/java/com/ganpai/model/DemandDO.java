package com.ganpai.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 表名: demand
 */
public class DemandDO {
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DemandDO other = (DemandDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getRegionRestrict() == null ? other.getRegionRestrict() == null : this.getRegionRestrict().equals(other.getRegionRestrict()))
            && (this.getDemandDesc() == null ? other.getDemandDesc() == null : this.getDemandDesc().equals(other.getDemandDesc()))
            && (this.getDesignCyc() == null ? other.getDesignCyc() == null : this.getDesignCyc().equals(other.getDesignCyc()))
            && (this.getDesignStyle() == null ? other.getDesignStyle() == null : this.getDesignStyle().equals(other.getDesignStyle()))
            && (this.getDemandSpecific() == null ? other.getDemandSpecific() == null : this.getDemandSpecific().equals(other.getDemandSpecific()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getIsAccept() == null ? other.getIsAccept() == null : this.getIsAccept().equals(other.getIsAccept()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getRegionRestrict() == null) ? 0 : getRegionRestrict().hashCode());
        result = prime * result + ((getDemandDesc() == null) ? 0 : getDemandDesc().hashCode());
        result = prime * result + ((getDesignCyc() == null) ? 0 : getDesignCyc().hashCode());
        result = prime * result + ((getDesignStyle() == null) ? 0 : getDesignStyle().hashCode());
        result = prime * result + ((getDemandSpecific() == null) ? 0 : getDemandSpecific().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getIsAccept() == null) ? 0 : getIsAccept().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        return result;
    }
}