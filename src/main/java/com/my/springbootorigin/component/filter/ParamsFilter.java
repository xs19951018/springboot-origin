package com.my.springbootorigin.component.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ParamsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ParamterRequestWrapper paramterRequestWrapper = new ParamterRequestWrapper((HttpServletRequest) servletRequest);
        filterChain.doFilter(paramterRequestWrapper, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
