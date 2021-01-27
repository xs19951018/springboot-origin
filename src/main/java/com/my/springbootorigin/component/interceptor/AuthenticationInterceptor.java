package com.my.springbootorigin.component.interceptor;

import com.my.springbootorigin.config.Constants;
import com.my.springbootorigin.login.service.LoginService;
import com.my.springbootorigin.utils.JwtTokenUtil;
import com.my.springbootorigin.utils.ResultVOUtil;
import com.my.springbootorigin.utils.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 用户认证拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 如果请求不是映射到方法直接返回：解决axios会请求两次的问题
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String token = JwtTokenUtil.parseToken(request);
        if (StringUtils.hasLength(token)) {
            // 验证token
            ResultVO resultVO = loginService.validateUser(token);
            if (resultVO.getData() == null) {
                this.setResponse(response, resultVO.toString());
                return false;
            }

            // 解析user
            request.setAttribute(Constants.CURRENT_USER, resultVO.getData());
            return true;
        }

        ResultVO result = ResultVOUtil.error(2, "token 认证失败");
        this.setResponse(response, result.toString());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void setResponse(HttpServletResponse response, String res) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(res);
        pw.close();
    }

}
