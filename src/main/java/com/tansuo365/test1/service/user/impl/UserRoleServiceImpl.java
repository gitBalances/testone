package com.tansuo365.test1.service.user.impl;

import java.util.List;

import com.tansuo365.test1.bean.user.User;
import com.tansuo365.test1.bean.user.UserRole;
import com.tansuo365.test1.bean.user.UserRoleExample;
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
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUidEqualTo(Long.parseLong(user.getId().toString()));
		List<UserRole> urs = userRoleMapper.selectByExample(example);
		for (UserRole userRole : urs)
			userRoleMapper.deleteByPrimaryKey(userRole.getId());

		// 设置新的角色关系
		if (null != roleIds)
			for (long rid : roleIds) {
				UserRole userRole = new UserRole();
				userRole.setRid(rid);
				userRole.setUid(Long.parseLong(user.getId().toString()));
				userRoleMapper.insert(userRole);
			}
	}

	@Override
	public Integer deleteByUser(long userId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUidEqualTo(userId);
		List<UserRole> urs = userRoleMapper.selectByExample(example);
		int count = 0;
		int deleteSum = 0;
		for (UserRole userRole : urs) {
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
	public Integer deleteByRole(long roleId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andRidEqualTo(roleId);
		List<UserRole> urs = userRoleMapper.selectByExample(example);
		int deleteCode = 0;
		int count = 0;
		for (UserRole userRole : urs) {
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

}