package com.tansuo365.test1.controller.menu;

import com.tansuo365.test1.bean.user.EMenu;
import com.tansuo365.test1.service.user.EMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "权限菜单控制层",description = "权限菜单控制层,作为权限菜单的操作.")
@RestController
@RequestMapping("/admin/menu")
public class EMenuController {

    @Autowired
    private EMenuService eMenuService;

    /**
     * 查询所有EMenu
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询所有权限菜单", notes = "查询所有权限菜单listAllEMenu")
    @RequestMapping("/listAllEMenu")
    @RequiresPermissions("路径配置")
    public Map<String, Object> listEMenu() throws Exception {
        System.out.println("第一次走数据库");
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("rows", eMenuService.list());
        return resultMap;
    }

    /**
     * 动态查询所有EMenu
     *
     * @param eMenu
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "动态查询所有权限菜单", notes = "动态查询所有权限菜单listAllEMenuSelective")
    @RequestMapping("/listAllEMenuSelective")
    @RequiresPermissions("路径配置")
    public Map<String, Object> listEMenu(EMenu eMenu) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        List<EMenu> menuList = eMenuService.listSelect(eMenu);
        resultMap.put("rows", menuList);
        return resultMap;
    }

    /**
     * 删除Emenu元组
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "删除权限菜单", notes = "删除权限菜单deleteEMenuById")
    @RequestMapping("/deleteEMenuById")
    @RequiresPermissions("路径配置")
    public Map<String, Object> deleteEMenuById(int id) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        int deleteCode = eMenuService.delete(id);
        if (deleteCode == 1) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "删除失败了");
        }
        return resultMap;
    }

    /**
     * 添加菜单信息
     *
     * @param eMenu
     * @return
     */
    @ApiOperation(value = "保存(添加)权限菜单", notes = "保存权限菜单saveMenu")
    @RequestMapping("/saveMenu")
    @RequiresPermissions("路径配置")
    public Map<String, Object> saveMenu(EMenu eMenu) {
        //eMenu含有id录入,因为menu的id不是自动生成而是手动给与
        Map<String, Object> resultMap = new HashMap<>();
        int insertCode = eMenuService.add(eMenu);
        if (insertCode > 0) {
            resultMap.put("success", true);
            resultMap.put("saveMessage", "菜单添加成功!");
        } else {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "菜单添加失败!");
        }

        return resultMap;

    }

    /**
     * 更新菜单信息
     *
     * @param eMenu
     * @return
     */
    @ApiOperation(value = "更新权限菜单", notes = "更新菜单信息updateMenu")
    @RequestMapping("/updateMenu")
    @RequiresPermissions("路径配置")
    public Map<String, Object> updateMenu(EMenu eMenu) {
        //eMenu含有id录入,因为menu的id不是自动生成而是手动给与
        Map<String, Object> resultMap = new HashMap<>();
        int updateCode = eMenuService.update(eMenu);
        if (updateCode > 0) {
            resultMap.put("success", true);
            resultMap.put("saveMessage", "菜单更新成功!");
        } else {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "菜单更新失败!");
        }

        return resultMap;

    }

}
