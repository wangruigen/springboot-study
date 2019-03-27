package com.study.wrg.mvcconfig;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义一个拦截器
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    private Log log = LogFactory.getLog(MyInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(" preHandle method ");
        System.out.println("uri "+request.getRequestURI());
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info(" postHandle method ");
        System.out.println("uri "+request.getRequestURI());
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info(" afterCompletion method ");
        System.out.println("uri "+request.getRequestURI());
    }
}
