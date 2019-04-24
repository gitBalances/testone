package com.tansuo365.test1.service.user.impl;

import com.tansuo365.test1.bean.user.User;
import com.tansuo365.test1.mapper.admin.UserMapper;
import com.tansuo365.test1.service.user.UserRoleService;
import com.tansuo365.test1.service.user.UserService;
import com.tansuo365.test1.util.PasswordEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*用户服务实现层*/
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private PasswordEncrypt passwordEncrypt;

	@Override
	public String getPassword(String name) {
		return userMapper.getPasswordByUserName(name);
	}
	@Override
	public User getUserByName(String name) {
		return userMapper.getUserByName(name);
	}

	@Override
	public List<User> list(User user) {
		return userMapper.getUserList(user);
	}

	//添加用户
	@Override
	public Integer add(User u) {
		//加密
		passwordEncrypt.encryptPWD(u);
		return userMapper.insertSelective(u);

	}
	@Override
	public Integer delete(Integer id) {
		int deleteUserCode = userMapper.deleteByPrimaryKey(id);
		int deleteUserRoleCode = userRoleService.deleteByUser(id);
		/*如果两者为2,则证明都删除正确了,否则不是.*/
		if(deleteUserCode+deleteUserRoleCode==2){
			return 1;
		}else{
			return 0;
		}
	}

	//更新用户
	@Override
	public Integer update(User u) {
		passwordEncrypt.encryptPWD(u);
		return userMapper.updateByPrimaryKeySelective(u);
	}

	@Override
	public User get(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public Long getCount(User user) {
		return null;
	}


}