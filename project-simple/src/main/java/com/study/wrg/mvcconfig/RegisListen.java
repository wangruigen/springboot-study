package com.study.wrg.mvcconfig;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContextListener;
import java.util.EventListener;

@SpringBootConfiguration
public class RegisListen  {

    @Bean
    public ServletListenerRegistrationBean registrationBean(){
        ServletListenerRegistrationBean<EventListener> registrationBean = new ServletListenerRegistrationBean<>();
        registrationBean.setListener(new MyListener2());
        return registrationBean;
    }

}
