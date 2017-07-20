package com.ganpai.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名: opus
 */
public class OpusDTO  implements Serializable {
    /**
     * 备注: 主键
     * 字段名: opus.id
     */
    private Long id;

    /**
     * 备注: 用户id
     * 字段名: opus.user_id
     */
    private Long userId;

    /**
     * 备注: 账号
     * 字段名: opus.login_name
     */
    private String loginName;

    /**
     * 备注: 用户真实姓名
     * 字段名: opus.user_name
     */
    private String userName;

    /**
     * 备注: 头像地址
     * 字段名: opus.head_sculpture_address
     */
    private String headSculptureAddress;

    /**
     * 备注: 作品名
     * 字段名: opus.opus_name
     */
    private String opusName;

    /**
     * 备注: 作品对应分类id
     * 字段名: opus.category_id
     */
    private Long categoryId;

    /**
     * 备注: 作品描述
     * 字段名: opus.opus_desc
     */
    private String opusDesc;

    /**
     * 备注: 作品图片地址(多张图片 ","隔开)
     * 字段名: opus.opus_address
     */
    private String opusAddress;

    /**
     * 备注: 发布时间
     * 字段名: opus.public_time
     */
    private Date publicTime;

    /**
     * 备注: 是否删除(0 删除,1 不删除)
     * 字段名: opus.is_del
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getHeadSculptureAddress() {
        return headSculptureAddress;
    }

    public void setHeadSculptureAddress(String headSculptureAddress) {
        this.headSculptureAddress = headSculptureAddress == null ? null : headSculptureAddress.trim();
    }

    public String getOpusName() {
        return opusName;
    }

    public void setOpusName(String opusName) {
        this.opusName = opusName == null ? null : opusName.trim();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getOpusDesc() {
        return opusDesc;
    }

    public void setOpusDesc(String opusDesc) {
        this.opusDesc = opusDesc == null ? null : opusDesc.trim();
    }

    public String getOpusAddress() {
        return opusAddress;
    }

    public void setOpusAddress(String opusAddress) {
        this.opusAddress = opusAddress == null ? null : opusAddress.trim();
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

}