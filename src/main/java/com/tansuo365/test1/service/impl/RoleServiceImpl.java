package com.tansuo365.test1.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tansuo365.test1.bean.*;
import com.tansuo365.test1.mapper.RoleMapper;
import com.tansuo365.test1.mapper.UserRoleMapper;
import com.tansuo365.test1.service.RoleService;
import com.tansuo365.test1.service.UserService;
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

	@Override
	public Set<String> listRoleNames(String userName) {
		Set<String> result = new HashSet<>();
		List<Role> roles = listRoles(userName);
		for (Role role : roles) {
			result.add(role.getName());
		}
		return result;
	}

	@Override
	public List<Role> listRoles(String userName) {
		List<Role> roles = new ArrayList<>();
		User user = userService.getByName(userName);
		if (null == user)
			return roles;

		roles = listRoles(user);
		return roles;
	}

	@Override
	public void add(Role u) {
		roleMapper.insert(u);
	}

	@Override
	public Integer addSelective(Role role) {
		return roleMapper.insertSelective(role);
	}

	@Override
	public Integer delete(Long id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer deleteByUserId(Long id) {
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
	public Role get(Long id) {
		return roleMapper.selectByPrimaryKey(id);
	}


	@Override
	public List<Role> list() {
		RoleExample example = new RoleExample();
		example.setOrderByClause("id desc");
		return roleMapper.selectByExample(example);

	}

	@Override
	public List<Role> listSelective(Role role) {
		return roleMapper.selectRoleSelective(role);
	}

	@Override
	public List<Role> listRoles(User user) {
		List<Role> roles = new ArrayList<>();

		UserRoleExample example = new UserRoleExample();

		example.createCriteria().andUidEqualTo(user.getId());
		List<UserRole> userRoles = userRoleMapper.selectByExample(example);

		for (UserRole userRole : userRoles) {
			Role role = roleMapper.selectByPrimaryKey(userRole.getRid());
			roles.add(role);
		}
		return roles;
	}


}