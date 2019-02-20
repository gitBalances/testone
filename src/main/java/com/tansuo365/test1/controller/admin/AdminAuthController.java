package com.tansuo365.test1.controller.admin;

import com.tansuo365.test1.bean.goods.CalcinedCoke;
import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.bean.log.LogUser;
import com.tansuo365.test1.bean.user.EMenu;
import com.tansuo365.test1.service.log.LogService;
import com.tansuo365.test1.service.user.EMenuService;
import com.tansuo365.test1.service.user.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*配置EMenu*/
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
    @RequestMapping("/listAllEMenu")
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
    @RequestMapping("/listAllEMenuSelective")
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
    @RequestMapping("/saveMenu")
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
     * 查询日志
     * @param logUser
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/listLogSelectiveByPage")
    public Map<String, Object> getLogSelectiveByPage(LogUser logUser, Integer page, Integer rows){
        return logService.getLogSelectiveByPage(logUser,page,rows);
    }











}
