package com.my.springbootorigin.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.springbootorigin.auth.pojo.model.RoleInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMapper extends BaseMapper<RoleInfo> {

    @Delete("delete from sys_user_role where sys_user_role.userId = #{userId}")
    Integer delUserRoleRelation(@Param("userId") Integer userId);

}
