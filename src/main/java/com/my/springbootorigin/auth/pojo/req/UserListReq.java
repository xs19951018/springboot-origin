package com.my.springbootorigin.auth.pojo.req;

import com.my.springbootorigin.common.annontations.WrapperConst;
import com.my.springbootorigin.common.annontations.WrapperInfo;
import com.my.springbootorigin.common.req.PageQuery;

public class UserListReq extends PageQuery {

    @WrapperInfo(value = WrapperConst.EQUALS)
    private String userName;
    @WrapperInfo(value = WrapperConst.EQUALS)
    private Integer status;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
