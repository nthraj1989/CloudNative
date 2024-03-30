package com.razz.DIusingjavaconfiguraiton.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "classpath:ds.properties")
public class JdbcTemplateConfiguration {
    @Value("${spring.datasource.driver}")
    private String driver;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.user}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;


    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(url);
        ds.setDriverClassName(driver);
        ds.setUsername(user);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource ds){
        return new JdbcTemplate(ds);
    }
}
