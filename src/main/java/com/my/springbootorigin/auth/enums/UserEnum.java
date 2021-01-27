package com.my.springbootorigin.auth.enums;

import com.my.springbootorigin.common.enums.BaseErrorInfo;

public enum UserEnum implements BaseErrorInfo {
    USER_EXIST(1, "账户已存在"),
    USER_NOEXIST(2, "账户不存在")
    ;

    private Integer code;
    private String message;

    UserEnum(Integer code, String message) {
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
