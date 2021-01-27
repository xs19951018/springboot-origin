package com.my.springbootorigin.auth.pojo.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateRoleReq {

    @NotNull(message = "id 不能为空")
    private Integer id;
    @NotBlank(message = "角色名称不能为空")
    private String name;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
