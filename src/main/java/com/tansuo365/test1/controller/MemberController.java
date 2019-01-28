package com.tansuo365.test1.controller;

import com.tansuo365.test1.bean.Member;
import com.tansuo365.test1.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 会员控制层(前端使用用户)
 */
@Controller
@RequestMapping("user")
public class MemberController {

//    @RequestMapping("login")
//    public String login(){
//        return "/user/login";
//    }

    @RequestMapping("unauthorized")
    public String unauthorized(){
        return "/user/unauthorized";
    }

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        return "/user/login"; //对应用户登录展示
    }

    //    @CachePut(value = "subject") 即保证方法被调用,又加入缓存
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, Member member, boolean rememberMe,String userAgent) throws AuthenticationException {
        System.err.println("userAgent:"+userAgent);
        System.err.println(rememberMe);
        UsernamePasswordToken token = new UsernamePasswordToken(member.getUsername(),member.getPassword(), rememberMe);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
//            e.printStackTrace();
            System.err.println("login异常");
        }
        Session session = subject.getSession();
        session.setAttribute("subject",subject);
        return "redirect:../index";//该路径应该为后台的首页页面,为login之后的redirect路径
    }


}
