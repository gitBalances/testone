package com.tansuo365.test1.controller;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMethod;

/*登录控制 2019-1-10 更换到BackEndPageController*/
@Controller
@RequestMapping("/test1") //通过admin路径登录后台
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model,String name,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);

        subject.login(token);
        Session session = subject.getSession();
        session.setAttribute("subject",subject);
        return "redirect:index";//该路径应该为后台的首页页面
    }

}
