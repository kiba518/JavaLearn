package com.example.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.stream.Stream;
@Log4j2
@SpringBootApplication
@ComponentScan({"com.*"})
@EnableSwagger2
public class DemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args);

        ConfigurableApplicationContext application = SpringApplication.run(DemoApplication.class, args);
        Environment env = application.getEnvironment();

        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------启动模块:{"+env.getProperty("server.servlet.context-path")+"}");
        log.info("--------------------------------------------------------------------------------------------------------------------");
        log.info("-----------------启动模块:{}", env.getProperty("server.servlet.context-path"));
        log.info("-----------------启动端口:{}", env.getProperty("server.port"));
        log.info("-----------------api地址:{}", "http://localhost:" + env.getProperty("server.port") + env.getProperty("server.servlet.context-path"));
        log.info("-----------------swagger-ui:{}", "http://localhost:" + env.getProperty("server.port")+ env.getProperty("server.servlet.context-path")+"/swagger-ui.html");
//        log.info("-----------------swagger-knife4j-ui:{}", "http://localhost:" + env.getProperty("server.port")+ env.getProperty("server.servlet.context-path")+"/doc.html");

//        log.info("-----------------当前加载的bean");
//        log.info("--------------------------------------------------------------------------------------------------------------------");
//        String[] beanDefinitionNames = application.getBeanDefinitionNames();
//        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }

}