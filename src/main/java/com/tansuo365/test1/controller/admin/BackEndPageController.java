package com.tansuo365.test1.controller.admin;

import com.tansuo365.test1.mapper.admin.UserMapper;
import com.tansuo365.test1.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 后端页面控制层 (需权限判定)
 * 1-12 加入easyui页面
 */
@Api(value = "后端页面控制层",tags = "后端页面控制接口 BackEndPageController",description = "主要作为后端页面的页面跳转控制")
@Controller
@RequestMapping("/admin")
public class BackEndPageController {

//    private static final String ADMIN_LOGIN_TYPE = LoginEnum.ADMIN.toString();

    @Autowired
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    /*==============会员管理=============*/

    //前端会员
    @ApiOperation(value="前端会员", notes="会员信息管理")
    @GetMapping("/member/members")
    @RequiresPermissions(value = {"会员信息管理"})
    public String members(){
        return "admin/member/members";
    }

    //会员等级, 角色 配置
    @ApiOperation(value="会员角色", notes="会员等级管理")
    @GetMapping("/member/mrole")
    @RequiresPermissions(value = {"会员等级管理"})
    public String mrole(){
        return "/admin/member/mrole";
    }

    /*==============货品价格管理=============*/

    //石油焦
    @ApiOperation(value="石油焦", notes="石油焦信息")
    @GetMapping("/goods/coke")
    @RequiresPermissions(value = {"石油焦信息"})
    public String coke(Model model){
        model.addAttribute("title","石油焦信息");
        return "/admin/goods/coke";
    }

    //煅后焦
    @ApiOperation(value="煅后焦", notes="煅后焦信息")
    @GetMapping("/goods/calcined")
    @RequiresPermissions(value = {"煅后焦信息"})
    public String calcined(Model model){
        model.addAttribute("title","煅后焦信息");
        return "/admin/goods/calcined";
    }

    //沥青
    @ApiOperation(value="沥青", notes="改质沥青信息")
    @GetMapping("/goods/asphalt")
    @RequiresPermissions(value = {"改质沥青信息"})
    public String asphalt(Model model){
        model.addAttribute("title","改质沥青信息");
        return "/admin/goods/asphalt";
    }

    //阳极
    @ApiOperation(value="阳极", notes="阳极信息")
    @GetMapping("/goods/anode")
    @RequiresPermissions(value = {"阳极信息"})
    public String anode(Model model){
        model.addAttribute("title","阳极信息");
        return "/admin/goods/anode";
    }

    /*===============员工管理===============*/

    //人员管理
    @ApiOperation(value="员工管理", notes="员工信息管理")
    @GetMapping("/employees/employees")
    @RequiresPermissions(value = {"员工信息管理"})
    public String employees(){
        return "/admin/employees/employees";
    }

    /*=============管理员/权限管理===========*/

    //后台管理员table 外加角色设置
    @ApiOperation(value="管理员", notes="后台用户管理")
    @GetMapping("/power/user")
    @RequiresPermissions(value = {"后台用户管理"})
    public String user(){
        return "/admin/power/user";
    }

    //后台管理员的Role设定页面
//    @RequestMapping("/power/role")
//    public String userRole(){
//        return "/admin/power/role";
//    }

    /*=============系统配置===========*/

    //树形菜单
    @ApiOperation(value="权限菜单", notes="路径配置")
    @GetMapping("/auth/menu")
    @RequiresPermissions(value = {"路径配置"})
    public String eMenu(){
        return "/admin/auth/menu";
    }

    //数据库备份
    @ApiOperation(value="数据库备份", notes="数据库备份")
    @GetMapping("/auth/dbbackup")
    @RequiresPermissions(value = {"数据库备份"})
    public String dbbackup(){
        return "/admin/auth/dbbackup";
    }

    //管理员角色表设定
    @ApiOperation(value="管理员角色表设定", notes="系统角色管理")
    @GetMapping("/auth/roleconfig")
    @RequiresPermissions(value = {"系统角色管理"})
    public String roleconfig(){
        return "admin/auth/roleconfig";
    }

    //系统日志
    @ApiOperation(value="系统日志", notes="系统日志")
    @GetMapping("/auth/syslog")
    @RequiresPermissions(value = {"系统日志"})
    public String syslog(){
        return "/admin/auth/syslog";
    }

    //会员日志
    @ApiOperation(value="会员日志", notes="会员日志")
    @GetMapping("/auth/memberlog")
    @RequiresPermissions(value = {"会员日志"})
    public String memberlog(){
        return "/admin/auth/memberlog";
    }

    //系统设置
    @ApiOperation(value="系统配置", notes="系统配置")
    @GetMapping("/auth/sysconfig")
    @RequiresPermissions(value = {"系统配置"})
    public String sysconfig(){
        return "/admin/auth/sysconfig";
    }

    /*=================用户登录和注册===================*/
    @ApiOperation(value = "/login登录页", notes = "返回/admin下login.html")
    @GetMapping(value = "/login")
    public String login() {
        return "/admin/login"; //对应用户登录展示
    }


    /*=================基本路径===================*/

    @ApiOperation(value="之前的后台首页", notes="之前的后台首页/admin/index")
    @GetMapping("")
    @RequiresAuthentication
    public String indexMain(){
        return "/admin/index";
    }


    /*===============页面管理===============*/

    @ApiOperation(value="现在的后台首页", notes="之前的后台首页/admin/main")
    @GetMapping("/main")
    @RequiresAuthentication
    public String main(){
        return "/admin/main";
    }

    /*老版本*/
    @ApiOperation(value="之前的后台首页", notes="之前的后台首页/admin/index")
    @GetMapping("/index")
    @RequiresAuthentication
    public String index(){
        return "/admin/index"; //52行跳转过来
    }

    @ApiOperation(value="未授权页面", notes="未授权页面")
    @GetMapping("/unauthorized")
    public String noPerms(){
        return "/admin/unauthorized";
    }

    @ApiOperation(value="开发文档", notes="开发文档记录")
    @GetMapping("/file")
    @RequiresAuthentication
    public String file(){
        return "/admin/file";
    }

    @ApiOperation(value="swagger接口文档", notes="swagger接口文档")
    @GetMapping("/swagger")
    @RequiresAuthentication
    public String swagger(){
        return "/admin/auth/swagger";
    }

    @ApiOperation(value="druid数据库监控", notes="druid数据库监控")
    @GetMapping("/druid")
    @RequiresAuthentication
    public String druid(){
        return "/admin/auth/druid";
    }

    /*===============服务器信息===============*/

    @ApiOperation(value="server信息", notes="server信息")
    @GetMapping("/server")
    @RequiresAuthentication
    public String server(){
        return "admin/server/server";
    }


}
