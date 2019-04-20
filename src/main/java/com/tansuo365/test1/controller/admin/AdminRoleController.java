package com.tansuo365.test1.controller.admin;

import com.github.pagehelper.util.StringUtil;
import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.bean.user.EMenu;
import com.tansuo365.test1.bean.user.Role;
import com.tansuo365.test1.bean.user.RoleMenu;
import com.tansuo365.test1.bean.user.User;
import com.tansuo365.test1.mapper.admin.UserMapper;
import com.tansuo365.test1.service.user.*;
import com.tansuo365.test1.util.EMenuUtils;
import com.tansuo365.test1.util.LogUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*管理员角色控制层*/
@Api(value = "管理员角色控制层",  tags = "管理员角色接口 AdminRoleController", description = "管理员角色控制层,配置系统角色")
@RestController
@RequestMapping("/admin/role")
public class AdminRoleController {
    @Autowired
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private EMenuService eMenuService;
    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private LogUtils logUtils;
    @Autowired
    private EMenuUtils eMenuUtils;

    final private String ADMIN_ROLE = "admin_role";

    /**
     * 查询所有角色 静态
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询所有系统角色", notes = "查询所有系统角色listAllRoles")
    @PostMapping("/listAllRoles")
    @RequiresPermissions(value = {"系统角色管理"})
    public Map<String, Object> listAll(HttpSession session) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        List<Role> list = roleService.list();
        logUtils.doLog(list, 0, LogEnum.SEARCH_ACTION, ADMIN_ROLE, session);
        resultMap.put("rows", list);
        return resultMap;
    }


    //对管理员role的动态查询
    @ApiOperation(value = "动态查询所有系统角色", notes = "动态查询所有系统角色listAllRoleSelective")
    @PostMapping("/listAllRoleSelective")
    @RequiresPermissions(value = {"系统角色管理"})
    public Map<String, Object> listAllRoleSelective(HttpSession session, Role role) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        List<Role> roles = roleService.listSelective(role);
        logUtils.doLog(roles, 0, LogEnum.SEARCH_ACTION, ADMIN_ROLE, session);
        resultMap.put("rows", roles);
        return resultMap;
    }

    //对role的新增或更改
    @ApiOperation(value = "新增或更改角色信息", notes = "新增或更改角色信息")
    @PostMapping("/saveRole")
    @RequiresPermissions(value = {"系统角色管理"})
    public Map<String, Object> saveRole(HttpSession session, Role role) {
        Map<String, Object> resultMap = new HashMap<>();

        if (role.getId() == null) { //如果role的id为null,再判定role名称是否重复
            try {
                String roleName = role.getName();
                System.err.println("roleName:" + roleName);
                if (roleService.getByName(roleName) != null) { //每次都报错,因为如果名字不重复,肯定getByName会是null
                    resultMap.put("success", false);
                    resultMap.put("errorInfo", "角色名已经存在!");
                    return resultMap;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int updateCode = 0;
        int insertCode = 0;
        if (role.getId() != null) { //不为空,则要进行升级管理员user信息
            updateCode = roleService.update(role);
        } else { //为空,则说明是要注册新的管理员user
            insertCode = roleService.addSelective(role);

        }
        /*如果更新code或者插入code成功状态则success true,否则不是*/
        if (updateCode == 1) {
            resultMap.put("saveMessage", "管理员角色更新成功!");
            resultMap.put("success", true);
            logUtils.doLog(null, updateCode, LogEnum.UPDATE_ACTION, ADMIN_ROLE, session);
        }
        if (insertCode == 1) {
            resultMap.put("saveMessage", "管理员角色添加成功!");
            resultMap.put("success", true);
            logUtils.doLog(null, updateCode, LogEnum.ADD_ACTION, ADMIN_ROLE, session);
        }
        if (updateCode == 1 || insertCode == 1) {
            return resultMap;
        } else {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "保存失败!");
            return resultMap;
        }
    }

    /**
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "删除角色", notes = "删除角色根据ID")
    @PostMapping("/deleteRoleById")
    @RequiresPermissions(value = {"系统角色管理"})
    public Map<String, Object> deleteRoleById(HttpSession session, Long id) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        userRoleService.deleteByRole(id); // 删除用户角色关联信息
        int deleteCode = roleService.delete(id);
        if (deleteCode == 1) {
            resultMap.put("success", true);
            logUtils.doLog(null, deleteCode, LogEnum.DELETE_ACTION, ADMIN_ROLE, session);
        } else {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "删除失败了");
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
     *
     * @param parentId
     * @param
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "权限菜单", notes = "根据父节点获取所有复选框权限菜单树")
    @PostMapping("/loadCheckMenuInfo")
    @RequiresPermissions(value = {"系统角色管理"})
    public String loadCheckMenuInfo(Integer parentId, Long roleId) throws Exception {
        List<EMenu> eMenuList = eMenuService.findMenuListByRoleId(roleId);
        List<Integer> eMenuIdList = new ArrayList<>();
        for (EMenu eMenu : eMenuList) {
            Integer id = eMenu.getId();
            eMenuIdList.add(id);
        }
        String allCheckedEMenu = eMenuUtils.getAllCheckedEMenuByParentId(parentId, eMenuIdList).toString();
        return allCheckedEMenu;
    }

    /**
     * 保存角色权限设置
     * 该方法先根据该角色将所有对应的role_menu元组删除,
     * 之后再根据树形表单中点选的menuId集合进行设置.
     * saveMenuSet使用率远比刷新首页低,所以缓存放在这里,而首页获取allMenu时就简洁了
     *
     * @param menuIds
     * @param roleId
     * @return
     */
    @ApiOperation(value = "保存角色权限设置", notes = "保存角色权限设置根据给定菜单ids,角色id")
//    @CachePut(value = "menuIds", key = "''+#+',roleId'+#roleId", condition = "#menuIds != '' ") //即保证方法被调用,又加入缓存
//    @CachePut(value = "roleMenuStr", key = "#session.getAttribute('currentUser').toString()+#session.getAttribute('roleList').toString()", condition = "#parentId !=  '' ")
    @CachePut(value = "roleMenuStr", key = "#menuIds+#roleId", condition = "#parentId !=  '' ")
    @PostMapping("/saveMenuSet")
    @RequiresPermissions(value = {"系统角色管理"})
    public Map<String, Object> saveMenuSet(HttpSession session, String menuIds, Integer roleId) {

        System.out.println("inSaveMenuSet,menuIds:" + menuIds);
        String message = "";
        Map<String, Object> resultMap = new HashMap<>();

        //根据roleid,删除role_menu元组
        int deleteCode = roleMenuService.deleteByRoleId(roleId);
        if (deleteCode == 1) {
            //根据roleId删除roleMenu数据ok
//            message = "剔除角色权限成功/";
            System.out.println("删除了roleId为" + roleId + "的role_menu数据.");
        }
        int insertCode = 0;
        int count = 0;

        ArrayList menuIdList = new ArrayList();
        //开始更新rolemenu
        if (StringUtil.isNotEmpty(menuIds)) {
            String idsStr[] = menuIds.split(",");
            for (int i = 0; i < idsStr.length; i++) {
                RoleMenu roleMenu = new RoleMenu();
                menuIdList.add(Integer.parseInt(idsStr[i]));
                //设置传入的roleid到role_menu表
                roleMenu.setRole_id(roleId);
                roleMenu.setMenu_id(Integer.parseInt(idsStr[i]));
                int code = roleMenuService.saveRoleMenu(roleMenu);
                insertCode += code;
                count++;

            }
        }
        if (insertCode == count && insertCode != 0) {
            resultMap.put("success", true);
            message = "保存角色权限成功";
            resultMap.put("message", message);
            String roleMenuStr = eMenuUtils.getAllCheckedEMenuByParentId(-1, menuIdList).toString();
            logUtils.doLog(null, insertCode, LogEnum.ADD_ACTION, ADMIN_ROLE, session);
            return resultMap;
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "保存角色权限设置失败.");
            return resultMap;
        }
    }

    //注册功能
    @ApiOperation(value="管理员注册功能", notes="管理员注册,仅用于测试")
    @PostMapping("/register")
    public Map<String,Object> reg(User user){

        Map<String,Object> map = new HashMap<>();
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";
        String encodedPassword = new SimpleHash(algorithmName, user.getPassword(), salt, times).toString();
        user.setPassword(encodedPassword);
        user.setSalt(salt);

        int insertCode = 0;
        try {
            insertCode = userMapper.insertSelective(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(insertCode>0){
            map.put("code",1);
            map.put("message","注册成功,请登录");
            return map;
//            return "redirect:/admin";
        }else{
            map.put("code",0);
            map.put("message","注册失败,请再试一次");
            return map;
//            return "/admin/reg";
        }
    }

}
