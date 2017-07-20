package com.ganpai.model;

import java.util.Date;

/**
 * 表名: comment_detail
 */
public class CommentDetailDO {
    /**
     * 备注: 主键id
     * 字段名: comment_detail.id
     */
    private Long id;

    /**
     * 备注: 作品主键id
     * 字段名: comment_detail.opus_id
     */
    private Long opusId;

    /**
     * 备注: 评论id
     * 字段名: comment_detail.comment_id
     */
    private Long commentId;

    /**
     * 备注: 评论用户id
     * 字段名: comment_detail.comment_user_id
     */
    private Long commentUserId;

    /**
     * 备注: 评论用户名
     * 字段名: comment_detail.comment_login_name
     */
    private String commentLoginName;

    /**
     * 备注: 评论用户头像地址
     * 字段名: comment_detail.comment_head_sculpture_address
     */
    private String commentHeadSculptureAddress;

    /**
     * 备注: 评论内容
     * 字段名: comment_detail.comment
     */
    private String comment;

    /**
     * 备注: 评论时间
     * 字段名: comment_detail.create_time
     */
    private Date createTime;

    /**
     * 备注: 是否删除(0 删除,1 不删除)
     * 字段名: comment_detail.is_del
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

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Long commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentLoginName() {
        return commentLoginName;
    }

    public void setCommentLoginName(String commentLoginName) {
        this.commentLoginName = commentLoginName == null ? null : commentLoginName.trim();
    }

    public String getCommentHeadSculptureAddress() {
        return commentHeadSculptureAddress;
    }

    public void setCommentHeadSculptureAddress(String commentHeadSculptureAddress) {
        this.commentHeadSculptureAddress = commentHeadSculptureAddress == null ? null : commentHeadSculptureAddress.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        CommentDetailDO other = (CommentDetailDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOpusId() == null ? other.getOpusId() == null : this.getOpusId().equals(other.getOpusId()))
            && (this.getCommentId() == null ? other.getCommentId() == null : this.getCommentId().equals(other.getCommentId()))
            && (this.getCommentUserId() == null ? other.getCommentUserId() == null : this.getCommentUserId().equals(other.getCommentUserId()))
            && (this.getCommentLoginName() == null ? other.getCommentLoginName() == null : this.getCommentLoginName().equals(other.getCommentLoginName()))
            && (this.getCommentHeadSculptureAddress() == null ? other.getCommentHeadSculptureAddress() == null : this.getCommentHeadSculptureAddress().equals(other.getCommentHeadSculptureAddress()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOpusId() == null) ? 0 : getOpusId().hashCode());
        result = prime * result + ((getCommentId() == null) ? 0 : getCommentId().hashCode());
        result = prime * result + ((getCommentUserId() == null) ? 0 : getCommentUserId().hashCode());
        result = prime * result + ((getCommentLoginName() == null) ? 0 : getCommentLoginName().hashCode());
        result = prime * result + ((getCommentHeadSculptureAddress() == null) ? 0 : getCommentHeadSculptureAddress().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        return result;
    }
}