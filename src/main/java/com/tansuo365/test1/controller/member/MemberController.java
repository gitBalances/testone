package com.tansuo365.test1.controller.member;


import com.tansuo365.test1.bean.member.Member;
import com.tansuo365.test1.shiro.realm.MyAuthenticationToken;
import com.tansuo365.test1.shiro.realm.LoginEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * 会员控制层(前端使用用户)
 */
@Controller
@RequestMapping("user")
public class MemberController {

    private static final String MEMBER_LOGIN_TYPE = LoginEnum.MEMBER.toString();
//    @RequestMapping("login")
//    public String login(){
//        return "/user/login";
//    }
    @RequestMapping("index")
    public String index(){
        return "/user/index";
    }

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
    public String login(HttpSession session, Model model, Member member, boolean rememberMe, String loginType) throws AuthenticationException {
        System.err.println("loginType:"+loginType);
//        System.err.println("member.username"+member.getUsername());
        System.err.println(rememberMe);
        Subject currentUser = null;
        try {
            currentUser = SecurityUtils.getSubject();
        } catch (Exception e) {
            System.out.println("member getSubject()");
            e.printStackTrace();
        }
        //指明登录类型为管理员登录(在授权时使用)
        currentUser.getSession().setAttribute("loginType",MEMBER_LOGIN_TYPE);
        System.out.println("MEMBER_LOGIN_TYPE"+MEMBER_LOGIN_TYPE);
//        MyAuthenticationToken myAuthenticationToken = new MyAuthenticationToken(member.getUsername(),member.getPassword(),rememberMe,MEMBER_LOGIN_TYPE);
        MyAuthenticationToken myAuthenticationToken = new MyAuthenticationToken(member.getUsername(),member.getPassword(),rememberMe,MEMBER_LOGIN_TYPE);

        try {
            currentUser.login(myAuthenticationToken);
            return "redirect:/";
        }catch(IncorrectCredentialsException e){
            System.err.println("登录失败:用户名/密码不匹配!");
            e.printStackTrace();
        } catch(LockedAccountException e){
            System.err.println("登录失败:账户已被冻结!");
            e.printStackTrace();
        } catch (AuthenticationException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
        }
        return "redirect:/user/login";
    }

    @RequestMapping("/doLogout")
    public void logout(){
        Subject currentUser = null;
        currentUser = SecurityUtils.getSubject();
        currentUser.logout();
    }


}
