package com.mengyirunian.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.mengyirunian.handler.DecimalTypeHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Jiaxiayuan on 2018/4/14
 */
@EnableTransactionManagement
@Configuration
@MapperScan(basePackages = "com.mengyirunian.mapper", sqlSessionFactoryRef = "weixinSysSqlSessionFactory")
public class WeixinDBConfig {

    @Value("${weixin.data.username}")
    private String username;
    @Value("${weixin.data.password}")
    private String password;
    @Value("${weixin.data.jdbcurl}")
    private String jdbcurl;
    @Value("${weixin.data.driver}")
    private String jdbcdriver;

    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(jdbcurl);
        druidDataSource.setDriverClassName(jdbcdriver);
        return druidDataSource;
    }

    @Bean
    public DataSourceTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "weixinSysSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());

        String mapperLocations = "classpath*:sqlMapper/*Mapper.xml";
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources(mapperLocations));
        sessionFactory.setPlugins(new Interceptor[]{pageHelper()});
        sessionFactory.setTypeHandlers(typeHandler());
        return sessionFactory.getObject();
    }

    @Bean
    public TypeHandler<?>[] typeHandler() {
        return new TypeHandler[]{new DecimalTypeHandler()};
    }

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("dialect", "mysql");
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }

    @Bean(name = "transactionTemplateStorage")
    public TransactionTemplate getTransactionTemplate() {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTimeout(30000);
        transactionTemplate.setTransactionManager(getTransactionManager());

        return transactionTemplate;
    }

    @Bean(name = "WeixinTransactionManager")
    public DataSourceTransactionManager getTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
}
