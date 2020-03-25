package com.zero.logistics.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName MybatisConfig
 * @Description TODO
 * @Author zero
 * @Date 2020/3/17 20:33
 * @Version 1.0
 */
@Configuration
@MapperScan("com.zero.logistics.dao")
public class MybatisConfig {
    //配置生成数据源
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}