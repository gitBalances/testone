package com.tansuo365.test1.service;

import com.tansuo365.test1.bean.Role;
import com.tansuo365.test1.bean.User;

import java.util.List;
import java.util.Set;

/*角色服务接口*/
public interface RoleService {
	public Set<String> listRoleNames(String userName);

	public List<Role> listRoles(String userName);

	public List<Role> listRoles(User user);

	public List<Role> list();

	public void add(Role role);

	public void delete(Long id);

	public Role get(Long id);

	public void update(Role role);

}