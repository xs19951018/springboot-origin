package com.my.springbootorigin.auth.controller;

import com.my.springbootorigin.auth.pojo.req.*;
import com.my.springbootorigin.auth.service.AuthService;
import com.my.springbootorigin.utils.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * 用户列表
     * @param body
     * @return
     */
    @RequestMapping("/getUserList")
    public ResultVO getUserList(@RequestBody UserListReq body) {
        return authService.getUserList(body);
    }

    @RequestMapping("/addUser")
    public ResultVO addUser(@RequestBody @Valid AddUserReq body) {
        return authService.addUser(body);
    }

    @RequestMapping("/updateUser")
    public ResultVO updateUser(@RequestBody @Valid UpdateUserReq body) {
        return authService.updateUser(body);
    }

    @RequestMapping("/delUser")
    public ResultVO delUser(@RequestBody @Valid IdKeyReq body) {
        return authService.delUser(body);
    }

    @RequestMapping("/changeUserStatus")
    public ResultVO changeUserStatus(@RequestBody @Valid UpdateUserStatusReq body) {
        return authService.changeUserStatus(body);
    }

    /**
     * 角色列表
     * @param body
     * @return
     */
    @RequestMapping("/getRoleList")
    public ResultVO getRoleList(@RequestBody RoleListReq body) {
        return authService.getRoleList(body);
    }

    @RequestMapping("/addRole")
    public ResultVO addRole(@RequestBody @Valid AddRoleReq body) {
        return authService.addRole(body);
    }

    @RequestMapping("/updateRole")
    public ResultVO updateRole(@RequestBody @Valid UpdateRoleReq body) {
        return authService.updateRole(body);
    }

    @RequestMapping("/delRole")
    public ResultVO delRole(@RequestBody @Valid IdKeyReq body) {
        return authService.delRole(body);
    }

    /**
     * 菜单列表
     * @param body
     * @return
     */
    @RequestMapping("/getMenuList")
    public ResultVO getMenuList(@RequestBody MenuListReq body) {
        return authService.getMenuList(body);
    }

    @RequestMapping("/addMenu")
    public ResultVO addMenu(@RequestBody @Valid AddMenuReq body) {
        return authService.addMenu(body);
    }

    @RequestMapping("/updateMenu")
    public ResultVO updateMenu(@RequestBody @Valid UpdateMenuReq body) {
        return authService.updateMenu(body);
    }

    @RequestMapping("/delMenu")
    public ResultVO delMenu(@RequestBody @Valid IdKeyReq body) {
        return authService.delMenu(body);
    }

    /**
     * 资源列表
     * @param body
     * @return
     */
    @RequestMapping("/getResourceList")
    public ResultVO getResourceList(@RequestBody ResourceListReq body) {
        return authService.getResourceList(body);
    }

    @RequestMapping("/addResource")
    public ResultVO addResource(@RequestBody @Valid AddResourceReq body) {
        return authService.addResource(body);
    }

    @RequestMapping("/updateResource")
    public ResultVO updateResource(@RequestBody @Valid UpdateResourceReq body) {
        return authService.updateResource(body);
    }

    @RequestMapping("/delResource")
    public ResultVO delResource(@RequestBody @Valid IdKeyReq body) {
        return authService.delResource(body);
    }
}
