package com.my.springbootorigin.login.pojo.req;

import javax.validation.constraints.NotBlank;

public class LoginReq {

    @NotBlank(message = "userName 不能为空")
    private String userName;
    @NotBlank(message = "password 不能为空")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
