package com.tansuo365.test1.bean.log;

public enum UserType {

    MEMBER("会员"),
    ADMIN("管理员"),
    SYSTEM_ADMIN("系统管理员");

    private String type;

    private UserType(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
