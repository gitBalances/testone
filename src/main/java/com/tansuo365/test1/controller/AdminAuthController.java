package com.tansuo365.test1.controller;

import com.tansuo365.test1.bean.EMenu;
import com.tansuo365.test1.bean.Role;
import com.tansuo365.test1.service.EMenuService;
import com.tansuo365.test1.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

//        if(eMenu.getId()==null){
//            if(eMenuService.getByName(eMenu.getName())!=null){
//                resultMap.put("success",false);
//                resultMap.put("errorInfo","菜单已经存在!");
//                return resultMap;
//            }
//        }
//        int updateCode = 0;
//        int insertCode = 0;
//        if(eMenu.getId()!=null){ //不为空,则要进行升级管理员user信息
//            updateCode = eMenuService.update(eMenu);
//            resultMap.put("saveMessage","菜单信息更新成功!");
//        }else{ //为空,则说明是要注册新的管理员user
//            insertCode = eMenuService.add(eMenu);
//            resultMap.put("saveMessage","菜单添加成功!");
//        }
//        /*如果更新code或者插入code成功状态则success true,否则不是*/
//        if(updateCode==1 || insertCode==1){
//            resultMap.put("success",true);
//            return resultMap;
//        }else{
//            resultMap.put("success",false);
//            resultMap.put("errorInfo","保存失败!(⊙o⊙)？");
//            return resultMap;
//        }
    }








}
