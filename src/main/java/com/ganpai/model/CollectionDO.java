package com.ganpai.model;

import java.util.Date;

/**
 * 表名: collection
 */
public class CollectionDO {
    /**
     * 备注: 主键id
     * 字段名: collection.id
     */
    private Long id;

    /**
     * 备注: 作品主键id
     * 字段名: collection.opus_id
     */
    private Long opusId;

    /**
     * 备注: 作者id
     * 字段名: collection.user_id
     */
    private Long userId;

    /**
     * 备注: 账号
     * 字段名: collection.login_name
     */
    private String loginName;

    /**
     * 备注: 用户头像地址
     * 字段名: collection.head_sculpture_address
     */
    private String headSculptureAddress;

    /**
     * 备注: 收藏用户id
     * 字段名: collection.collection_user_id
     */
    private Long collectionUserId;

    /**
     * 备注: 收藏用户名
     * 字段名: collection.collection_login_name
     */
    private String collectionLoginName;

    /**
     * 备注: 收藏用户头像地址
     * 字段名: collection.collection_head_sculpture_address
     */
    private String collectionHeadSculptureAddress;

    /**
     * 备注: 收藏时间
     * 字段名: collection.create_time
     */
    private Date createTime;

    /**
     * 备注: 是否删除(0 删除,1 不删除)
     * 字段名: collection.is_del
     */
    private Byte isDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOpusId() {
        return opusId;
    }

    public void setOpusId(Long opusId) {
        this.opusId = opusId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getHeadSculptureAddress() {
        return headSculptureAddress;
    }

    public void setHeadSculptureAddress(String headSculptureAddress) {
        this.headSculptureAddress = headSculptureAddress;
    }


    public Long getCollectionUserId() {
        return collectionUserId;
    }

    public void setCollectionUserId(Long collectionUserId) {
        this.collectionUserId = collectionUserId;
    }

    public String getCollectionLoginName() {
        return collectionLoginName;
    }

    public void setCollectionLoginName(String collectionLoginName) {
        this.collectionLoginName = collectionLoginName == null ? null : collectionLoginName.trim();
    }

    public String getCollectionHeadSculptureAddress() {
        return collectionHeadSculptureAddress;
    }

    public void setCollectionHeadSculptureAddress(String collectionHeadSculptureAddress) {
        this.collectionHeadSculptureAddress = collectionHeadSculptureAddress == null ? null : collectionHeadSculptureAddress.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        CollectionDO other = (CollectionDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOpusId() == null ? other.getOpusId() == null : this.getOpusId().equals(other.getOpusId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getCollectionUserId() == null ? other.getCollectionUserId() == null : this.getCollectionUserId().equals(other.getCollectionUserId()))
            && (this.getCollectionLoginName() == null ? other.getCollectionLoginName() == null : this.getCollectionLoginName().equals(other.getCollectionLoginName()))
            && (this.getCollectionHeadSculptureAddress() == null ? other.getCollectionHeadSculptureAddress() == null : this.getCollectionHeadSculptureAddress().equals(other.getCollectionHeadSculptureAddress()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOpusId() == null) ? 0 : getOpusId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getCollectionUserId() == null) ? 0 : getCollectionUserId().hashCode());
        result = prime * result + ((getCollectionLoginName() == null) ? 0 : getCollectionLoginName().hashCode());
        result = prime * result + ((getCollectionHeadSculptureAddress() == null) ? 0 : getCollectionHeadSculptureAddress().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        return result;
    }
}