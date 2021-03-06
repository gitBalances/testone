//package com.tansuo365.test1.controller.user;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.tansuo365.test1.bean.user.Role;
//import com.tansuo365.test1.bean.user.User;
//import com.tansuo365.test1.service.user.RoleService;
//import com.tansuo365.test1.service.user.UserRoleService;
//import com.tansuo365.test1.service.user.UserService;
//import com.tansuo365.test1.util.PasswordEncrypt;
//import org.apache.shiro.crypto.SecureRandomNumberGenerator;
//import org.apache.shiro.crypto.hash.SimpleHash;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.annotation.Resource;
//
///*后台用户配置Controller,前台用户路径虽然是/user/...但是实际上实体和数据库是member*/
//@Controller
//@RequestMapping("config")
//public class UserController {
//	@Resource
//	private UserRoleService userRoleService;
//	@Resource
//	private UserService userService;
//	@Resource
//	private RoleService roleService;
//
//	@RequestMapping("listUser")
//	public String list(Model model) {
//		List<User> us = userService.list();
//		model.addAttribute("us", us);
//		Map<User, List<Role>> user_roles = new HashMap<>();
//		for (User user : us) {
//			List<Role> roles = roleService.listRoles(user);
//			user_roles.put(user, roles);
//		}
//		model.addAttribute("user_roles", user_roles);
//
//		return "listUser";
//	}
//
//	@RequestMapping("editUser")
//	public String edit(Model model, long id) {
//		List<Role> rs = roleService.list();
//		model.addAttribute("rs", rs);
//		User user = userService.get(id);
//		model.addAttribute("user", user);
//
//		List<Role> roles = roleService.listRoles(user);
//		model.addAttribute("currentRoles", roles);
//
//		return "editUser";
//	}
//
//	@RequestMapping("deleteUser")
//	public String delete(Model model, long id) {
//		userService.delete(id);
//		return "redirect:listUser";
//	}
//
//	@RequestMapping("updateUser")
//	public String update(User user, long[] roleIds) {
//		userRoleService.setRoles(user, roleIds);
//
//		String password = user.getPassword();
//		// 如果在修改的时候没有设置密码，就表示不改动密码
////		if (user.getPassword().length() != 0) {
////			String salt = new SecureRandomNumberGenerator().nextBytes().toString();
////			int times = 2;
////			String algorithmName = "md5";
////			String encodedPassword = new SimpleHash(algorithmName, password, salt, times).toString();
////			user.setSalt(salt);
////			user.setPassword(encodedPassword);
////		} else
////			user.setPassword(null);
//		PasswordEncrypt.encryptPWD(user);
//
//		userService.update(user);
//
//		return "redirect:listUser";
//
//	}
//
//	@RequestMapping("addUser")
//	public String add(Model model, String name, String password) {
//
//		String salt = new SecureRandomNumberGenerator().nextBytes().toString();
//		int times = 2;
//		String algorithmName = "md5";
//
//		String encodedPassword = new SimpleHash(algorithmName, password, salt, times).toString();
//
//		User u = new User();
//		u.setName(name);
//		u.setPassword(encodedPassword);
//		u.setSalt(salt);
//		userService.add(u);
//
//		return "redirect:listUser";
//	}
//
//}