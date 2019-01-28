package com.tansuo365.test1.filter;

import com.tansuo365.test1.service.MemberPermissionService;
import com.tansuo365.test1.util.SpringContextUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Set;

public class MemberURLPathMatchingFilter extends PathMatchingFilter {
    @Autowired
    private MemberPermissionService memberPermissionService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if (null == memberPermissionService) {
            memberPermissionService = SpringContextUtils.getContext().getBean(MemberPermissionService.class);
        }
        String requestURI = getPathWithinApplication(request);
        System.out.println("member-requestURI:" + requestURI);

        Subject subject = SecurityUtils.getSubject();
        //如果没有登录,就跳转到首页页面
        if (!subject.isAuthenticated()) {
            WebUtils.issueRedirect(request, response, "/");
            return false;
        }

        //看看这个路径权限里有没有维护,如果没有维护,一律放行
        boolean needInterceptor = memberPermissionService.needInterceptor(requestURI);
        if (!needInterceptor) {
            return true;
        } else {
            boolean hasMemberPermission = false;
            String memberName = subject.getPrincipal().toString();
            Set<String> memberPermissionUrls = memberPermissionService.listMemberPermissionURLs(memberName);
            for (String url : memberPermissionUrls) {
                //这就表示当前用户有这个权限
                if (url.equals(requestURI)) {
                    hasMemberPermission = true;
                    break;
                }
            }

            if (hasMemberPermission) {
                return true;
            } else {
                UnauthorizedException ex = new UnauthorizedException("当前用户没有访问路径 " + requestURI + " 的权限");
                subject.getSession().setAttribute("ex", ex);
                WebUtils.issueRedirect(request, response, "/user/unauthorized");
                return false;
            }
        }

    }
}
