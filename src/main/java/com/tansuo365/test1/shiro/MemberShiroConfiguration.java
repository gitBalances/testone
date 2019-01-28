package com.tansuo365.test1.shiro;

import com.tansuo365.test1.bean.Member;
import com.tansuo365.test1.filter.MemberURLPathMatchingFilter;
import com.tansuo365.test1.realm.MemberDatabaseRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/*前端会员权限配置类*/
@Configuration
public class MemberShiroConfiguration {

    @Autowired
    private ShiroConfiguration shiroConfiguration;
    @Bean
    public ShiroFilterFactoryBean memberShiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();

        //必须设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        shiroFilterFactoryBean.setLoginUrl("/user/login");
        //会员成功登录后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("../index");
        //未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/unauthorized");
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        //自定义拦截器
        Map<String,Filter> customisedFilter = new HashMap<>();
        customisedFilter.put("url",getMemberURLPathMatchingFilter());

        filterChainDefinitionMap.put("/user/login","anon");
        filterChainDefinitionMap.put("/static/**","anon");
//        filterChainDefinitionMap.put("/user/config/**", "anon");
        filterChainDefinitionMap.put("/user/doLogout","logout");//前端客户登出
        filterChainDefinitionMap.put("/user/**","url");
        filterChainDefinitionMap.put("/user/**","user");
        shiroFilterFactoryBean.setFilters(customisedFilter);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    public MemberURLPathMatchingFilter getMemberURLPathMatchingFilter(){
        return new MemberURLPathMatchingFilter();
    }

    @Bean
    public MemberDatabaseRealm getMemberDatabaseRealm(){
        MemberDatabaseRealm memberShiroRealm = new MemberDatabaseRealm();
        memberShiroRealm.setCredentialsMatcher(shiroConfiguration.hashedCredentialsMatcher());
        return memberShiroRealm;
    }




}
