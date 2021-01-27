package com.my.springbootorigin.auth.pojo.req;

import com.my.springbootorigin.common.annontations.WrapperConst;
import com.my.springbootorigin.common.annontations.WrapperInfo;
import com.my.springbootorigin.common.req.PageQuery;

public class MenuListReq extends PageQuery {

    @WrapperInfo(value = WrapperConst.EQUALS)
    private String name;
    @WrapperInfo(value = WrapperConst.EQUALS)
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
