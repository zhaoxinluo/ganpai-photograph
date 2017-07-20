package com.ganpai.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名: recommend
 */
public class RecommendDTO  implements Serializable {
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

}