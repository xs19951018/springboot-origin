package com.my.springbootorigin.utils.enums;

/**
 * 基础ERROR接口
 */
public interface BaseErrorInfo {

    /** 错误码 */
    Integer getCode();
    /** 错误内容 */
    String getMessage();

}
