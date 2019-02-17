//package com.tansuo365.test1.unused;
//
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//
//import javax.servlet.Filter;
//import java.util.Map;
//
//public class CustomShiroFilterFactoryBean extends ShiroFilterFactoryBean {
//
//    private SecurityManager securityManager;
//
//    private Map<String, Filter> filters;
//
//    private Map<String, String> filterChainDefinitionMap; //urlPathExpression_to_comma-delimited-filter-chain-definition
//
//    private String loginUrl;
//    private String successUrl;
//    private String unauthorizedUrl;
//
//    @Override
//    public SecurityManager getSecurityManager() {
//        return securityManager;
//    }
//
//    @Override
//    public void setSecurityManager(SecurityManager securityManager) {
//        this.securityManager = securityManager;
//    }
//
//    @Override
//    public Map<String, Filter> getFilters() {
//        return filters;
//    }
//
//    @Override
//    public void setFilters(Map<String, Filter> filters) {
//        this.filters = filters;
//    }
//
//    @Override
//    public Map<String, String> getFilterChainDefinitionMap() {
//        return filterChainDefinitionMap;
//    }
//
//    @Override
//    public void setFilterChainDefinitionMap(Map<String, String> filterChainDefinitionMap) {
//        this.filterChainDefinitionMap = filterChainDefinitionMap;
//    }
//
//    @Override
//    public String getLoginUrl() {
//        return loginUrl;
//    }
//
//    @Override
//    public void setLoginUrl(String loginUrl) {
//        this.loginUrl = loginUrl;
//    }
//
//    @Override
//    public String getSuccessUrl() {
//        return successUrl;
//    }
//
//    @Override
//    public void setSuccessUrl(String successUrl) {
//        this.successUrl = successUrl;
//    }
//
//    @Override
//    public String getUnauthorizedUrl() {
//        return unauthorizedUrl;
//    }
//
//    @Override
//    public void setUnauthorizedUrl(String unauthorizedUrl) {
//        this.unauthorizedUrl = unauthorizedUrl;
//    }
//}
