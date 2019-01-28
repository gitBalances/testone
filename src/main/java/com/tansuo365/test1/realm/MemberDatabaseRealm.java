package com.tansuo365.test1.realm;

import com.tansuo365.test1.bean.Member;
import com.tansuo365.test1.service.MemberPermissionService;
import com.tansuo365.test1.service.MemberService;
import com.tansuo365.test1.service.MroleService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Set;

public class MemberDatabaseRealm extends AuthorizingRealm {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MroleService mroleService;
    @Autowired
    private MemberPermissionService memberPermissionService;

    /*获取授权权限信息*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //能进入到这里,标识会员已经通过了验证
        String userName = (String)principals.getPrimaryPrincipal();
        //通过service获取角色和权限
        Set<String> permissions = memberPermissionService.listMemberPermissions(userName);
        Set<String> mroles = mroleService.listMroleNames(userName);

        //授权对象
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        //把通过service获取到的角色和权限放进去
        s.setStringPermissions(permissions);
        s.setRoles(mroles);
        return s;
    }

    /*获取身份验证信息*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String memberName = null;

        try {
            memberName = token.getPrincipal().toString();

            Member member = memberService.getByName(memberName);
            String passwordInDB = member.getPassword();
            String salt = member.getSalt();
            // 认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
            //盐也放进去
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(memberName, passwordInDB, ByteSource.Util.bytes(salt),
                    getName());
            return info;
        } catch (Exception e) {
//            e.printStackTrace();
        } finally {
        }
        return null;
    }
}
