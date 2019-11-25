package com.tianhe.foreach.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.tianhe.foreach.mapper.sun",sqlSessionFactoryRef = "sunSqlSessionFactory")
public class SunDataSourceConfig {
    @Primary
    @Bean(name = "sunDataSource")
    @ConfigurationProperties("spring.datasource.sun")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sunSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("sunDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/sun/*.xml"));
        return sessionFactoryBean.getObject();
    }

}
