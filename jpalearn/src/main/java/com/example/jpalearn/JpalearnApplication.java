package com.example.jpalearn;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Log4j2
@EnableSwagger2
@SpringBootApplication
public class JpalearnApplication {

    public static void main(String[] args)
    {

        ConfigurableApplicationContext application = SpringApplication.run(JpalearnApplication.class, args);
        Environment env = application.getEnvironment();

        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------启动模块:{"+env.getProperty("server.servlet.context-path")+"}");
        log.info("--------------------------------------------------------------------------------------------------------------------");
        log.info("-----------------启动模块:{}", env.getProperty("server.servlet.context-path"));
        log.info("-----------------启动端口:{}", env.getProperty("server.port"));
        log.info("-----------------api地址:{}", "http://localhost:" + env.getProperty("server.port") + env.getProperty("server.servlet.context-path"));
        log.info("-----------------swagger-ui:{}", "http://localhost:" + env.getProperty("server.port")+ env.getProperty("server.servlet.context-path")+"/swagger-ui.html");
//
    }

}
