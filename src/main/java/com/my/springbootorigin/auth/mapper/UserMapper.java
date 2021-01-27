package com.my.springbootorigin.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.springbootorigin.auth.pojo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {

    @Select("select id,userName,password,name,phone,avatar,createTime,status from sys_user where userName = #{userName}")
    UserInfo getLoginUser(@Param("userName") String userName);
}
