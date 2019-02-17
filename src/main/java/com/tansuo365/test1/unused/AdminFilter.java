//package com.tansuo365.test1.unused;
//
//import com.tansuo365.test1.service.PermissionService;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authz.UnauthorizedException;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.web.filter.authc.UserFilter;
//import org.apache.shiro.web.util.WebUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import java.util.Set;
//
//public class AdminFilter extends UserFilter {
//
//    @Autowired
//    private PermissionService permissionService;
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
//    /*被阻拦时,链接去哪里*/
//    @Override
//    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
//        WebUtils.issueRedirect(request, response, "/admin/login");
//        return false;
//    }
//
//    @Override
//    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
//        String requestURI = getPathWithinApplication(request);
//        System.out.println("adminFilter requestURI :"+requestURI);
//        Subject subject = null;
//        try {
//            subject = SecurityUtils.getSubject();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        // 如果没有登录，就跳转到登录页面
//        if (!subject.isAuthenticated()) {
//            WebUtils.issueRedirect(request, response, "/admin/login");
//            return false;
//        }
//        // 看看这个路径权限里有没有维护，如果没有维护，一律放行(也可以改为一律不放行)
//        boolean needInterceptor = permissionService.needInterceptor(requestURI);
//        System.out.println("Admin need:"+needInterceptor);
//        if (!needInterceptor) {
//            return true;
//        } else {
//            boolean hasPermission = false;
//            String userName = subject.getPrincipal().toString();
//            Set<String> permissionUrls = permissionService.listPermissionURLs(userName);
//            for (String url : permissionUrls) {
//                // 这就表示当前用户有这个权限
//                if (url.equals(requestURI)) {
//                    hasPermission = true;
//                    break;
//                }
//            }
//
//            if (hasPermission)
//                return true;
//            else {
//                UnauthorizedException ex = new UnauthorizedException("当前用户没有访问路径 " + requestURI + " 的权限");
//
//                subject.getSession().setAttribute("ex", ex);
//
//                WebUtils.issueRedirect(request, response, "/admin/unauthorized");
//                return false;
//            }
//
//        }
////        return super.onPreHandle(request, response, mappedValue);
//    }
//}
