package com.study.wrg.mvcconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 通过配置@SpringBootConfiguration来定义配置类，实现WebMvcConfigurer注册拦截器
 */
@SpringBootConfiguration
public class RegisterInter implements WebMvcConfigurer {
    @Autowired
    MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器new MyInterceptor()，拦截index/**接口
       // registry.addInterceptor(myInterceptor).addPathPatterns("/index/**");

        //可以注册多个拦截器registry.addInterceptor(myInterceptor2).addPathPatterns("/index/**");
        //可以注册多个拦截器registry.addInterceptor(myInterceptor3).addPathPatterns("/index/**");
    }

}
