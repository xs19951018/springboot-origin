package com.my.springbootorigin.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.my.springbootorigin.auth.enums.MenuEnum;
import com.my.springbootorigin.auth.enums.ResourceEnum;
import com.my.springbootorigin.auth.enums.RoleEnum;
import com.my.springbootorigin.auth.enums.UserEnum;
import com.my.springbootorigin.auth.mapper.MenuMapper;
import com.my.springbootorigin.auth.mapper.ResourceMapper;
import com.my.springbootorigin.auth.mapper.RoleMapper;
import com.my.springbootorigin.auth.mapper.UserMapper;
import com.my.springbootorigin.auth.pojo.model.MenuInfo;
import com.my.springbootorigin.auth.pojo.model.ResourceInfo;
import com.my.springbootorigin.auth.pojo.model.RoleInfo;
import com.my.springbootorigin.auth.pojo.model.UserInfo;
import com.my.springbootorigin.auth.pojo.req.*;
import com.my.springbootorigin.auth.service.AuthService;
import com.my.springbootorigin.common.enums.BaseErrEnum;
import com.my.springbootorigin.config.Constants;
import com.my.springbootorigin.utils.DateUtils;
import com.my.springbootorigin.utils.PageQueryUtils;
import com.my.springbootorigin.utils.ResultVOUtil;
import com.my.springbootorigin.common.exception.BaseErrorException;
import com.my.springbootorigin.utils.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private RoleMapper roleMapper;

    @Autowired(required = false)
    private MenuMapper menuMapper;

    @Autowired(required = false)
    private ResourceMapper resourceMapper;

    @Override
    public ResultVO getUserList(UserListReq body) {
        QueryWrapper<UserInfo> wrapper = PageQueryUtils.getWrapper(body);

        return ResultVOUtil.success(userMapper.selectPage(body.getPage(), wrapper));
    }

    @Override
    public ResultVO addUser(AddUserReq body) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("userName", body.getUserName());

        UserInfo userInfo = userMapper.selectOne(wrapper);
        if (userInfo != null) throw new BaseErrorException(UserEnum.USER_EXIST);

        UserInfo addUser = new UserInfo();
        BeanUtils.copyProperties(body, addUser);
        addUser.setAvatar(Constants.DEFAULT_AVATAR);
        int count = userMapper.insert(addUser);
        if (count != 1) throw new BaseErrorException(BaseErrEnum.ADD_ERR);

        return ResultVOUtil.success(addUser);
    }

    @Override
    public ResultVO updateUser(UpdateUserReq body) {
        UserInfo userInfo = userMapper.selectById(body.getId());
        if (userInfo == null) throw new BaseErrorException(UserEnum.USER_NOEXIST);

        UserInfo updateUser = new UserInfo();
        BeanUtils.copyProperties(body, updateUser);
        int count = userMapper.updateById(updateUser);
        if (count != 1) throw new BaseErrorException(BaseErrEnum.UPDATE_ERR);

        return ResultVOUtil.success(updateUser);
    }

    @Transactional
    @Override
    public ResultVO delUser(IdKeyReq body) {
        UserInfo userInfo = userMapper.selectById(body.getId());
        if (userInfo == null) throw new BaseErrorException(UserEnum.USER_NOEXIST);

        int count = userMapper.deleteById(body.getId());
        if (count != 1) throw new BaseErrorException(BaseErrEnum.DEL_ERR);

        roleMapper.delUserRoleRelation(body.getId());
        return ResultVOUtil.success(count);
    }

    @Override
    public ResultVO changeUserStatus(UpdateUserStatusReq body) {
        UserInfo userInfo = userMapper.selectById(body.getId());
        if (userInfo == null) throw new BaseErrorException(UserEnum.USER_NOEXIST);

        UserInfo updateUser = new UserInfo();
        BeanUtils.copyProperties(body, updateUser);
        int count = userMapper.updateById(updateUser);
        if (count != 1) throw new BaseErrorException(BaseErrEnum.UPDATE_ERR);

        return ResultVOUtil.success(updateUser);
    }

    @Override
    public ResultVO getRoleList(RoleListReq body) {
        QueryWrapper<RoleInfo> wrapper = PageQueryUtils.getWrapper(body);

        return ResultVOUtil.success(roleMapper.selectPage(body.getPage(), wrapper));
    }

    @Override
    public ResultVO addRole(AddRoleReq body) {
        QueryWrapper<RoleInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("name", body.getName());

        RoleInfo roleInfo = roleMapper.selectOne(wrapper);
        if (roleInfo != null) throw new BaseErrorException(RoleEnum.ROLE_EXIST);

        RoleInfo addRole = new RoleInfo();
        BeanUtils.copyProperties(body, addRole);
        addRole.setCreateTime(DateUtils.getNowDate());
        int count = roleMapper.insert(addRole);
        if (count != 1) throw new BaseErrorException(BaseErrEnum.ADD_ERR);

        return ResultVOUtil.success(addRole);
    }

    @Override
    public ResultVO updateRole(UpdateRoleReq body) {
        RoleInfo roleInfo = roleMapper.selectById(body.getId());
        if (roleInfo == null) throw new BaseErrorException(RoleEnum.ROLE_NOEXIST);

        RoleInfo updateRole = new RoleInfo();
        BeanUtils.copyProperties(body, updateRole);
        int count = roleMapper.updateById(updateRole);
        if (count != 1) throw new BaseErrorException(BaseErrEnum.UPDATE_ERR);

        return ResultVOUtil.success(updateRole);
    }

    @Transactional
    @Override
    public ResultVO delRole(IdKeyReq body) {
        RoleInfo roleInfo = roleMapper.selectById(body.getId());
        if (roleInfo == null) throw new BaseErrorException(RoleEnum.ROLE_NOEXIST);

        int count = roleMapper.deleteById(body.getId());
        if (count != 1) throw new BaseErrorException(BaseErrEnum.DEL_ERR);

        menuMapper.delRoleMenuRelation(body.getId());
        resourceMapper.delRoleResourceRelation(body.getId());
        return ResultVOUtil.success(count);
    }

    @Override
    public ResultVO getMenuList(MenuListReq body) {
        QueryWrapper<MenuInfo> wrapper = PageQueryUtils.getWrapper(body);

        return ResultVOUtil.success(menuMapper.selectPage(body.getPage(), wrapper));
    }

    @Override
    public ResultVO addMenu(AddMenuReq body) {
        QueryWrapper<MenuInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("name", body.getName());

        MenuInfo menuInfo = menuMapper.selectOne(wrapper);
        if (menuInfo != null) throw new BaseErrorException(MenuEnum.MENU_EXIST);

        MenuInfo addMenu = new MenuInfo();
        BeanUtils.copyProperties(body, addMenu);
        int count = menuMapper.insert(addMenu);
        if (count != 1) throw new BaseErrorException(BaseErrEnum.ADD_ERR);

        return ResultVOUtil.success(addMenu);
    }

    @Override
    public ResultVO updateMenu(UpdateMenuReq body) {
        MenuInfo menuInfo = menuMapper.selectById(body.getId());
        if (menuInfo == null) throw new BaseErrorException(MenuEnum.MENU_NOEXIST);

        MenuInfo updateMenu = new MenuInfo();
        BeanUtils.copyProperties(body, updateMenu);
        int count = menuMapper.updateById(updateMenu);
        if (count != 1) throw new BaseErrorException(BaseErrEnum.UPDATE_ERR);

        return ResultVOUtil.success(updateMenu);
    }

    @Override
    public ResultVO delMenu(IdKeyReq body) {
        MenuInfo menuInfo = menuMapper.selectById(body.getId());
        if (menuInfo == null) throw new BaseErrorException(MenuEnum.MENU_NOEXIST);

        int count = menuMapper.deleteById(body.getId());
        if (count != 1) throw new BaseErrorException(BaseErrEnum.DEL_ERR);

        return ResultVOUtil.success(count);
    }

    @Override
    public ResultVO getResourceList(ResourceListReq body) {
        QueryWrapper<ResourceInfo> wrapper = PageQueryUtils.getWrapper(body);

        return ResultVOUtil.success(resourceMapper.selectPage(body.getPage(), wrapper));
    }

    @Override
    public ResultVO addResource(AddResourceReq body) {
        QueryWrapper<ResourceInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("name", body.getName());

        ResourceInfo resourceInfo = resourceMapper.selectOne(wrapper);
        if (resourceInfo != null) throw new BaseErrorException(ResourceEnum.RESOURCE_EXIST);

        ResourceInfo addResource = new ResourceInfo();
        BeanUtils.copyProperties(body, addResource);
        int count = resourceMapper.insert(addResource);
        if (count != 1) throw new BaseErrorException(BaseErrEnum.ADD_ERR);

        return ResultVOUtil.success(addResource);
    }

    @Override
    public ResultVO updateResource(UpdateResourceReq body) {
        ResourceInfo resourceInfo = resourceMapper.selectById(body.getId());
        if (resourceInfo == null) throw new BaseErrorException(ResourceEnum.RESOURCE_NOEXIST);

        ResourceInfo updateResource = new ResourceInfo();
        BeanUtils.copyProperties(body, updateResource);
        int count = resourceMapper.updateById(updateResource);
        if (count != 1) throw new BaseErrorException(BaseErrEnum.UPDATE_ERR);

        return ResultVOUtil.success(updateResource);
    }

    @Override
    public ResultVO delResource(IdKeyReq body) {
        ResourceInfo resourceInfo = resourceMapper.selectById(body.getId());
        if (resourceInfo == null) throw new BaseErrorException(ResourceEnum.RESOURCE_NOEXIST);

        int count = resourceMapper.deleteById(body.getId());
        if (count != 1) throw new BaseErrorException(BaseErrEnum.DEL_ERR);

        return ResultVOUtil.success(count);
    }

}
