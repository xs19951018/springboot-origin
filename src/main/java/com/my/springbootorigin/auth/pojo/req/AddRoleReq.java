package com.my.springbootorigin.auth.pojo.req;

import javax.validation.constraints.NotBlank;

public class AddRoleReq {

    @NotBlank(message = "角色名不能为空")
    private String name;
    private String description;

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
