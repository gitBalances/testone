package com.tansuo365.test1.service.user;

import com.tansuo365.test1.bean.user.User;

import java.util.List;

/*用户服务接口*/
public interface UserService {

	public String getPassword(String name);

	public User getUserByName(String name);

	public List<User> list(User user);

	public Long getCount(User user);

	public Integer add(User user);

	public Integer delete(Integer id);

	public User get(Integer id);

	public Integer update(User user);

}