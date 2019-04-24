//package com.tansuo365.test1.config;
//
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//
////@ConfigurationProperties(prefix = "druid")
//@Data
//@PropertySource(value="classpath:druid.properties")
//@Configuration
//public class DruidConfig {
//
//    @Value("${druid.url.allow}")
//    private String allowUrl;
//    @Value("${druid.url.deny}")
//    private String denyUrl;
//    @Value("${druid.login.username}")
//    private String loginUsername;
//    @Value("${druid.login.password}")
//    private String loginPassword;
//    @Value("${druid.reset}")
//    private String resetEnable;
//
//
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//
//    @Bean
//    public ServletRegistrationBean statViewServlet() {
//        //创建servlet注册实体
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        //设置ip白名单
//        servletRegistrationBean.addInitParameter("allow", allowUrl);
//        //设置ip黑名单,如果allow与deny共同存在时,deny优先于allow
//        servletRegistrationBean.addInitParameter("deny", denyUrl);
//
//        //添加控制台管理用户
//        servletRegistrationBean.addInitParameter("loginUsername", loginUsername);
//        servletRegistrationBean.addInitParameter("loginUsername", loginUsername);
//
//        //是否可以重置数据
//        servletRegistrationBean.addInitParameter("resetEnable", resetEnable);
//        return servletRegistrationBean;
//    }
//
//
//    @Bean
//    public static FilterRegistrationBean statFilter() {
//        //创建过滤器
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//        //设置过滤器过滤路径
//        filterRegistrationBean.addUrlPatterns("/druid/*");
//        //忽略过滤的形式
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
//}
