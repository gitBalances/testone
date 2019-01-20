package com.tansuo365.test1.config;

import com.tansuo365.test1.resolver.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class MyAppConfig {

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
