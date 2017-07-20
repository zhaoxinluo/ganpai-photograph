package com.ganpai.model;

import java.util.Date;

/**
 * 表名: upvote
 */
public class UpvoteDO {
    /**
     * 备注: 主键id
     * 字段名: upvote.id
     */
    private Long id;

    /**
     * 备注: 作品主键id
     * 字段名: upvote.opus_id
     */
    private Long opusId;

    /**
     * 备注: 作者id
     * 字段名: upvote.user_id
     */
    private Long userId;

    /**
     * 备注: 账号
     * 字段名: upvote.login_name
     */
    private String loginName;

    /**
     * 备注: 用户头像地址
     * 字段名: upvote.head_sculpture_address
     */
    private String headSculptureAddress;

    /**
     * 备注: 点赞用户id
     * 字段名: upvote.upvote_user_id
     */
    private Long upvoteUserId;

    /**
     * 备注: 点赞用户名
     * 字段名: upvote.upvote_login_name
     */
    private String upvoteLoginName;

    /**
     * 备注: 点赞头像地址
     * 字段名: upvote.upvote_head_sculpture_address
     */
    private String upvoteHeadSculptureAddress;

    /**
     * 备注: 点赞时间
     * 字段名: upvote.create_time
     */
    private Date createTime;

    /**
     * 备注: 是否删除(0 删除,1 不删除)
     * 字段名: upvote.is_del
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

    public Long getUpvoteUserId() {
        return upvoteUserId;
    }

    public void setUpvoteUserId(Long upvoteUserId) {
        this.upvoteUserId = upvoteUserId;
    }

    public String getUpvoteLoginName() {
        return upvoteLoginName;
    }

    public void setUpvoteLoginName(String upvoteLoginName) {
        this.upvoteLoginName = upvoteLoginName == null ? null : upvoteLoginName.trim();
    }

    public String getUpvoteHeadSculptureAddress() {
        return upvoteHeadSculptureAddress;
    }

    public void setUpvoteHeadSculptureAddress(String upvoteHeadSculptureAddress) {
        this.upvoteHeadSculptureAddress = upvoteHeadSculptureAddress == null ? null : upvoteHeadSculptureAddress.trim();
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
        UpvoteDO other = (UpvoteDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOpusId() == null ? other.getOpusId() == null : this.getOpusId().equals(other.getOpusId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getUpvoteUserId() == null ? other.getUpvoteUserId() == null : this.getUpvoteUserId().equals(other.getUpvoteUserId()))
            && (this.getUpvoteLoginName() == null ? other.getUpvoteLoginName() == null : this.getUpvoteLoginName().equals(other.getUpvoteLoginName()))
            && (this.getUpvoteHeadSculptureAddress() == null ? other.getUpvoteHeadSculptureAddress() == null : this.getUpvoteHeadSculptureAddress().equals(other.getUpvoteHeadSculptureAddress()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()));
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (opusId != null ? opusId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + (headSculptureAddress != null ? headSculptureAddress.hashCode() : 0);
        result = 31 * result + (upvoteUserId != null ? upvoteUserId.hashCode() : 0);
        result = 31 * result + (upvoteLoginName != null ? upvoteLoginName.hashCode() : 0);
        result = 31 * result + (upvoteHeadSculptureAddress != null ? upvoteHeadSculptureAddress.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (isDel != null ? isDel.hashCode() : 0);
        return result;
    }
}