package com.tansuo365.test1.mapper;

import com.tansuo365.test1.bean.UserRole;
import com.tansuo365.test1.bean.UserRoleExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*用户角色Mapper层*/
@Mapper
public interface UserRoleMapper {
	int deleteByPrimaryKey(Long id);

	int insert(UserRole record);

	int insertSelective(UserRole record);

	List<UserRole> selectByExample(UserRoleExample example);

	UserRole selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(UserRole record);

	int updateByPrimaryKey(UserRole record);
}