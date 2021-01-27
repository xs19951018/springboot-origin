package com.my.springbootorigin.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.springbootorigin.auth.pojo.model.MenuInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MenuMapper extends BaseMapper<MenuInfo> {

    @Delete("delete from sys_role_menu where sys_role_menu.roleId = #{roleId}")
    Integer delRoleMenuRelation(@Param("roleId") Integer roleId);

}
