package com.tansuo365.test1.entity;

import io.swagger.annotations.ApiModel;

@ApiModel(value="登录实体的父接口",description="登录实体的父接口")
public interface MyLoginInstance {

    Integer getInstanceId();

    String getInstanceName();

    String getInstancePassword();

    String getInstanceSalt();

    void setInstanceName(String username);

    void setInstancePassword(String password);

    void setInstanceSalt(String salt);
}
