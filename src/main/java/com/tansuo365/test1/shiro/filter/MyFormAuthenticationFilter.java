package com.tansuo365.test1.shiro.filter;

import com.tansuo365.test1.shiro.realm.MyAuthenticationToken;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 如果后端可以设定其它的用户种类,那么种类名称应该存入数据库中,而不是写死在枚举类里.
 * 那么就可以结合这个扩展类来进行种类的查询及比较.
 * 比如在STEP 1位置判定loginType是否与数据库设定的相关.
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {


//    public String loginType;
//
//    public String getLoginType() {
//        return loginType;
//    }
//
//    public void setLoginType(String loginType) {
//        this.loginType = loginType;
//    }

    protected MyAuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);

//        String rememberMeParam = getRememberMeParam();
        String loginType = request.getParameter("loginType");
//        System.err.println("loginType:"+loginType);
//        setLoginType(loginType);
        //STEP 1:
//        System.err.println("loginType in MyForm:" + loginType);
        System.err.println("getRememberMeBool(request):" + getRememberMeBool(request));

        return new MyAuthenticationToken(username, password, getRememberMeBool(request) == null ? false : true, loginType);
    }


    protected String getRememberMeBool(ServletRequest request) {
        return WebUtils.getCleanParam(request, DEFAULT_REMEMBER_ME_PARAM);
    }

//    @Override
//    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
//        String loginUrl = getLoginUrl();
//        System.out.println("MyForm loginUrl:"+loginUrl);
//        String requestURI = getPathWithinApplication(request);
//        if(requestURI.contains("admin")){
//            loginUrl = "/admin/login";
//            WebUtils.issueRedirect(request,response,loginUrl);
//        }
//        if (requestURI.contains("user")){
//            loginUrl =  "/user/login";
//            WebUtils.issueRedirect(request,response,loginUrl);
//        }
//    }


    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        MyAuthenticationToken myToken = (MyAuthenticationToken)token;
        String loginType = myToken.getLoginType();

        if(loginType.equals("Admin")){
            System.out.println(">>>>>>>>redirect to path /admin");
            WebUtils.issueRedirect(request,response,"/admin");
        }
        if(loginType.equals("Member")){
            System.out.println(">>>>>>>>redirect to path /");
            WebUtils.issueRedirect(request,response,"/");
        }
        return false;
//        return super.onLoginSuccess(token, subject, request, response);
    }
}
