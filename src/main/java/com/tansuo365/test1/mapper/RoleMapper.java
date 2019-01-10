package com.tansuo365.test1.mapper;

import com.tansuo365.test1.bean.Role;
import com.tansuo365.test1.bean.RoleExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*角色Mapper层*/
@Mapper
public interface RoleMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Role record);

	int insertSelective(Role record);

	List<Role> selectByExample(RoleExample example);

	Role selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);
}