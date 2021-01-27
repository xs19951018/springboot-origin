package com.my.springbootorigin.auth.enums;

import com.my.springbootorigin.common.enums.BaseErrorInfo;

public enum MenuEnum implements BaseErrorInfo {
    MENU_EXIST(1, "菜单名称已存在"),
    MENU_NOEXIST(2, "菜单不存在")
    ;

    private Integer code;
    private String message;

    MenuEnum(Integer code, String message) {
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
