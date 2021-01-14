package com.my.springbootorigin.utils.exception;

import com.my.springbootorigin.utils.enums.BaseErrorInfo;

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
