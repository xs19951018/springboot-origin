package com.my.springbootorigin.utils.vo;

import com.google.gson.Gson;

/**
 * httpRequest 返回对象
 */
public class ResultVO<T> {

    /** 返回码 */
    private Integer code = 0;

    /** 提示信息 */
    private String message;

    /** 具体内容 */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
