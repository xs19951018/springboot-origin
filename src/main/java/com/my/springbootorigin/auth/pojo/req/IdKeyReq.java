package com.my.springbootorigin.auth.pojo.req;

import javax.validation.constraints.NotNull;

public class IdKeyReq {

    @NotNull(message = "id 不能为空")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
