package com.razz.DIusingjavaconfiguraiton.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value="com.razz.DIusingjavaconfiguraiton")
@EnableAspectJAutoProxy
public class AppConfig {
}
