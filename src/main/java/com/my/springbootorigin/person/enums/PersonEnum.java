package com.my.springbootorigin.person.enums;

import com.my.springbootorigin.utils.enums.BaseErrorInfo;

public enum PersonEnum implements BaseErrorInfo {

    ADD_ERR(1, "添加失败")
    ;

    private Integer code;

    private String message;

    PersonEnum(Integer code, String message) {
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
