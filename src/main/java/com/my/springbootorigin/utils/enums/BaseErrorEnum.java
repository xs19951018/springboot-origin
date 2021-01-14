package com.my.springbootorigin.utils.enums;

/**
 * 基本业务处理错误enum
 */
public enum BaseErrorEnum implements BaseErrorInfo {

    ADD_ERR(1, "添加失败"),
    DEL_ERR(2, "删除失败"),
    UPDATE_ERR(3, "更新失败")
    ;
    private Integer code;

    private String message;

    BaseErrorEnum(Integer code, String message) {
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
