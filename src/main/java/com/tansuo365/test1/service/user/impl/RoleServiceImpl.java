package com.tansuo365.test1.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import com.tansuo365.test1.bean.user.*;
import com.tansuo365.test1.mapper.admin.RoleMapper;
import com.tansuo365.test1.mapper.admin.UserRoleMapper;
import com.tansuo365.test1.service.user.RoleService;
import com.tansuo365.test1.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*角色服务实现层*/
@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;
	@Resource
	private UserRoleMapper userRoleMapper;
	@Autowired
	private UserService userService;

//	@Override
//	public Set<String> listRoleNames(String userName) {
//		Set<String> result = new HashSet<>();
//		List<Role> roles = listRoles(userName);
//		for (Role role : roles) {
//			result.add(role.getName());
//		}
//		return result;
//	}

//	@Override
//	public List<Role> listRoles(String userName) {
//		List<Role> roles = new ArrayList<>();
//		User user = userService.getByName(userName);
//		if (null == user)
//			return roles;
//
//		roles = listRoles(user);
//		return roles;
//	}

	@Override
	public void add(Role u) {
		roleMapper.insertSelective(u);
	}

	@Override
	public Integer addSelective(Role role) {
		return roleMapper.insertSelective(role);
	}

	@Override
	public Integer delete(Integer id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer deleteByUserId(Integer id) {
		return roleMapper.deleteByUserId(id);
	}

	@Override
	public Integer update(Role u) {
		return roleMapper.updateByPrimaryKeySelective(u);
	}

	@Override
	public Role getByName(String name) {
		return roleMapper.selectByName(name);
	}

	@Override
	public Role get(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Role> listSelective(Role role) {
		return roleMapper.selectRoleSelective(role);
	}

	@Override
	public List<Role> listRolesByUserId(Integer id) {
		return roleMapper.selectByUserId3Table(id);
	}

	@Override
	public List<Role> listRoles(User user) {
		return roleMapper.selectByUserId3Table(user.getId());
	}

	@Override
	public List<Role> list() {
		return roleMapper.selectRoleList();
	}


}