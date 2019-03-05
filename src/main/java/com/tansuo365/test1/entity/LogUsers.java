package com.tansuo365.test1.entity;

import io.swagger.annotations.ApiModel;

@ApiModel(value="日志公用实体的父接口",description="日志公用实体的父接口")
public interface LogUsers {

    void setTypeContent(String type,String content);

    void setUsersId(Integer id); //设置用户操作id
}
