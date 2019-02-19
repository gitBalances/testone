package com.tansuo365.test1.service.user.impl;

import com.tansuo365.test1.bean.user.RoleMenu;
import com.tansuo365.test1.mapper.RoleMenuMapper;
import com.tansuo365.test1.service.user.RoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Override
    public Integer deleteByRoleId(Integer roleId) {
        return roleMenuMapper.deleteByRoleId(roleId);
    }

    @Override
    public Integer saveRoleMenu(RoleMenu roleMenu) {
         return roleMenuMapper.insertSelective(roleMenu);
    }
}
