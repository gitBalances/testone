package com.tansuo365.test1.mapper;

import com.tansuo365.test1.bean.EMenu;
import com.tansuo365.test1.bean.EMenuExample;
import java.util.List;

import com.tansuo365.test1.bean.PetroleumCoke;
import org.apache.ibatis.annotations.Param;

public interface EMenuMapper {
    long countByExample(EMenuExample example);

    int deleteByExample(EMenuExample example);

    int insert(EMenu record);

    //动态插入
    int insertSelective(EMenu eMenu);

    List<EMenu> selectByExample(EMenuExample example);

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

    int updateByExampleSelective(@Param("record") EMenu record, @Param("example") EMenuExample example);

    int updateByExample(@Param("record") EMenu record, @Param("example") EMenuExample example);

    //动态更新
    int updateByPrimaryKeySelective(EMenu eMenu);


}