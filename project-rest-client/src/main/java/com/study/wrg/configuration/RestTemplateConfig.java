package com.study.wrg.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootConfiguration
public class RestTemplateConfig {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    @Bean
    public RestTemplate get() {
        return restTemplateBuilder.build();
    }
}
