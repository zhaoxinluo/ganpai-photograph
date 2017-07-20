package com.ganpai.model;

import java.util.Date;

/**
 * 表名: recommend
 */
public class RecommendDO {
    /**
     * 备注: 主键id
     * 字段名: recommend.id
     */
    private Long id;

    /**
     * 备注: 作品主键id
     * 字段名: recommend.opus_id
     */
    private Long opusId;

    /**
     * 备注: 作者id
     * 字段名: recommend.user_id
     */
    private Long userId;

    /**
     * 备注: 账号
     * 字段名: recommend.login_name
     */
    private String loginName;

    /**
     * 备注: 用户头像地址
     * 字段名: recommend.head_sculpture_address
     */
    private String headSculptureAddress;

    /**
     * 备注: 推荐用户id
     * 字段名: recommend.recommend_user_id
     */
    private Long recommendUserId;

    /**
     * 备注: 推荐用户名
     * 字段名: recommend.recommend_login_name
     */
    private String recommendLoginName;

    /**
     * 备注: 推荐用户头像地址
     * 字段名: recommend.recommend_head_sculpture_address
     */
    private String recommendHeadSculptureAddress;

    /**
     * 备注: 推荐时间
     * 字段名: recommend.create_time
     */
    private Date createTime;

    /**
     * 备注: 是否删除(0 删除,1 不删除)
     * 字段名: recommend.is_del
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

    public Long getRecommendUserId() {
        return recommendUserId;
    }

    public void setRecommendUserId(Long recommendUserId) {
        this.recommendUserId = recommendUserId;
    }

    public String getRecommendLoginName() {
        return recommendLoginName;
    }

    public void setRecommendLoginName(String recommendLoginName) {
        this.recommendLoginName = recommendLoginName == null ? null : recommendLoginName.trim();
    }

    public String getRecommendHeadSculptureAddress() {
        return recommendHeadSculptureAddress;
    }

    public void setRecommendHeadSculptureAddress(String recommendHeadSculptureAddress) {
        this.recommendHeadSculptureAddress = recommendHeadSculptureAddress == null ? null : recommendHeadSculptureAddress.trim();
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
        RecommendDO other = (RecommendDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOpusId() == null ? other.getOpusId() == null : this.getOpusId().equals(other.getOpusId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getRecommendUserId() == null ? other.getRecommendUserId() == null : this.getRecommendUserId().equals(other.getRecommendUserId()))
            && (this.getRecommendLoginName() == null ? other.getRecommendLoginName() == null : this.getRecommendLoginName().equals(other.getRecommendLoginName()))
            && (this.getRecommendHeadSculptureAddress() == null ? other.getRecommendHeadSculptureAddress() == null : this.getRecommendHeadSculptureAddress().equals(other.getRecommendHeadSculptureAddress()))
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
        result = prime * result + ((getRecommendUserId() == null) ? 0 : getRecommendUserId().hashCode());
        result = prime * result + ((getRecommendLoginName() == null) ? 0 : getRecommendLoginName().hashCode());
        result = prime * result + ((getRecommendHeadSculptureAddress() == null) ? 0 : getRecommendHeadSculptureAddress().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        return result;
    }
}