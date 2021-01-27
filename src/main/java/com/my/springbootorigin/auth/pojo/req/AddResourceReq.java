package com.my.springbootorigin.auth.pojo.req;

import javax.validation.constraints.NotBlank;

public class AddResourceReq {

    @NotBlank(message = "name 不能为空")
    private String name;
    @NotBlank(message = "code 不能为空")
    private String code;
    @NotBlank(message = "url 不能为空")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
