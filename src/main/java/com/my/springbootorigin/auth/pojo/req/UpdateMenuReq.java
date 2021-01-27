package com.my.springbootorigin.auth.pojo.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateMenuReq {

    @NotNull(message = "id 不能为空")
    private Integer id;
    @NotBlank(message = "name 不能为空")
    private String name;
    private Integer parentId;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
