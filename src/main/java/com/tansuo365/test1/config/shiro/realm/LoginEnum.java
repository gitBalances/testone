package com.tansuo365.test1.config.shiro.realm;

public enum LoginEnum {

    MEMBER("Member"),ADMIN("Admin");
    private String type;

    private LoginEnum(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
