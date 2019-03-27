package com.study.wrg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProjectProfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectProfileApplication.class, args);
    }

    @RequestMapping
    public String index(){
        return "hello profile";
    }
}
