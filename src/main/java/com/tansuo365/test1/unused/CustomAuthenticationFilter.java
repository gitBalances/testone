//package com.tansuo365.test1.unused;
//
//import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import java.util.HashMap;
//import java.util.Map;
//
///*自定义身份验证过滤器*/
//public class CustomAuthenticationFilter extends FormAuthenticationFilter {
//    /*存放登录路径根据设置*/
//    private Map<String,String> loginUrlByLoginType = new HashMap<String,String>();
//
//    /*设置登录的路径*/
//    public void setLoginUrls(final Map<String,String> loginUrlByLoginType){
//        this.loginUrlByLoginType = loginUrlByLoginType;
//    }
//
//    /*根据不同的url跳转到不同的登录页面*/
//    protected void redirectToLogin(final ServletRequest request, final ServletResponse response){
//        final String loginUrl = getLoginUrl(request);
//    }
//
//    /*根据用户的不同标识进行不同url的配置*/
//    private String getLoginUrl(final ServletRequest request){
//        //check user loginType
//        final String loginType = getLoginType(request);
//        //and return appropriate login url
//        return loginType != null && loginUrlByLoginType.containsKey(loginType) ?
//                loginUrlByLoginType.get(loginType) : getLoginUrl();
//    }
//
//    /*页面传入用户表示,是前端用户member(实体)还是后端用户user(实体)*/
//    private String getLoginType(final ServletRequest request){
//        //get user loginType
//        String loginType = (String)request.getAttribute("loginType");
//        return loginType;
//    }
//
//
//}
