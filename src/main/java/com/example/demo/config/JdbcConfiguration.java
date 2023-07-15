package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {

//    @Bean
//    @ConfigurationProperties(prefix = "jdbc")
//    public DataSource getDataSource() {
//        DataSource source =  new SimpleDriverDataSource();
//        return source;
//    }


//    @Configuration
//    @EnableConfigurationProperties(AcctJdbcProperties.class)//指定加载某个配置类
//    public class JdbcConfiguration {
//        @Bean
//        public DataSource getDataSource(AcctJdbcProperties jdbcProperties){
//            DruidDataSource source = new DruidDataSource();
//            source.setDriverClassName(jdbcProperties.getDriverClassName());
//            source.setUrl(jdbcProperties.getUrl());
//            source.setUsername(jdbcProperties.getUsername());
//            source.setPassword(jdbcProperties.getPassword());
//            return source;
//        }
//    }

}
