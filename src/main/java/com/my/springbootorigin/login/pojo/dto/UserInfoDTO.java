package com.my.springbootorigin.login.pojo.dto;

import com.my.springbootorigin.auth.pojo.UserInfo;

public class UserInfoDTO extends UserInfo {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
