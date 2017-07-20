package com.ganpai.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名: comment_detail
 */
public class CommentDetailDTO  implements Serializable {
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

}