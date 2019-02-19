package com.tansuo365.test1.service.user.impl;

import com.tansuo365.test1.bean.user.EMenu;
import com.tansuo365.test1.mapper.EMenuMapper;
import com.tansuo365.test1.service.user.EMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class EMenuServiceImpl implements EMenuService {

    @Resource
    private EMenuMapper eMenuMapper;

    @Override
    public List<EMenu> list() {
        return eMenuMapper.selectAllEMenu();
    }

    @Override
    public List<EMenu> listSelect(EMenu eMenu) {
        return eMenuMapper.selectEMenuSelective(eMenu);
    }

    @Override
    public Integer add(EMenu eMenu) {
        return eMenuMapper.insertSelective(eMenu);
    }

    @Override
    public EMenu getByName(String name) {
        EMenu eMenu = new EMenu();
        eMenu.setName(name);
        return eMenuMapper.selectEMenuSelective(eMenu).get(0);
    }

    @Override
    public Integer update(EMenu eMenu) {
        return eMenuMapper.updateByPrimaryKeySelective(eMenu);
    }

    //调用Mapper的查询单个EMenu by roleId,如果有重复则去除.
    //最终返回角色list中涵盖的menu id list
    @Override
    public List<Integer> findMenuIdListByRoleIds(Integer[] roleIds) {
        List<EMenu> resultList = new ArrayList<>();
        List<Integer> eMenuIdList = new LinkedList<>();
        Set<EMenu> eMenuSet = new HashSet();
        for(long roleId : roleIds){
            List<EMenu> menuList = eMenuMapper.selectEMenuByRoleId(roleId);
            //多个List去重 放入menu的id而不是实例
            eMenuSet.addAll(menuList);
        }
        resultList.addAll(eMenuSet);
        //获取去重后的EMenu,将id放入eMenuIdList
        for(EMenu eMenu : resultList){
            eMenuIdList.add(eMenu.getId());
        }
        return eMenuIdList;
    }

    @Override
    public List<EMenu> findMenuListByRoleId(Long roleId) {
       return eMenuMapper.selectEMenuByRoleId(roleId);
    }

    @Override
    public List<EMenu> findByParentId(Integer parentId) {
       return eMenuMapper.selectEMenuByParentId(parentId);
    }

    @Override
    public List<EMenu> findByParentIdAndRoleId(int parentId, Set<Long> roleIdSet) {
        List<EMenu> resultList = new ArrayList<>();
        List<EMenu> eMenuList = new ArrayList<>();//result~
        Set<EMenu> eMenuSet = new HashSet();
//        Long[] roleIds = (Long[])
        Object[] roleIds = roleIdSet.toArray();
        for (Object roleId : roleIds) {
            System.err.println("roleIds.length:"+roleIds.length);
            List<EMenu> menuList = eMenuMapper.selectEMenuByParentIdAndRoleId(parentId, (Long)roleId);
            eMenuSet.addAll(menuList);
        }
        resultList.addAll(eMenuSet);
        for(EMenu eMenu:resultList){
            eMenuList.add(eMenu);
        }
        return eMenuList;
    }

    @Override
    public List<EMenu> findByParentIdAndSingleRoleId(int parentId, Long roleId) {
        return eMenuMapper.selectEMenuByParentIdAndRoleId(parentId,roleId);
    }
}
