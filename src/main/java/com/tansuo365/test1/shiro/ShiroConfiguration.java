package com.tansuo365.test1.shiro;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

//import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.tansuo365.test1.filter.URLPathMatchingFilter;
import com.tansuo365.test1.realm.DatabaseRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*权限配置类*/
@Configuration
public class ShiroConfiguration {

    //用于thymeleaf模板使用shiro标签
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，因为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *
     Filter Chain定义说明
     1、一个URL可以配置多个Filter，使用逗号分隔
     2、当设置多个过滤器时，全部验证通过，才视为通过
     3、部分过滤器可指定参数，如perms，roles
     *
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/admin/login"); //原为/login
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/admin/"); //原为/index
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/admin/unauthorized"); //原为/unauthorized
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        //自定义拦截器
        Map<String, Filter> customisedFilter = new HashMap<>();
        customisedFilter.put("url", getURLPathMatchingFilter());
        //配置映射关系 anon表示不需要权限即可访问
//        filterChainDefinitionMap.put("/login", "anon");
//        filterChainDefinitionMap.put("/index", "anon");
//        filterChainDefinitionMap.put("/static/**", "anon");
//        filterChainDefinitionMap.put("/config/**", "anon");
//        filterChainDefinitionMap.put("/doLogout", "logout");;
//        filterChainDefinitionMap.put("/**", "url");
//        shiroFilterFactoryBean.setFilters(customisedFilter);
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
        filterChainDefinitionMap.put("/admin/login", "anon");
//        filterChainDefinitionMap.put("/admin/index", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/admin/config/**", "anon");
        filterChainDefinitionMap.put("/admin/doLogout", "logout");;
//        filterChainDefinitionMap.put("/admin/**", "url"); //路径/shiro_admin/**全部需要进行权限验证
        //其他资源都需要认证  authc 表示需要认证才能进行访问 user表示配置记住我或认证通过可以访问的地址
        filterChainDefinitionMap.put("/admin/**", "user");
        shiroFilterFactoryBean.setFilters(customisedFilter);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    public URLPathMatchingFilter getURLPathMatchingFilter() {
    	return new URLPathMatchingFilter();
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //设置自定义realm.
        securityManager.setRealm(getDatabaseRealm());
        //配置记住我
        securityManager.setRememberMeManager(rememberMeManager());

        return securityManager;
    }

    @Bean
    public DatabaseRealm getDatabaseRealm(){
        DatabaseRealm myShiroRealm = new DatabaseRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     *  所以我们需要修改下doGetAuthenticationInfo中的代码;
     * ）
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();

        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));

        return hashedCredentialsMatcher;
    }

    /**
     * cookie对象,会话Cookie模板,默认为:JSESSIONID
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie(){
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setPath("/admin/");
        simpleCookie.setMaxAge(60*60*24*30);//一个月cookie保留时间
        return simpleCookie;
    }

    /**
     * cookie管理对象,记住我功能,rememberMe管理器
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    /**
     * FormAuthenticationFilter过滤器 过滤记住我
     * @return
     */
    @Bean
    public FormAuthenticationFilter formAuthenticationFilter(){
        FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
        formAuthenticationFilter.setRememberMeParam("rememberMe");
        return formAuthenticationFilter;
    }

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}