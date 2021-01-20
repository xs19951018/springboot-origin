package com.my.springbootorigin.login.enums;

import com.my.springbootorigin.utils.enums.BaseErrorInfo;

public enum LoginEnum implements BaseErrorInfo {
    LOGIN_ERR(1, "账户或密码错误")
    ;

    private Integer code;
    private String message;

    LoginEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
