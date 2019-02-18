package com.tansuo365.test1.shiro.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tansuo365.test1.bean.EMenu;
import com.tansuo365.test1.bean.Role;
import com.tansuo365.test1.bean.User;
import com.tansuo365.test1.service.EMenuService;
import com.tansuo365.test1.service.PermissionService;
import com.tansuo365.test1.service.RoleService;
import com.tansuo365.test1.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.CodecException;
import org.apache.shiro.crypto.UnknownAlgorithmException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class DatabaseRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private EMenuService eMenuService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//		// 能进入到这里，表示账号已经通过验证了
//		String userName = (String) principalCollection.getPrimaryPrincipal();
//		// 通过service获取角色和权限
//		Set<String> permissions = permissionService.listPermissions(userName);
//		Set<String> roles = roleService.listRoleNames(userName);
//
//		// 授权对象
//		SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
//		// 把通过service获取到的角色和权限放进去
//		s.setStringPermissions(permissions);
//		s.setRoles(roles);
//		return s;
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> roles = null;

		// 能进入到这里，表示账号已经通过验证了
		String username = (String) principalCollection.getPrimaryPrincipal();
		/*通过用户名获取用户role实例*/
		List<Role> roleList = roleService.listRoles(username);
//		if (roleList.size() > 0) {
			roles = new HashSet<>();
//		}
		for (Role role : roleList) {
			roles.add(role.getName());//加入role角色名到Set集合roles
			List<EMenu> eMenuList = eMenuService.findMenuListByRoleId(role.getId());
			for (EMenu eMenu : eMenuList) {
				info.addStringPermission(eMenu.getName());//添加权限
			}
		}
		info.setRoles(roles);
		System.out.println("info:"+info.toString());
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取账号密码
		UsernamePasswordToken t = (UsernamePasswordToken) token;
		String userName = token.getPrincipal().toString();
		// 获取数据库中的密码
		User user = userService.getByName(userName);
		String passwordInDB = user.getPassword();
		String salt = user.getSalt();
		// 认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
		// 盐也放进去
		// 这样通过applicationContext-shiro.xml里配置的 HashedCredentialsMatcher 进行自动校验
		SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(userName, passwordInDB, ByteSource.Util.bytes(salt),
				getName());
		return a;
	}

}