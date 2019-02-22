package com.tansuo365.test1.service.user;

import com.tansuo365.test1.bean.user.EMenu;

import java.util.List;
import java.util.Set;


public interface EMenuService {

    //删除
    public Integer delete(int id);

    //查询所有
    public List<EMenu> list();

    //动态查询所有
    public List<EMenu> listSelect(EMenu eMenu);

    //动态插入
    public Integer add(EMenu eMenu);

    //通过菜单名获取菜单
    public EMenu getByName(String name);

    //动态更新
    public Integer update(EMenu eMenu);

    //根据用户的roleIds数组查看用户可以浏览的EMenu页面路径的Id,List集合
    public List<Integer> findMenuIdListByRoleIds(Integer[] roleIds);

    //根据roleid查看实例list,这里的roleid并不是本表的,而是传入的角色roleid
    public List<EMenu> findMenuListByRoleId(Long roleId);

    //根据父节点获取菜单节点
    public List<EMenu> findByParentId(Integer parentId);

    //根据父节点以及角色id集合查询子节点 已去重
    public List<EMenu> findByParentIdAndRoleIdArr(int parentId,Long[] ids);

    //根据父节点以及角色id集合查询子节点 已去重
    public List<EMenu> findByParentIdAndSingleRoleId(int parentId,Long roleId);

}
