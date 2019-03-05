package com.tansuo365.test1.bean.log;

import io.swagger.annotations.ApiModel;

@ApiModel(value="日志枚举类型",description="日志枚举类型")
public enum LogEnum {

    LOGIN_ACTION("登录操作"),
    LOGOUT_ACTION("注销操作"),
    SEARCH_ACTION("查询操作"),
    UPDATE_ACTION("更新操作"),
    ADD_ACTION("添加操作"),
    DELETE_ACTION("删除操作");

    private String type;

    private LogEnum(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
