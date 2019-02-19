package com.tansuo365.test1.controller.user;

import com.tansuo365.test1.bean.user.Permission;
import com.tansuo365.test1.service.user.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/*权限配置Controller*/
@Controller
@RequestMapping("config")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    /*权限列表*/
    @RequestMapping("listPermission")
    public String list(Model model){
        List<Permission> ps = permissionService.list();
        model.addAttribute("ps",ps);
        return "listPermission";
    }

    @RequestMapping("editPermission")
    public String list(Model model,long id){
        Permission permission = permissionService.get(id);
        model.addAttribute("permission",permission);
        return "editPermission";
    }

    @RequestMapping("updatePermission")
    public String update(Permission permission){
        permissionService.update(permission);
        return "redirect:listPermission";
    }

    @RequestMapping("addPermission")
    public String list(Model model,Permission permission){
        System.out.println(permission.getName());
        System.out.println(permission.getDesc_());
        permissionService.add(permission);
        return "redirect:listPermission";
    }

    @RequestMapping("deletePermission")
    public String delete(Model model,long id){
        permissionService.delete(id);
        return "redirect:listPermission";
    }

}
