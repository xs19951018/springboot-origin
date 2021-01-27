package com.my.springbootorigin.common.enums;

public enum BaseErrEnum implements BaseErrorInfo {
    ADD_ERR(10, "新增失败"),
    UPDATE_ERR(11, "修改失败"),
    DEL_ERR(12, "删除失败")
    ;

    private Integer code;
    private String message;

    BaseErrEnum(Integer code, String message) {
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
