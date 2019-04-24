package com.tansuo365.test1.config.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.tansuo365.test1.config.shiro.realm.DatabaseRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

//import com.tansuo365.test1.filter.URLPathMatchingFilter;

//import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

/*权限配置类*/
@Configuration
public class ShiroConfiguration {
//    @Autowired
//    private MemberShiroConfiguration memberShiroConfiguration;

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
     * <p>
     * Filter Chain定义说明
     * 1、一个URL可以配置多个Filter，使用逗号分隔
     * 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //TODO 2019-1-29 17:40
        //将设置url的参数改为application.properties中去配置
        //securityManager改为可选择的进行传入
        //customisedFilter的hashmap传入的url及URLPath...Filter改为参数可传入
        //customisedFilter这个HashMap装配了登录及登录后可未授权页面(admin的配置admin的,member的配置member的)
        //filterChainDefinitionMap

        //1.securityManager中的realm按需配置
        //2.shiroFilterFactoryBean中的set...Url为按需配置
        //3.shiroFilterFactoryBean.setFilters(customisedFilter);中的customisedFilter按需配置
        //**customisedFilter为put了仅仅一个"url",value为URL路径匹配过滤器(按需传入)
        //4.shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //**filterChainDefinitionMap为按需配置



        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        //这里注释掉user/login,并用
//        shiroFilterFactoryBean.setLoginUrl("/user/login"); //原为/login
        shiroFilterFactoryBean.setLoginUrl("/admin/login"); //原为/login 会覆盖前面的出错

        // 登录成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/user/index"); //原为/index
        //未授权界面;
//        shiroFilterFactoryBean.setUnauthorizedUrl("/user/unauthorized"); //原为/unauthorized
        //拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        //自定义拦截器
//        Map<String, Filter> customisedFilter = new HashMap<>();
//        customisedFilter.put("url", getURLPathMatchingFilter());
//        customisedFilter.put("theMember",theMember());
//        customisedFilter.put("theAdmin",theAdmin());

//        //配置映射关系 anon表示不需要权限即可访问
//        filterChainDefinitionMap.put("/user/login", "anon");
        filterChainDefinitionMap.put("/admin/login", "anon");
        filterChainDefinitionMap.put("/admin/loginAdmin", "anon");
////        filterChainDefinitionMap.put("/admin/index", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/admin/config/**", "anon");
        filterChainDefinitionMap.put("/admin/reg", "anon");
        filterChainDefinitionMap.put("/admin/register", "anon");
//        filterChainDefinitionMap.put("/user/doLogout", "logout");
        filterChainDefinitionMap.put("/admin/doLogout", "logout");
//        ;//后台登出
////      单独放入member的配置中  filterChainDefinitionMap.put("/member/doLogout","logout");//前端客户登出
//        filterChainDefinitionMap.put("/user/**", "url"); //路径/shiro_admin/**全部需要进行权限验证
//        filterChainDefinitionMap.put("/admin/**", "url"); //路径/shiro_admin/**全部需要进行权限验证
//        //其他资源都需要认证  authc 表示需要认证才能进行访问 user表示配置记住我或认证通过可以访问的地址
//        filterChainDefinitionMap.put("/user/**", "theMember");
        filterChainDefinitionMap.put("/admin/**", "user");  //user表示验证身份通过,保存了rememberMe时也可以通过
        filterChainDefinitionMap.put("/swagger-ui.html", "authc"); //authc表示验证身份才能通过
        filterChainDefinitionMap.put("/druid/login.html", "authc"); //authc表示验证身份才能通过
        filterChainDefinitionMap.put("/druid/index.html", "authc"); //authc表示验证身份才能通过

//        shiroFilterFactoryBean.setFilters(customisedFilter);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

//
//
//    }

//    @Bean
//    public AdminFilter theAdmin(){
//        return new AdminFilter();
//    }
//
//    @Bean
//    public MemberFilter theMember(){
//        return new MemberFilter();
//    }

//    public
//
//    public URLPathMatchingFilter getURLPathMatchingFilter() {
//        return new URLPathMatchingFilter();
//    }


    /*安全管理器*/
    @Bean(name = "securityManager")
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置自定义realm.
        securityManager.setRealm(getDatabaseRealm());
        //配置记住我
        securityManager.setRememberMeManager(rememberMeManager());
//        SecurityUtils.setSecurityManager(securityManager);
        return securityManager;
    }

//    @Bean
//    public FormAuthenticationFilter formAuthenticationFilter(){
//        return new MyFormAuthenticationFilter();
//    }



//    @Bean
//    public AdminRealm getAdminRealm(){
//        AdminRealm adminRealm = new AdminRealm();
//        adminRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        return adminRealm;
//    }

//    @Bean
//    public MyRealm getMyRealm(){
//        MyRealm myRealm = new MyRealm();
//        myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        return myRealm;
//    }

//    @Bean
//    public MemberRealm getMemberRealm(){
//        MemberRealm memberRealm = new MemberRealm();
//        memberRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        return memberRealm;
//    }

    @Bean
    public DatabaseRealm getDatabaseRealm() {
        DatabaseRealm myShiroRealm = new DatabaseRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

//    @Bean
//    public MemberDatabaseRealm getMemberDatabaseRealm() {
//        MemberDatabaseRealm memberShiroRealm = new MemberDatabaseRealm();
//        memberShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        return memberShiroRealm;
//    }

    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * 所以我们需要修改下doGetAuthenticationInfo中的代码;
     * ）
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();

        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));

        return hashedCredentialsMatcher;
    }

    /**
     * cookie对象,会话Cookie模板,默认为:JSESSIONID
     *
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setPath("/");
        simpleCookie.setMaxAge(60 * 60 * 24 * 30);//一个月cookie保留时间
        return simpleCookie;
    }

    /**
     * cookie管理对象,记住我功能,rememberMe管理器
     *
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    /**
     * FormAuthenticationFilter过滤器 过滤记住我
     *
     * @return
     */
//    @Bean
//    public FormAuthenticationFilter formAuthenticationFilter() {
//        FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
//        formAuthenticationFilter.setRememberMeParam("rememberMe");
//        return formAuthenticationFilter;
//    }

    /**
     *  开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}