package com.tansuo365.test1.service.user;

import com.tansuo365.test1.bean.user.Permission;
import com.tansuo365.test1.bean.user.Role;

import java.util.List;
import java.util.Set;

/*权限服务接口*/
public interface PermissionService {

    public Set<String> listPermissions(String userName);

    public List<Permission> list();

    public void add(Permission permission);

    public void delete(Long id);

    public Permission get(Long id);

    public void update(Permission permission);

    public List<Permission> list(Role role);

    public boolean needInterceptor(String requestURI);

    public Set<String> listPermissionURLs(String userName);
}
