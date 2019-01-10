package com.tansuo365.test1.mapper;

import com.tansuo365.test1.bean.RolePermission;
import com.tansuo365.test1.bean.RolePermissionExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*角色权限Mapper层*/
@Mapper
public interface RolePermissionMapper {
	int deleteByPrimaryKey(Long id);

	int insert(RolePermission record);

	int insertSelective(RolePermission record);

	List<RolePermission> selectByExample(RolePermissionExample example);

	RolePermission selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(RolePermission record);

	int updateByPrimaryKey(RolePermission record);
}