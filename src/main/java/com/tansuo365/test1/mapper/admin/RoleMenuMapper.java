package com.tansuo365.test1.mapper.admin;

import com.tansuo365.test1.bean.user.RoleMenu;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuMapper {

    int deleteByPrimaryKey(Integer id);

    //通过roleId删除数据
    int deleteByRoleId(Integer roleId);

    //动态插入roleMenu
    int insertSelective(RoleMenu roleMenu);

    RoleMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleMenu record);

}