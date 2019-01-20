package com.tansuo365.test1.controller;

import com.tansuo365.test1.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 后端页面控制层 (需权限判定)
 * 1-12 加入easyui页面
 */
@Controller
@RequestMapping("/admin")
public class BackEndPageController {

    /*==============用户管理=============*/

    //货主管理
    @RequestMapping("/person/shipper")
    public String shipper(){
        return "/admin/person/shipper";
    }

    //车主管理
    @RequestMapping("/person/carowner")
    public String carowner(){
        return "/admin/person/carowner";
    }

    /*==============货品价格管理=============*/

    //石油焦
    @RequestMapping("/goods/coke")
    public String coke(){
        return "admin/goods/coke";
    }

    /*===============员工管理===============*/

    //人员管理
    @RequestMapping("/employees/employees")
    public String employees(){
        return "/admin/employees/employees";
    }

    @RequestMapping("")
    public String main(){
        return "/admin/index";
    }


    /*===============页面管理===============*/

    @RequestMapping("/index")
    public String index(){
        return "/admin/index"; //52行跳转过来
    }

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

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        return "/admin/login"; //对应用户登录展示
    }

//    @CachePut(value = "subject") 即保证方法被调用,又加入缓存
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, User user,boolean rememberMe) throws AuthenticationException{
        System.err.println(rememberMe);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword(), rememberMe);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
//            e.printStackTrace();
            System.err.println("login异常");
        }
        Session session = subject.getSession();
        session.setAttribute("subject",subject);
        return "redirect:/admin/";//该路径应该为后台的首页页面,为login之后的redirect路径
    }

    @RequestMapping("/unauthorized")
    public String noPerms(){
        return "/admin/unauthorized";
    }
}
