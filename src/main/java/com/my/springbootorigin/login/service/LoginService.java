package com.my.springbootorigin.login.service;

import com.my.springbootorigin.login.pojo.req.LoginReq;
import com.my.springbootorigin.utils.vo.ResultVO;

public interface LoginService {

    /**
     * 登录
     * @param body
     * @return
     */
    ResultVO login(LoginReq body);

    /**
     * 登出
     */
    ResultVO logout();

    /**
     * 验证token
     * @param token
     * @return userInfo
     */
    ResultVO validateUser(String token);

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    ResultVO getUserInfo(String token);
}
