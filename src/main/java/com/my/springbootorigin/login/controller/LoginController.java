package com.my.springbootorigin.login.controller;

import com.my.springbootorigin.login.pojo.req.LoginReq;
import com.my.springbootorigin.login.service.LoginService;
import com.my.springbootorigin.utils.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public ResultVO login(@RequestBody @Valid LoginReq body) {
        return loginService.login(body);
    }

    @RequestMapping("/logout")
    public ResultVO logout() {
        return loginService.logout();
    }

}
