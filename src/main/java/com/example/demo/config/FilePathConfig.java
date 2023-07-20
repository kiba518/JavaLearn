package com.example.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FilePathConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/static/img**").addResourceLocations("classpath:/static/img");
        //        registry.addResourceHandler("/uploadPath/**").addResourceLocations("file:/data/uploadPath/drugques/");
//        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/upload/20211013/");

    }

}
