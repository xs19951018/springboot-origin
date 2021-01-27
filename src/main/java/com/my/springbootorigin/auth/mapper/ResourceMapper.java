package com.my.springbootorigin.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.springbootorigin.auth.pojo.model.ResourceInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ResourceMapper extends BaseMapper<ResourceInfo> {

    @Delete("delete from sys_role_resource where sys_role_resource.roleId = #{roleId}")
    Integer delRoleResourceRelation(@Param("roleId") Integer roleId);

}
