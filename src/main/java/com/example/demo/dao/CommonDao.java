//package com.example.demo.dao;
//
//import lombok.Value;
//import org.apache.ibatis.session.ExecutorType;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.support.SqlSessionDaoSupport;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.naming.Context;
//import javax.naming.InitialContext;
//
//@Component
//public class CommonDao   {
//    @Value("${mybatis-plus.mapper-locations}")
//    private String mapperLocations;
//    //配置FactoryBean
//    @Bean(name = "sqlSessionFactoryBean")
//    public SqlSessionFactoryBean sqlSessionFactoryBean() {
//        SqlSessionFactoryBean sqlSessionFactoryBean = null;
//        try {
//            // 加载JNDI配置
//            Context context = new InitialContext();
//            // 实例SessionFactory
//            sqlSessionFactoryBean = new SqlSessionFactoryBean();
//            // 配置数据源
//            sqlSessionFactoryBean.setDataSource(dataSource());
//            // 加载MyBatis配置文件
//            PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
//            // 能加载多个，所以可以配置通配符(如：classpath*:mapper/**/*.xml)
//            sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources(mapperLocations));
//        } catch (Exception e) {
//            System.out.println("创建SqlSession连接工厂错误：{}");
//        }
//        return sqlSessionFactoryBean;
//    }
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
//        SqlSessionTemplate sqlSessionTemplate=new SqlSessionTemplate(sqlSessionFactoryBean().getObject(), ExecutorType.BATCH);
//        return sqlSessionTemplate;
//    }
//}