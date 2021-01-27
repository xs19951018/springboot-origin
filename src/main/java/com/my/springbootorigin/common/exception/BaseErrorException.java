package com.my.springbootorigin.common.exception;

import com.my.springbootorigin.common.enums.BaseErrorInfo;

/**
 * 业务异常处理类
 */
public class BaseErrorException extends RuntimeException {

    private Integer code;

    public BaseErrorException(){
    }

    public BaseErrorException(Integer code, String message) {
        super(message);

        this.code = code;
    }

    public BaseErrorException(BaseErrorInfo e) {
        super(e.getMessage());

        this.code = e.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
