package com.study.wrg.mvcconfig;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 通过@SpringBootConfiguration配置类，注册一个@Bean FilterRegistrationBean
 */
@SpringBootConfiguration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter2());
        registration.addUrlPatterns("/map/*");
        registration.setName("MyFilter2");
        registration.setOrder(1);
        return registration;
    }
}
