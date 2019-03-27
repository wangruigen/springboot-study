package com.study.wrg;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import javax.sql.DataSource;

@SpringBootApplication
@EnableTransactionManagement //开启事务管理
public class ProjectDatasourceApplication implements CommandLineRunner {

    private Log log = LogFactory.getLog(ProjectDatasourceApplication.class);

    @Autowired
    DataSource dataSource;



    public static void main(String[] args) {
        SpringApplication.run(ProjectDatasourceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("dataSource is "+dataSource);
        log.info("connection is "+dataSource.getConnection());

    }
}
