package com.tansuo365.test1.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.tansuo365.test1.bean.user.EMenu;
import com.tansuo365.test1.bean.user.Role;
import com.tansuo365.test1.bean.user.RoleMenu;
import com.tansuo365.test1.service.user.EMenuService;
import com.tansuo365.test1.service.user.RoleMenuService;
import com.tansuo365.test1.service.user.RoleService;
import com.tansuo365.test1.service.user.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


/*管理员角色控制层*/
@Api(value = "管理员角色控制层",description = "管理员角色控制层,配置系统角色")
@RestController
@RequestMapping("/admin/role")
public class AdminRoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private EMenuService eMenuService;
    @Autowired
    private RoleMenuService roleMenuService;
    /**
     * 查询所有角色 静态
     * @return
     * @throws Exception
     */
    @ApiOperation(value="查询所有系统角色", notes="查询所有系统角色listAllRoles")
    @RequestMapping("/listAllRoles")
    @RequiresPermissions(value = {"系统角色管理"})
    public Map<String,Object> listAll()throws Exception{
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("rows", roleService.list());
        return resultMap;
    }


    //对管理员role的动态查询
    @ApiOperation(value="动态查询所有系统角色", notes="动态查询所有系统角色listAllRoleSelective")
    @RequestMapping("/listAllRoleSelective")
    @RequiresPermissions(value = {"系统角色管理"})
    public Map<String,Object> listAllRoleSelective(Role role)throws Exception{
        Map<String, Object> resultMap = new HashMap<>();
        List<Role> roles = roleService.listSelective(role);
        resultMap.put("rows",roles);
        return resultMap;
    }

    //对role的新增或更改
    @ApiOperation(value="新增或更改角色信息", notes="新增或更改角色信息")
    @RequestMapping("/saveRole")
    @RequiresPermissions(value = {"系统角色管理"})
    public Map<String,Object> saveRole(Role role) {
        Map<String,Object> resultMap = new HashMap<>();

        if(role.getId()==null){ //如果role的id为null,再判定role名称是否重复
            try {
                String roleName = role.getName();
                System.err.println("roleName:"+roleName);
                if (roleService.getByName(roleName) != null) { //每次都报错,因为如果名字不重复,肯定getByName会是null
                    resultMap.put("success", false);
                    resultMap.put("errorInfo", "角色名已经存在!");
                    return resultMap;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        int updateCode = 0;
        int insertCode = 0;
        if(role.getId()!=null){ //不为空,则要进行升级管理员user信息
            updateCode = roleService.update(role);
            resultMap.put("saveMessage","管理员角色更新成功!");
        }else{ //为空,则说明是要注册新的管理员user
            insertCode = roleService.addSelective(role);
            resultMap.put("saveMessage","管理员角色添加成功!");
        }
        /*如果更新code或者插入code成功状态则success true,否则不是*/
        if(updateCode==1 || insertCode==1){
            resultMap.put("success",true);
            return resultMap;
        }else{
            resultMap.put("success",false);
            resultMap.put("errorInfo","保存失败!");
            return resultMap;
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value="删除角色", notes="删除角色根据ID")
    @RequestMapping("/deleteRoleById")
    @RequiresPermissions(value = {"系统角色管理"})
    public Map<String,Object> deleteRoleById(Long id)throws Exception{
        Map<String, Object> resultMap = new HashMap<>();
        userRoleService.deleteByRole(id); // 删除用户角色关联信息
        int deleteCode = roleService.delete(id);
        if(deleteCode==1){
            resultMap.put("success",true);
        }else{
            resultMap.put("success",false);
            resultMap.put("errorInfo","删除失败了");
        }
        return resultMap;
    }


//    /**
//     * 根据父节点获取所有复选框权限菜单树 Array
//     * @param parentId
//     * @param roleIds
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/loadCheckMenuInfoArray")
//    public String loadCheckMenuInfoArray(Integer parentId,Integer[] roleIds)throws Exception{
//        //根据角色查询所有权限菜单id信息(已在impl去重),首先要获取用户的roleid(集合)
//        List<Integer> menuIdList = eMenuService.findMenuIdListByRoleIds(roleIds);
//        return getAllCheckedEMenuByParentId(parentId,menuIdList).toString();
//    }

    /**
     * 根据父节点获取所有复选框权限菜单树
     * @param parentId
     * @param
     * @return
     * @throws Exception
     */
    @ApiOperation(value="权限菜单", notes="根据父节点获取所有复选框权限菜单树")
    @RequestMapping("/loadCheckMenuInfo")
    @RequiresPermissions(value = {"系统角色管理"})
    public String loadCheckMenuInfo(Integer parentId,Long roleId)throws Exception{
        List<EMenu> eMenuList = eMenuService.findMenuListByRoleId(roleId);
        List<Integer> eMenuIdList = new ArrayList<>();
        for(EMenu eMenu:eMenuList){
            Integer id = eMenu.getId();
            eMenuIdList.add(id);
        }
        return getAllCheckedEMenuByParentId(parentId,eMenuIdList).toString();
    }


//    根据父节点ID和权限菜单ID集合获取复选框菜单节点
    private JSONArray getAllCheckedEMenuByParentId(Integer parentId,List<Integer> menuIdList){
        JSONArray jsonArray = this.getCheckedMenuByParentId(parentId,menuIdList);
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            if("open".equals(jsonObject.get("state").toString())){
                continue;
            }else{
                jsonObject.put("children",getAllCheckedEMenuByParentId((Integer) jsonObject.get("id"),menuIdList));
            }
        }
        return jsonArray;
    }

    //根据父节点ID和权限菜单ID集合获取复选框菜单节点
    private JSONArray getCheckedMenuByParentId(Integer parentId, List<Integer> menuIdList) {
        List<EMenu> menuList = eMenuService.findByParentId(parentId);
        JSONArray jsonArray = new JSONArray();
        for(EMenu eMenu:menuList){
            JSONObject jsonObject = new JSONObject();
            //获取menuid
            int menuId = eMenu.getId();
            jsonObject.put("id",menuId); //节点id
            jsonObject.put("text", eMenu.getName()); //节点名称 / 菜单名
            if(eMenu.getState()==1){ //根节点
                jsonObject.put("state","closed");
            }else{ //叶子节点
                jsonObject.put("state","open");
            }
            if(menuIdList.contains(menuId)){ //如果用户role涵盖的menuId list包含这个通过parentid查询到的 节点菜单
                jsonObject.put("checked",true);
            }
            jsonObject.put("iconCls",eMenu.getIcon());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    /**
     * 保存角色权限设置
     * @param menuIds
     * @param roleId
     * @return
     */
    @ApiOperation(value="保存角色权限设置", notes="保存角色权限设置根据给定菜单ids,角色id")
    @RequestMapping("/saveMenuSet")
    @RequiresPermissions(value = {"系统角色管理"})
    public Map<String,Object> saveMenuSet(String menuIds,Integer roleId){
        Map<String,Object> resultMap = new HashMap<>();
        int deleteCode = roleMenuService.deleteByRoleId(roleId);
        if(deleteCode == 1){
            //根据roleId删除roleMenu数据ok
        }
        int insertCode = 0;
        int count = 0;
        if(StringUtil.isNotEmpty(menuIds)){
            String idsStr[] = menuIds.split(",");
            for(int i=0;i<idsStr.length;i++){
                RoleMenu roleMenu = new RoleMenu();
                //设置传入的roleid到role_menu表
                roleMenu.setRole_id(roleId);
                roleMenu.setMenu_id(Integer.parseInt(idsStr[i]));
                int code = roleMenuService.saveRoleMenu(roleMenu);
                insertCode += code;
                count ++;
            }
        }
        if(insertCode==count && insertCode!=0){
            resultMap.put("success",true);
            return resultMap;
        }else{
            resultMap.put("success",false);
            return resultMap;
        }
    }



}
