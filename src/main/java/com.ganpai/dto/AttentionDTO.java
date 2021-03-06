package com.ganpai.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名: attention
 */
public class AttentionDTO implements Serializable{
    /**
     * 备注: 主键id
     * 字段名: attention.id
     */
    private Long id;

    /**
     * 备注: 用户id
     * 字段名: attention.user_id
     */
    private Long userId;

    /**
     * 备注: 账号
     * 字段名: attention.login_name
     */
    private String loginName;

    /**
     * 备注: 用户头像地址
     * 字段名: attention.head_sculpture_address
     */
    private String headSculptureAddress;

    /**
     * 备注: 关注用户id
     * 字段名: attention.attention_user_id
     */
    private Long attentionUserId;

    /**
     * 备注: 关注用户名
     * 字段名: attention.attention_login_name
     */
    private String attentionLoginName;

    /**
     * 备注: 关注用户头像地址
     * 字段名: attention.attention_head_sculpture_address
     */
    private String attentionHeadSculptureAddress;

    /**
     * 备注: 关注时间
     * 字段名: attention.create_time
     */
    private Date createTime;

    /**
     * 备注: 是否删除(0 删除,1 不删除)
     * 字段名: attention.is_del
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

    public Long getAttentionUserId() {
        return attentionUserId;
    }

    public void setAttentionUserId(Long attentionUserId) {
        this.attentionUserId = attentionUserId;
    }

    public String getAttentionLoginName() {
        return attentionLoginName;
    }

    public void setAttentionLoginName(String attentionLoginName) {
        this.attentionLoginName = attentionLoginName == null ? null : attentionLoginName.trim();
    }

    public String getAttentionHeadSculptureAddress() {
        return attentionHeadSculptureAddress;
    }

    public void setAttentionHeadSculptureAddress(String attentionHeadSculptureAddress) {
        this.attentionHeadSculptureAddress = attentionHeadSculptureAddress == null ? null : attentionHeadSculptureAddress.trim();
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