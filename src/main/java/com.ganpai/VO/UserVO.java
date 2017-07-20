package com.ganpai.VO;

import com.ganpai.dto.UserDTO;

public class UserVO extends UserDTO{
    /**
     * 新密码
     */
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}