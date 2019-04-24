package com.tansuo365.test1.mapper.admin;

import com.tansuo365.test1.bean.user.Role;
import com.tansuo365.test1.bean.user.User;
import com.tansuo365.test1.bean.user.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*用户角色Mapper层*/
@Mapper
public interface UserRoleMapper {

	int deleteByPrimaryKey(Long id);

	int insertSelective(UserRole record);

	List<UserRole> selectByUserId(int uid);

	List<UserRole> selectByRoleId(int rid);

	UserRole selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(UserRole record);

}