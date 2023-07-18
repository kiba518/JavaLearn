package com.example.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@EnableAdminServer

@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext application = SpringApplication.run(AdminApplication.class, args);
        Environment env = application.getEnvironment();

        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------启动模块:{"+env.getProperty("server.servlet.context-path")+"}");
        log.info("--------------------------------------------------------------------------------------------------------------------");
        //log.info("-----------------启动模块:{}", env.getProperty("server.servlet.context-path"));
        log.info("-----------------启动端口:{}", env.getProperty("server.port"));
        log.info("-----------------admin地址:{}", "http://localhost:" + env.getProperty("server.port"));
    }



}
