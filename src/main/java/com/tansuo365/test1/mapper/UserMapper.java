package com.tansuo365.test1.mapper;

import com.tansuo365.test1.bean.User;
import com.tansuo365.test1.bean.UserExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*用户Mapper层*/
@Mapper
public interface UserMapper {
	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}