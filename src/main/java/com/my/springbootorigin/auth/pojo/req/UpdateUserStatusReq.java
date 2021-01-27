package com.my.springbootorigin.auth.pojo.req;

import javax.validation.constraints.NotNull;

public class UpdateUserStatusReq {

    @NotNull(message = "id 不能为空")
    private Integer id;
    @NotNull(message = "status 不能为空")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
