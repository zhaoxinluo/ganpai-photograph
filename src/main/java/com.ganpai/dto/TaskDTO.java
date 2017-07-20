package com.ganpai.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class TaskDTO implements Serializable{
    /**
     * 备注: 主键
     * 字段名: task.id
     */
    private Long id;

    /**
     * 备注: 需求id
     * 字段名: task.demand_id
     */
    private Long demandId;

    /**
     * 备注: 接收者
     * 字段名: task.user_id
     */
    private Long userId;

    /**
     * 备注: 接收者登录名
     * 字段名: task.login_name
     */
    private String loginName;

    /**
     * 备注: 接受者电话
     * 字段名: task.mobile
     */
    private String mobile;

    /**
     * 备注: 接受任务时间
     * 字段名: task.create_time
     */
    private Date createTime;

    /**
     * 备注: 是否删除(0,不删除, 1,删除)
     * 字段名: task.is_del
     */
    private Byte isDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
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
