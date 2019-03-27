package com.study.wrg;

import com.study.wrg.controller.IndexController;
import com.study.wrg.mvcconfig.MyInterceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*@SpringBootApplication(scanBasePackages = {
        "com.study.wrg.controller",
        "com.study.wrg.repository",
        "com.study.wrg.service"})*/
@SpringBootApplication
//@ServletComponentScan
public class ProjectSimpleApplication{

    public static void main(String[] args) {

        SpringApplication.run(ProjectSimpleApplication.class, args);
    }
}
