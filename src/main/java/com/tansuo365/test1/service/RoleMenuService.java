package com.tansuo365.test1.service;

import com.tansuo365.test1.bean.RoleMenu;

public interface RoleMenuService {

    /**
     * 根据角色id删除所有关联信息
     * @param roleId
     */
    public Integer deleteByRoleId(Integer roleId);

    /**
     * 保存RoleMenu
     * @param roleMenu
     */
    public Integer saveRoleMenu(RoleMenu roleMenu);
}
