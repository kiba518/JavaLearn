package com.example.demo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.io.InputStream;


@EnableTransactionManagement
@MapperScan("com.example.demo.dao.mapper")
@Configuration
public class MybatisPlusConfig {

//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws IOException {
//        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
//        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
//        return build;
//    }


//    @Bean("sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(multipleDataSource(db1(),db2()));
//        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:/com/yaogor/multipledatasource/mapper/*.xml"));
//        //添加事物配置（重点）
//        sqlSessionFactory.setTransactionFactory(new MultiDataSourceTransactionFactory());
//        MybatisConfiguration configuration = new MybatisConfiguration();
//        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//        configuration.setJdbcTypeForNull(JdbcType.NULL);
//        configuration.setMapUnderscoreToCamelCase(true);
//        configuration.setCacheEnabled(false);
//        sqlSessionFactory.setConfiguration(configuration);
//        sqlSessionFactory.setPlugins(new Interceptor[]{ //PerformanceInterceptor(),OptimisticLockerInterceptor()
//                paginationInterceptor(), //添加分页功能
//        });
//        return sqlSessionFactory.getObject();
//    }

//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor(){
//        MybatisPlusInterceptor mpi = new MybatisPlusInterceptor();
//        mpi.addInnerInterceptor(new PaginationInnerInterceptor());
//        return mpi;
//    }


    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,
     * 需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }



//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
//        paginationInnerInterceptor.setOptimizeJoin(true);
//        paginationInnerInterceptor.setDbType(DbType.MYSQL);
//        paginationInnerInterceptor.setOverflow(true);
//        interceptor.addInnerInterceptor(paginationInnerInterceptor);
//        OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor = new OptimisticLockerInnerInterceptor();
//        interceptor.addInnerInterceptor(optimisticLockerInnerInterceptor);
//        return interceptor;
//    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }

//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
//        //修改为MybatisSqlSessionFactoryBean
//        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//        //插件类
//        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
//        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//
//        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
//        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
//        sqlSessionFactoryBean.setGlobalConfig(globalConfig);
//        //添加插件
//        sqlSessionFactoryBean.setPlugins(mybatisPlusInterceptor);
//        return sqlSessionFactoryBean.getObject();
//    }

//    @Bean(name = "globalConfig")
//    public GlobalConfig globalConfig(@Qualifier("myBatisPlusMetaObjectHandler") MyBatisPlusMetaObjectHandler metaObjectHandler) {
//        GlobalConfig globalConfig = new GlobalConfig();
//        globalConfig.setMetaObjectHandler(metaObjectHandler);
//        return globalConfig;
//    }
//
//    @Bean
//    @Primary
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource,
//                                               @Qualifier("globalConfig") GlobalConfig globalConfig) throws Exception {
//        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource);
//
//        //添加分页功能================================================================================================
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//
//        sqlSessionFactory.setPlugins(interceptor);
//        sqlSessionFactory.setGlobalConfig(globalConfig);
//
//        return sqlSessionFactory.getObject();
//    }
//
//    @Bean
//    @Primary
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    @Bean
//    @Primary
//    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }


}
