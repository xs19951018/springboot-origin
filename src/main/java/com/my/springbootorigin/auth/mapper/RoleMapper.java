package com.my.springbootorigin.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.springbootorigin.auth.pojo.RoleInfo;
import com.my.springbootorigin.auth.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<RoleInfo> {


}
