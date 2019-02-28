package com.tansuo365.test1.service.user.impl;

import java.util.List;

import com.tansuo365.test1.bean.user.Role;
import com.tansuo365.test1.bean.user.RolePermission;
import com.tansuo365.test1.bean.user.RolePermissionExample;
import com.tansuo365.test1.mapper.RolePermissionMapper;
import com.tansuo365.test1.service.user.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*角色权限服务实现层*/
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

	@Resource
	private RolePermissionMapper rolePermissionMapper;

	@Override
	public void setPermissions(Role role, long[] permissionIds) {
		// 删除当前角色所有的权限
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andRidEqualTo(role.getId());
		List<RolePermission> rps = rolePermissionMapper.selectByExample(example);
		for (RolePermission rolePermission : rps) {
            rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
        }

		// 设置新的权限关系
		if (null != permissionIds) {
            for (long pid : permissionIds) {
                RolePermission rolePermission = new RolePermission();
                rolePermission.setPid(pid);
                rolePermission.setRid(role.getId());
                rolePermissionMapper.insert(rolePermission);
            }
        }
	}

	@Override
	public void deleteByRole(long roleId) {
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andRidEqualTo(roleId);
		List<RolePermission> rps = rolePermissionMapper.selectByExample(example);
		for (RolePermission rolePermission : rps) {
            rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
        }
	}

	@Override
	public void deleteByPermission(long permissionId) {
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andPidEqualTo(permissionId);
		List<RolePermission> rps = rolePermissionMapper.selectByExample(example);
		for (RolePermission rolePermission : rps) {
            rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
        }
	}

}