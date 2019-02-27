package com.tansuo365.test1.mapper.admin;

import com.tansuo365.test1.bean.user.User;
import com.tansuo365.test1.bean.user.UserExample;

import java.util.List;

/*用户Mapper层*/

public interface UserMapper {
	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	Long getCount();
}