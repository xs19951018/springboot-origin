package com.my.springbootorigin.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.my.springbootorigin.auth.mapper.UserMapper;
import com.my.springbootorigin.auth.pojo.UserInfo;
import com.my.springbootorigin.login.enums.LoginEnum;
import com.my.springbootorigin.login.pojo.dto.UserInfoDTO;
import com.my.springbootorigin.login.pojo.req.LoginReq;
import com.my.springbootorigin.login.service.LoginService;
import com.my.springbootorigin.utils.EncrypUtil;
import com.my.springbootorigin.utils.JwtTokenUtil;
import com.my.springbootorigin.utils.ResultVOUtil;
import com.my.springbootorigin.utils.exception.BaseErrorException;
import com.my.springbootorigin.utils.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public ResultVO login(LoginReq body) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("userName", body.getUserName());
        wrapper.eq("password", EncrypUtil.getMD5(body.getPassword()));
        UserInfo userInfo = userMapper.selectOne(wrapper);
        if (userInfo == null) throw new BaseErrorException(LoginEnum.LOGIN_ERR);

        UserInfoDTO loginUser = new UserInfoDTO();
        BeanUtils.copyProperties(userInfo, loginUser);
        // 签发token
        loginUser.setToken(JwtTokenUtil.createJwtToken(userInfo.getUserName()));

        return ResultVOUtil.success(loginUser);
    }

    @Override
    public ResultVO logout() {
        // TODO 注销
        return ResultVOUtil.success();
    }
}
