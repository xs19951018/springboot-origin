package com.my.springbootorigin.auth.service;

import com.my.springbootorigin.auth.pojo.req.*;
import com.my.springbootorigin.utils.vo.ResultVO;

public interface AuthService {

    /** user */
    ResultVO getUserList(UserListReq body);

    ResultVO addUser(AddUserReq body);

    ResultVO updateUser(UpdateUserReq body);

    ResultVO delUser(IdKeyReq body);

    ResultVO changeUserStatus(UpdateUserStatusReq body);

    /** role */
    ResultVO getRoleList(RoleListReq body);

    ResultVO addRole(AddRoleReq body);

    ResultVO updateRole(UpdateRoleReq body);

    ResultVO delRole(IdKeyReq body);

    /** menu */
    ResultVO getMenuList(MenuListReq body);

    ResultVO addMenu(AddMenuReq body);

    ResultVO updateMenu(UpdateMenuReq body);

    ResultVO delMenu(IdKeyReq body);

    /** resource */
    ResultVO getResourceList(ResourceListReq body);

    ResultVO addResource(AddResourceReq body);

    ResultVO updateResource(UpdateResourceReq body);

    ResultVO delResource(IdKeyReq body);

}
