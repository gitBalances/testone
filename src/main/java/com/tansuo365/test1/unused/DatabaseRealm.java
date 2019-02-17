package com.tansuo365.test1.unused;//package com.tansuo365.test1.shiro.realm;
//
//import com.tansuo365.test1.bean.User;
//import com.tansuo365.test1.service.PermissionService;
//import com.tansuo365.test1.service.RoleService;
//import com.tansuo365.test1.service.UserService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Set;
//
//
///*从数据库获取信息判定权限Realm*/
//public class DatabaseRealm extends AuthorizingRealm {
//
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private RoleService roleService;
//	@Autowired
//	private PermissionService permissionService;
//
//	/*获取授权权限信息*/
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
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
//	}
//
////	String userName = null;
//
//	/*获取身份验证信息*/
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//		//1.把AuthenticationToken转换为CustomizedToken
//		MyAuthenticationToken customizedToken = (MyAuthenticationToken)token;
//		//2.从CustomizedToken中获取userName
//		String userName = customizedToken.getUsername();
//		//3.若用户不存在,抛出UnknownAccountException异常
//		User user = userService.getByName(userName);
//		if(null == user){
//			throw new UnknownAccountException("用户不存在!");
//		}
//		//4.根据用户的情况,来构建AuthenticationInfo对象并返回
//		//通常使用的实现类为SimpleAuthenticationInfo
//		Object principal = userName;
//		Object credentials = user.getPassword();
//		String realmName = getName();
//		String salt = user.getSalt();
//		ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
//
//		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);
//		return info;
//
////*******下面为how2j的写法********//
////
////		try {
////			// 获取账号密码
////			userName = token.getPrincipal().toString();
//			// 获取数据库中的密码
////			User user = userService.getByName(userName);
////			String passwordInDB = user.getPassword();
////			String salt = user.getSalt();
//			// 认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
//			// 盐也放进去
////			// 这样通过applicationContext-shiro.xml里配置的 HashedCredentialsMatcher 进行自动校验
////			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, passwordInDB, ByteSource.Util.bytes(salt),
////					getName());
////			return info;
////		} catch (Exception e) {
////			System.err.println("exception:userName->"+userName);
////		} finally {
////		}
////		return null;
//	}
//
//}