package com.study.wrg.mvcconfig;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "MyFilter",urlPatterns = {"/index/*"})
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("进入拦截器："+ MyFilter.class);
        long start = System.currentTimeMillis();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        filterChain.doFilter(servletRequest,servletResponse);
        //System.out.println("拦截器通过：");
        long end = System.currentTimeMillis();
        System.out.println(request.getRequestURL()+"花费时间 "+(end-start)+"ms");

    }
}
