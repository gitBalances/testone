package com.tansuo365.test1.controller.admin;

import com.tansuo365.test1.bean.user.User;
import com.tansuo365.test1.mapper.UserMapper;
import com.tansuo365.test1.service.user.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 后端页面控制层 (需权限判定)
 * 1-12 加入easyui页面
 */
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
    @RequestMapping("/member/members")
    public String members(){
        return "/admin/member/members";
    }

    //会员等级, 角色 配置
    @RequestMapping("/member/mrole")
    public String mrole(){
        return "/admin/member/mrole";
    }

    /*==============货品价格管理=============*/

    //石油焦
    @RequestMapping("/goods/coke")
    public String coke(){
        return "/admin/goods/coke";
    }

    //煅后焦
    @RequestMapping("/goods/calcined")
    public String calcined(){
        return "/admin/goods/calcined";
    }

    //沥青
    @RequestMapping("/goods/asphalt")
    public String asphalt(){
        return "/admin/goods/asphalt";
    }

    //阳极
    @RequestMapping("/goods/anode")
    public String anode(){
        return "/admin/goods/anode";
    }


    /*===============员工管理===============*/

    //人员管理
    @RequestMapping("/employees/employees")
    public String employees(){
        return "/admin/employees/employees";
    }

    /*=============管理员/权限管理===========*/

    //后台管理员table 外加角色设置
    @RequestMapping("/power/user")
    public String user(){
        return "/admin/power/user";
    }

    //后台管理员的Role设定页面
    @RequestMapping("/power/role")
    public String userRole(){
        return "/admin/power/role";
    }

    /*=============系统配置===========*/

    //树形菜单
    @RequestMapping("/auth/menu")
    public String eMenu(){
        return "/admin/auth/menu";
    }

    //数据库备份
    @RequestMapping("/auth/dbbackup")
    public String dbbackup(){
        return "/admin/auth/dbbackup";
    }

    //管理员角色表设定
    @RequestMapping("/auth/roleconfig")
    public String roleconfig(){
        return "admin/auth/roleconfig";
    }

    //系统日志
    @RequestMapping("/auth/syslog")
    public String syslog(){
        return "/admin/auth/syslog";
    }

    //系统设置
    @RequestMapping("/auth/sysconfig")
    public String sysconfig(){
        return "/admin/auth/sysconfig";
    }




    /*=================基本路径===================*/

    @RequestMapping("")
    public String indexMain(){
        return "/admin/index";
    }


    /*===============页面管理===============*/

    @RequestMapping("/main")
    public String main(){
        return "/admin/main";
    }

    @RequestMapping("/index")
    public String index(){
        return "/admin/index"; //52行跳转过来
    }

    //TODO 加入deleteOrder页面(how2j) 改为本系统的权限链接
    @RequestMapping("/deleteOrder")
    public String deleteOrder(){
        return "/admin/deleteOrder";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(){
        return "/admin/deleteProduct";
    }

    @RequestMapping("/listProduct")
    public String listProduct(){
        return "/admin/listProduct";
    }




    //注册页面
    @RequestMapping("/reg")
    public String reg(){
        return "/admin/reg";
    }

    //注册功能
    @RequestMapping("/register")
    public String reg(Model model,User user){

        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";
        String encodedPassword = new SimpleHash(algorithmName, user.getPassword(), salt, times).toString();
        user.setPassword(encodedPassword);
        user.setSalt(salt);

        int insertCode = userMapper.insertSelective(user);

        if(insertCode>0){
            model.addAttribute("message","注册成功");
            return "/admin/";
        }else{
            model.addAttribute("message","注册失败");
            return "/admin/reg";
        }
    }

    @RequestMapping("/unauthorized")
    public String noPerms(){
        return "/admin/unauthorized";
    }

    @RequestMapping("/file")
    public String file(){
        return "/admin/file";
    }





}
