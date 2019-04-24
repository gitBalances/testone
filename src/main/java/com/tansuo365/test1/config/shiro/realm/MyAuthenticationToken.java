package com.tansuo365.test1.config.shiro.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

public class MyAuthenticationToken extends UsernamePasswordToken {

    //登录类型,判断是普通用户Member还是管理员Admin
    private String loginType;

    public MyAuthenticationToken(final String username, final String password, boolean rememberMe, String loginType){
        super(username,password,rememberMe);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

}
