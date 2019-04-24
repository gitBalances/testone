package com.tansuo365.test1.service.user.impl;

import java.util.List;

import com.tansuo365.test1.bean.user.User;
import com.tansuo365.test1.bean.user.UserRole;
import com.tansuo365.test1.mapper.admin.UserRoleMapper;
import com.tansuo365.test1.service.user.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*用户角色服务实现层*/
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Resource
	private UserRoleMapper userRoleMapper;

	@Override
	public void setRoles(User user, long[] roleIds) {
		// 删除当前用户所有的角色
		List<UserRole> userRoles = userRoleMapper.selectByUserId(user.getId());
		for (UserRole userRole : userRoles) {
            userRoleMapper.deleteByPrimaryKey(userRole.getId());
        }
		// 设置新的角色关系
		if (null != roleIds) {
            for (long rid : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setRid(rid);
                userRole.setUid(Long.parseLong(user.getId().toString()));
                userRoleMapper.insertSelective(userRole);
            }
        }
	}

	@Override
	public void setRolesById(Integer userId, Integer[] roleIds) {
		// 删除当前用户所有的角色
		List<UserRole> userRoles = userRoleMapper.selectByUserId(userId);
		for (UserRole userRole : userRoles) {
			userRoleMapper.deleteByPrimaryKey(userRole.getId());
		}
		// 设置新的角色关系
		if (null != roleIds) {
			for (long rid : roleIds) {
				UserRole userRole = new UserRole();
				userRole.setRid(rid);
				userRole.setUid(Integer.toUnsignedLong(userId));
				userRoleMapper.insertSelective(userRole);
			}
		}
	}

	@Override
	public Integer deleteByUser(Integer userId) {
		List<UserRole> userRoles = userRoleMapper.selectByUserId(userId);
		int count = 0;
		int deleteSum = 0;
		for (UserRole userRole : userRoles) {
			int i = userRoleMapper.deleteByPrimaryKey(userRole.getId());
			count++;
			deleteSum += i;
		}
		/*如果两者相等则证明删除正好干净了,否则不是*/
		if(count==deleteSum){
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public Integer deleteByRole(Integer roleId) {
		List<UserRole> userRoles = userRoleMapper.selectByRoleId(roleId);
		int deleteCode = 0;
		int count = 0;
		for (UserRole userRole : userRoles) {
			int i = userRoleMapper.deleteByPrimaryKey(userRole.getId());
			deleteCode += i;
			count ++;
		}
		if(deleteCode==count && deleteCode !=0){
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public List<UserRole> getUserRoleByUser(User user) {
		return userRoleMapper.selectByUserId(user.getId());
	}

}