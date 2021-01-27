package com.my.springbootorigin.auth.enums;

import com.my.springbootorigin.common.enums.BaseErrorInfo;

public enum RoleEnum implements BaseErrorInfo {
    ROLE_EXIST(1, "角色名已存在"),
    ROLE_NOEXIST(2, "角色不存在")
    ;

    private Integer code;
    private String message;

    RoleEnum(Integer code, String message) {
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
