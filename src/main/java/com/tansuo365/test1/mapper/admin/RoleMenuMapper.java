package com.tansuo365.test1.mapper.admin;

import com.tansuo365.test1.bean.user.RoleMenu;
import com.tansuo365.test1.bean.user.RoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuMapper {

    long countByExample(RoleMenuExample example);

    int deleteByExample(RoleMenuExample example);

    int deleteByPrimaryKey(Integer id);

    //通过roleId删除数据
    int deleteByRoleId(Integer roleId);

    int insert(RoleMenu roleMenu);

    //动态插入roleMenu
    int insertSelective(RoleMenu roleMenu);

    List<RoleMenu> selectByExample(RoleMenuExample example);

    RoleMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);

}