package com.tansuo365.test1.service.user;


import com.tansuo365.test1.bean.user.User;
import com.tansuo365.test1.bean.user.UserRole;

import java.util.List;

/*用户角色服务接口*/
public interface UserRoleService {

	public void setRoles(User user, long[] roleIds);

	public void setRolesById(Integer userId, Integer[] roleIds);

	public Integer deleteByUser(Integer userId);

	public Integer deleteByRole(Integer roleId);

	List<UserRole> getUserRoleByUser(User user);

}