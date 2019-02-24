package com.tansuo365.test1.service.user;

import com.tansuo365.test1.bean.user.Role;
import com.tansuo365.test1.bean.user.User;

import java.util.List;
import java.util.Set;

/*角色服务接口*/
public interface RoleService {

	public List<Role> listRolesByUserId(int id);

//	public Set<String> listRoleNames(String userName);

//	public List<Role> listRoles(String userName);

	public List<Role> listRoles(User user);

	public List<Role> list();

	public List<Role> listSelective(Role role);

	public void add(Role role);

	public Integer addSelective(Role role);

	public Integer delete(Long id);

	//根据用户id删除所有用户角色关联实体
	public Integer deleteByUserId(Long id);

	public Role get(Long id);

	public Integer update(Role role);

	public Role getByName(String name);

}