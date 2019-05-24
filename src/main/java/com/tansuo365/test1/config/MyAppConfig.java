package com.tansuo365.test1.config;

import com.tansuo365.test1.config.resolver.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.LocaleResolver;

/*国际化解析器 和@Value引入配置*/
@Configuration
public class MyAppConfig {
    //国际化,使中文/英文(或多国语言)切换成为可能
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //让@Value加载properties中的参数成为可能
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
