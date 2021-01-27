package com.my.springbootorigin.auth.pojo.req;

import com.my.springbootorigin.common.annontations.WrapperConst;
import com.my.springbootorigin.common.annontations.WrapperInfo;
import com.my.springbootorigin.common.req.PageQuery;

public class RoleListReq extends PageQuery {

    @WrapperInfo(value = WrapperConst.EQUALS)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
