package com.my.springbootorigin.component.interceptor;

import com.my.springbootorigin.utils.JwtTokenUtil;
import com.my.springbootorigin.utils.ResultVOUtil;
import com.my.springbootorigin.utils.vo.ResultVO;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 用户认证拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = JwtTokenUtil.parseToken(request);
        if (StringUtils.hasLength(token)) {
            // token 是否过期
            boolean expiration = JwtTokenUtil.isExpiration(token);
            if (!expiration) {
                return true;
            }
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
