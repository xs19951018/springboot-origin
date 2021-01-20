package com.my.springbootorigin.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.springbootorigin.auth.pojo.PermissionInfo;
import com.my.springbootorigin.auth.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper extends BaseMapper<PermissionInfo> {


}
