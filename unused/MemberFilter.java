//package com.tansuo365.test1.unused;
//
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.web.filter.authc.UserFilter;
//import org.apache.shiro.web.util.WebUtils;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//public class MemberFilter extends UserFilter {
//
//    @Override
//    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//        if (isLoginRequest(request, response)) {
//            return true;
//        } else {
//            Subject subject = getSubject(request, response);
//            // If principal is not null, then the user is known and should be allowed access.
//            return subject.getPrincipal() != null;
//        }
//    }
//
//    @Override
//    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
////        WebUtils.issueRedirect(request,response,"/user/login");
//        return false;
//    }
//
//
//
//}
