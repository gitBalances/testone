package com.tansuo365.test1.controller.admin;

import com.tansuo365.test1.bean.goods.CalcinedCoke;
import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.bean.log.LogUser;
import com.tansuo365.test1.bean.user.EMenu;
import com.tansuo365.test1.service.log.LogService;
import com.tansuo365.test1.service.user.EMenuService;
import com.tansuo365.test1.service.user.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*配置EMenu*/
@Api(value = "管理员权限控制层",description = "管理员权限路径,仅作为系统管理员可调用")
@RestController
@RequestMapping("/admin/auth")
public class AdminAuthController {

    @Autowired
    private EMenuService eMenuService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private LogService logService;


    /**
     * 查询所有EMenu
     * @return
     * @throws Exception
     */
    @ApiOperation(value="查询所有权限菜单", notes="查询所有权限菜单listAllEMenu")
    @RequestMapping("/listAllEMenu")
    @RequiresPermissions("路径配置")
    public Map<String,Object> listEMenu()throws Exception{
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("rows",eMenuService.list());
        return resultMap;
    }

    /**
     * 动态查询所有EMenu
     * @param eMenu
     * @return
     * @throws Exception
     */
    @ApiOperation(value="动态查询所有权限菜单", notes="动态查询所有权限菜单listAllEMenuSelective")
    @RequestMapping("/listAllEMenuSelective")
    @RequiresPermissions("路径配置")
    public Map<String,Object> listEMenu(EMenu eMenu)throws Exception{
        Map<String, Object> resultMap = new HashMap<>();
        List<EMenu> menuList = eMenuService.listSelect(eMenu);
        resultMap.put("rows",menuList);
        return resultMap;
    }


    /**
     * 添加或者修改菜单信息 TODO 需要完善更新时的方法
     * @param eMenu
     * @return
     */
    @ApiOperation(value="保存或修改权限菜单", notes="保存或修改权限菜单saveMenu")
    @RequestMapping("/saveMenu")
    @RequiresPermissions("路径配置")
    public Map<String,Object> saveMenu(EMenu eMenu){
        //eMenu含有id录入,因为menu的id不是自动生成而是手动给与
        //当判定时除了
        Map<String,Object> resultMap = new HashMap<>();

        int insertCode = eMenuService.add(eMenu);
        resultMap.put("success",true);
        resultMap.put("saveMessage","菜单添加成功!");

        return resultMap;

    }


    /**
     * 删除Emenu元组
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value="删除权限菜单", notes="删除权限菜单deleteEMenuById")
    @RequestMapping("/deleteEMenuById")
    @RequiresPermissions("路径配置")
    public Map<String,Object> deleteEMenuById(int id)throws Exception{
        Map<String, Object> resultMap = new HashMap<>();
        int deleteCode = eMenuService.delete(id);
        if(deleteCode==1){
            resultMap.put("success",true);
        }else{
            resultMap.put("success",false);
            resultMap.put("errorInfo","删除失败了");
        }
        return resultMap;
    }


    /**
     * 查询日志
     * @param logUser
     * @param page
     * @param rows
     * @return
     */
    @ApiOperation(value="分页查询日志信息", notes="分页查询日志信息listLogSelectiveByPage")
    @RequestMapping("/listLogSelectiveByPage")
    @RequiresPermissions(value={"系统日志"})
    public Map<String, Object> getLogSelectiveByPage(LogUser logUser, Integer page, Integer rows){
        return logService.getLogSelectiveByPage(logUser,page,rows);
    }











}
