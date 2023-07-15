//package com.example.demo.config;
//
//
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
//import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
//import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
//import lombok.extern.slf4j.Slf4j;
//import net.sf.jsqlparser.expression.Expression;
//import net.sf.jsqlparser.expression.LongValue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Slf4j
//@Configuration
//public class MybatisPlusConfig2 {
//
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        log.info("进入sql拦截器");
//        //分页拦截器插件
//        //如果用了分页插件注意先 add TenantLineInnerInterceptor 再 add PaginationInnerInterceptor
//        interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(new TenantLineHandler() {
//            //租户id(拼接sql的条件的值)
//            @Override
//            public Expression getTenantId() {
//                return new LongValue(1);
//            }
//
//            //追加的字段(拼接sql的条件)
//            @Override
//            public String getTenantIdColumn() {
//                return "SU_CODE";
//            }
//
////            //去掉实体类字段
////            @Override
////            public boolean ignoreTable(String tableName) {
////                String[] arr = new String[]{
////                        "susCode",
////                        "suName",
////                        "suSex",
////                        "suAge"
////                };
////                return ArrayUtil.contains(arr, tableName);
////            }
//        }));
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//        return interceptor;
//    }
//
////    // 用了分页插件必须设置 MybatisConfiguration#useDeprecatedExecutor = false
////    //        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
////    @Bean
////    public ConfigurationCustomizer configurationCustomizer() {
////        return configuration -> configuration.setUseDeprecatedExecutor(false);
////    }
//}
