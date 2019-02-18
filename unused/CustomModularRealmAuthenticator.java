package com.tansuo365.test1.unused;//package com.tansuo365.test1.shiro.realm;
//
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
//import org.apache.shiro.authc.pam.UnsupportedTokenException;
//import org.apache.shiro.realm.Realm;
//import org.apache.shiro.util.CollectionUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.Map;
//
///*自定义的Realm验证器*/
//public class CustomModularRealmAuthenticator extends ModularRealmAuthenticator {
//    //将Realm的实现类作为Map传入,这样就可以分清除前后台登录
//    private static final Logger log = LoggerFactory
//            .getLogger(CustomModularRealmAuthenticator.class);
//
//    private Map<String, Object> customRealms;
//
//    public Map<String, Object> getCustomRealms() {
//        return customRealms;
//    }
//
//    public void setCustomRealms(Map<String, Object> customRealms) {
//        this.customRealms = customRealms;
//    }
//
//    //调用单个Realm来进行验证
//    protected AuthenticationInfo doSingleRalmAuthentication(Realm realm, AuthenticationToken token) {
//        if (!realm.supports(token)) {
//            String msg = "Realm ["
//                    + realm
//                    + "] 不支持身份验证token-> ["
//                    + token
//                    + "]. 请确保恰当的Realm实现正确配置或Realm接受这种类型的AuthenticationTokens";
//            throw new UnsupportedTokenException(msg);
//        }
//        AuthenticationInfo info = null;
//        info = realm.getAuthenticationInfo(token);
//        try {
//            if (null == info) {
//                String msg = "Realm [" + realm
//                        + "] 没有找到提交的AuthenticationToken[" + token + "].所拥有的账户信息";
//                throw new UnknownAccountException(msg);
//            }
//        } catch (IncorrectCredentialsException e) {
//            throw e;
//        } catch (UnknownAccountException e) {
//            throw e;
//        } catch (Throwable throwable) {
//            if (log.isDebugEnabled()) {
//                String msg = "Realm ["
//                        + realm
//                        + "] 抛出了一个异常在多重Realm身份验证时:";
//                log.debug(msg, throwable);
//            }
//
//
//        }
//        return info;
//
//    }
//
//    //判断Realm是不是null
//    protected void assertRealmsConfigured() throws IllegalStateException{
//        customRealms = getCustomRealms();
//        if (CollectionUtils.isEmpty(customRealms)) {
//            String msg = "customRealms是空的.";
//            throw new IllegalStateException(msg);
//        }
//    }
//
//    //下面方法很重要,用来判断此次调用是前台还是后台
//    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken){
//        assertRealmsConfigured();
//        CaptchaAuthenticationToken token = (CaptchaAuthenticationToken)authenticationToken;
//        Realm realm = null;
//        //前端登录
//        if(StringUtils.equals(token.getLoginType(),LoginEnum.CUSTOMER.toString())){
//            realm = (Realm)customRealms.get("memberDatabaseRealm");
//        }
//        //后台登录
//        if(StringUtils.equals(token.getLoginType(),LoginEnum.ADMIN.toString())){
//            realm = (Realm)customRealms.get("databaseRealm");
//        }
//        if(null == realm){
//            return null;
//        }
//        return doSingleRalmAuthentication(realm,authenticationToken);
//    }
//
//}
