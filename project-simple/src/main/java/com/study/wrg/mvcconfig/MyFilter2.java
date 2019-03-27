package com.study.wrg.mvcconfig;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class MyFilter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入拦截器："+ MyFilter2.class);
        long start = System.currentTimeMillis();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("拦截器通过：");
        long end = System.currentTimeMillis();
        System.out.println(request.getRequestURL()+"花费时间 "+(end-start)+"ms");

    }
}
