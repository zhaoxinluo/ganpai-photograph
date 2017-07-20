package com.ganpai.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名: collection
 */
public class CollectionDTO  implements Serializable {
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

}