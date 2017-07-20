package com.ganpai.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 表名: user
 */
public class UserDTO implements Serializable{
    /**
     * 备注: 主键
     * 字段名: user.id
     */
    private Long id;

    /**
     * 备注: 用户真实名
     * 字段名: user.user_name
     */
    private String userName;

    /**
     * 备注: 账号
     * 字段名: user.login_name
     */
    private String loginName;

    /**
     * 备注: 密码
     * 字段名: user.password
     */
    private String password;

    /**
     * 备注: 手机号码
     * 字段名: user.mobile
     */
    private String mobile;

    /**
     * 备注: 邮箱地址
     * 字段名: user.email
     */
    private String email;

    /**
     * 备注: 头像地址
     * 字段名: user.head_sculpture_address
     */
    private String headSculptureAddress;

    /**
     * 备注: 性别
     * 字段名: user.sexy
     */
    private Byte sexy;

    /**
     * 备注: 省份id
     * 字段名: user.province_id
     */
    private Long provinceId;

    /**
     * 备注: 省份
     * 字段名: user.province_name
     */
    private String provinceName;

    /**
     * 备注: 城市id
     * 字段名: user.city_id
     */
    private Long cityId;

    /**
     * 备注: 城市
     * 字段名: user.city_name
     */
    private String cityName;

    /**
     * 备注: 行政区域县区id
     * 字段名: user.area_id
     */
    private Long areaId;

    /**
     * 备注: 行政区域县区
     * 字段名: user.area_name
     */
    private String areaName;

    /**
     * 备注: 地址
     * 字段名: user.address
     */
    private String address;

    /**
     * 备注: 角色id
     * 字段名: user.role_id
     */
    private Integer roleId;

    /**
     * 备注: 创建人
     * 字段名: user.creat_by
     */
    private String createBy;

    /**
     * 备注: 创建时间
     * 字段名: user.creat_time
     */
    private Date createTime;

    /**
     * 备注: 修改人
     * 字段名: user.modify_by
     */
    private String modifyBy;

    /**
     * 备注: 修改人
     * 字段名: user.modify_time
     */
    private Date modifyTime;

    /**
     * 备注: 是否删除(0 删除,1 不删除)
     * 字段名: user.is_del
     */
    private Byte isDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHeadSculptureAddress() {
        return headSculptureAddress;
    }

    public void setHeadSculptureAddress(String headSculptureAddress) {
        this.headSculptureAddress = headSculptureAddress == null ? null : headSculptureAddress.trim();
    }

    public Byte getSexy() {
        return sexy;
    }

    public void setSexy(Byte sexy) {
        this.sexy = sexy;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    /**
     * 登录使用   登录可能为 loginName, email, mobile
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}