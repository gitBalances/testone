package com.tansuo365.test1.mapper;

import com.tansuo365.test1.bean.user.RolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*角色权限Mapper层*/
@Mapper
public interface RolePermissionMapper {

	int deleteByPrimaryKey(Long id);

	int insertSelective(RolePermission record);

	RolePermission selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(RolePermission record);

}