package com.tansuo365.test1.service;

import com.tansuo365.test1.bean.User;

import java.util.List;

/*用户服务接口*/
public interface UserService {
	public String getPassword(String name);

	public User getByName(String name);

	public List<User> list();

	public void add(User user);

	public void delete(Long id);

	public User get(Long id);

	public void update(User user);
}