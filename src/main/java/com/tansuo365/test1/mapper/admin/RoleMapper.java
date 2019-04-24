package com.tansuo365.test1.mapper.admin;

import com.tansuo365.test1.bean.user.Role;
import com.tansuo365.test1.bean.user.User;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*角色Mapper层*/
@Mapper
public interface RoleMapper {

	int deleteByPrimaryKey(Integer id);
	/*根据用户id删除user_role数据对应关系元组 */
	int deleteByUserId(Integer id);

	List<Role> selectByUserId3Table(Integer id);

	//动态插入role
	int insertSelective(Role role);

	//动态获取Role表数据
	List<Role> selectRoleSelective(Role role);

	List<Role> selectRoleList();

	Role selectByPrimaryKey(Integer id);

	Role selectByName(String name);

	//动态更新role
	int updateByPrimaryKeySelective(Role record);

}