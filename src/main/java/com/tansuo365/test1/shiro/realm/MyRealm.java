package com.tansuo365.test1.shiro.realm;


import com.tansuo365.test1.bean.user.EMenu;
import com.tansuo365.test1.bean.user.Role;
import com.tansuo365.test1.bean.user.User;
import com.tansuo365.test1.entity.MyLoginInstance;
import com.tansuo365.test1.service.user.EMenuService;
import com.tansuo365.test1.service.user.PermissionService;
import com.tansuo365.test1.service.user.RoleService;
import com.tansuo365.test1.service.user.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;

import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MyRealm extends AuthorizingRealm {

    //    @Autowired
//    private MemberService memberService;//member
    @Resource
    private UserService userService;//user

    //    @Autowired
//    private MroleService mroleService;//member
    @Resource
    private PermissionService permissionService;
    @Resource
    private RoleService roleService; //user
    @Resource
    private EMenuService eMenuService;

    //    @Autowired
//    private MemberPermissionService memberPermissionService;//member
    @Autowired
//    private PermissionService permissionService;//user


    /*获取授权权限信息*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = null;

        // 能进入到这里，表示账号已经通过验证了
        String username = (String) principals.getPrimaryPrincipal();
        /*通过用户名获取用户role实例*/
        List<Role> roleList = roleService.listRoles(username);
        if (roleList.size() > 0) {
            roles = new HashSet<>();
        }
        for (Role role : roleList) {
            roles.add(role.getName());//加入role角色名到Set集合roles
            List<EMenu> eMenuList = eMenuService.findMenuListByRoleId(role.getId());
            for (EMenu eMenu : eMenuList) {
                info.addStringPermission(eMenu.getName());//添加权限
            }
        }
        info.setRoles(roles);
        return info;


        /*==========================================*/
        //能进入到这里，表示账号已经通过验证了
//        String userName =(String) principals.getPrimaryPrincipal();
//        //通过DAO获取角色和权限
//        Set<String> permissions = permissionService.listPermissions(userName);
//        Set<String> roles = roleService.listRoleNames(userName);
//
//        //授权对象
//        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
//        //把通过DAO获取到的角色和权限放进去
//        s.setStringPermissions(permissions);
//        s.setRoles(roles);
//        return s;
    }

    /*获取身份验证信息*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        User user = null;//后台用户
//        Member member = null;//前端会员
        MyLoginInstance instance = null;//封装了几种用户的通用方法

        //1.把AuthenticationToken转换为CustomizedToken
        MyAuthenticationToken myAuthenticationToken = (MyAuthenticationToken) token;
        //2.从CustomizedToken中获取memberName
        String nameInInput = myAuthenticationToken.getUsername();
        System.err.println("nameInInput:" + nameInInput);
        //3.若用户不存在,抛出UnknownAccountException异常
        String loginType = myAuthenticationToken.getLoginType();

        System.out.println("myAuthenticationToken.getLoginType():" + myAuthenticationToken.getLoginType());
//        if(LoginEnum.ADMIN.toString().equals(loginType)){
        user = userService.getByName(nameInInput);
        if (null == user) {
            throw new UnknownAccountException("管理员不存在!");
        }
        instance = user;
//        }
//        if(LoginEnum.MEMBER.toString().equals(loginType)){
//            member = memberService.getByName(nameInInput);
//            if(null == member){
//                throw new UnknownAccountException("会员不存在!");
//            }
//            instance = member;
//        }

        //4.根据用户的情况,来构建AuthenticationInfo对象并返回
        //通常使用的实现类为SimpleAuthenticationInfo
        Object principal = instance.getInstanceName();
        System.out.println("principal in Realm : " + (String) principal);
        Object credentials = instance.getInstancePassword();
        String salt = instance.getInstanceSalt();
        System.out.println("salt:" + salt);
        String realmName = getName();
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
        return info;

    }
}
