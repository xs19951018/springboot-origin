package com.my.springbootorigin.auth.enums;

import com.my.springbootorigin.common.enums.BaseErrorInfo;

public enum ResourceEnum implements BaseErrorInfo {
    RESOURCE_EXIST(1, "资源code已存在"),
    RESOURCE_NOEXIST(2, "资源不存在")
    ;

    private Integer code;
    private String message;

    ResourceEnum(Integer code, String message) {
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
