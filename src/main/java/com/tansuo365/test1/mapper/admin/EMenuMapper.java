package com.tansuo365.test1.mapper.admin;

import com.tansuo365.test1.bean.user.EMenu;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EMenuMapper {

    int insert(EMenu record);

    int deleteByPrimaryKey(int id);

    //动态插入
    int insertSelective(EMenu eMenu);

    //动态选择EMenu
    List<EMenu> selectEMenuSelective(EMenu eMenu);

    //选取全部EMenu
    List<EMenu> selectAllEMenu();

    //根据用户roleId查询包含的EMenu id 的 List
    List<EMenu> selectEMenuByRoleId(Long roleId);

    //根据传入p_id查询涵盖的EMenu菜单list
    List<EMenu> selectEMenuByParentId(Integer parentId);

    //根据父节点以及角色id集合查询子节点
    List<EMenu> selectEMenuByParentIdAndRoleId(Integer parentId,Long roleId);

    //根据父节点和EMenuIds去查询EMenuList集合
    List<EMenu> selectEMenuByParentIdAndEMenuIds(Integer parentId,int[] menuIds);

    List<EMenu> selectEMenuByParentIdAndSingleEMenuId(Integer parentId,int menuId);

    List<EMenu> selectEMenuByParentIdAndRoleIdArr(Integer parentId,Long[] ids);

    //动态更新
    int updateByPrimaryKeySelective(EMenu eMenu);

}