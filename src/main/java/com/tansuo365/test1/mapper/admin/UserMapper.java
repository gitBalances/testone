package com.tansuo365.test1.mapper.admin;

import com.tansuo365.test1.bean.user.User;

import java.util.List;

/*用户Mapper层*/

public interface UserMapper {

	int deleteByPrimaryKey(Integer id);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	Long getCount();

	String getPasswordByUserName(String name);

	User getUserByName(String name);

	List<User> getUserList(User user);

}