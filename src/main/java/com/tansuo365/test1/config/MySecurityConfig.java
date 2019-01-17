//package com.tansuo365.test1.config;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        super.configure(http);
//        //定制请求的授权规则
//        http.authorizeRequests().antMatchers("/admin/123/**").permitAll()
//                .antMatchers("/admin/**").hasRole("VIP1")
//                .antMatchers("/admin/level2/**").hasRole("VIP2")
//                .antMatchers("/admin/level3/**").hasRole("VIP3");
//
//        //开启自动配置的登录功能,效果,如果没有权限就会到登录页面
//        //1./login请求到登录页
//        //2.重定向到/login?error表示登录失败
//        //3.更多详细规定
//        http.formLogin().loginPage("/admin/login");
//
//        //开启自动配置的注销功能
//        http.logout().logoutSuccessUrl("/");//注销成功来到首页
//        //1.访问/logout表示用户注销,清空session
//        //2.注销成功会返回/login?logout页面
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
//        auth.inMemoryAuthentication().withUser("zhang3").password("12345").roles("VIP1","VIP2")
//                .and()
//                .withUser("lisi").password("654321").roles("VIP1");
//    }
//
//}
