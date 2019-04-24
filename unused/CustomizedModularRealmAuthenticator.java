package com.tansuo365.test1.unused;//package com.tansuo365.test1.config.shiro.realm;
//
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
//import org.apache.shiro.realm.Realm;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Component
//public class CustomizedModularRealmAuthenticator extends ModularRealmAuthenticator {
//
//    @Override
//    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken){
//        //判断getRealms()是否返回为空
//        assertRealmsConfigured();
//        //强制转换回自定义的CustomizedToken
//        MyAuthenticationToken customizedToken = (MyAuthenticationToken) authenticationToken;
//        //登录类型
//        String loginType = customizedToken.getLoginType();
//        //所有Realm
//        Collection<Realm> realms = getRealms();
//        //登录类型对应的所有Realm
//        Collection<Realm> typeRealms = new ArrayList<>();
//        for(Realm realm : realms)
//        {
//            if(realm.getName().contains(loginType)){
//                typeRealms.add(realm);
//            }
//        }
//
//        /*判断是单Realm还是多Realm*/
//        if(typeRealms.size()==1){
//            return doSingleRealmAuthentication(typeRealms.iterator().next(),customizedToken);
//        }else{
//            return doMultiRealmAuthentication(typeRealms,customizedToken);
//        }
//    }
//}
