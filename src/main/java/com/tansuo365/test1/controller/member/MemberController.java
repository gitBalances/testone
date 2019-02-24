package com.tansuo365.test1.controller.member;


import com.tansuo365.test1.bean.member.Member;
import com.tansuo365.test1.service.member.MemberService;
import com.tansuo365.test1.shiro.realm.MyAuthenticationToken;
import com.tansuo365.test1.shiro.realm.LoginEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 会员控制层(前端使用用户)
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;
    private static final String MEMBER_LOGIN_TYPE = LoginEnum.MEMBER.toString();

    //    @RequestMapping("login")
//    public String login(){
//        return "/user/login";
//    }
    @RequestMapping("index")
    public String index() {
        return "/user/index";
    }

    @RequestMapping("unauthorized")
    public String unauthorized() {
        return "/user/unauthorized";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "/member/login"; //对应用户登录展示
    }

    @ResponseBody
    @RequestMapping("/loginMember")
    public Map<String, Object> login(Member member, HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>();
        if (member.getUsername() != null && member.getPassword() != null) {
            if (member.getUsername().length() != 0 && member.getPassword().length() != 0) {
                List<Member> currentMember = memberService.getMemberSelective(member);
                if (currentMember.size() == 1) {
                    session.setAttribute("currentMember", currentMember.get(0));
                    resultMap.put("success", true);
                    resultMap.put("message", "登录成功!");
                } else {
                    resultMap.put("success", false);
                    resultMap.put("message", "登录失败!用户名或密码错误!");
                }
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "登录失败!用户名或密码错误!");
        }
        return resultMap;
    }

    //    @CachePut(value = "subject") 即保证方法被调用,又加入缓存
//    @RequestMapping(value = "/loginMember")
//    public String login(HttpSession session, Model model, Member member, boolean rememberMe, String loginType) throws AuthenticationException {
//        System.err.println("loginType:"+loginType);
////        System.err.println("member.username"+member.getUsername());
//        System.err.println(rememberMe);
//        Subject currentUser = null;
//        try {
//            currentUser = SecurityUtils.getSubject();
//
//        } catch (Exception e) {
//            System.out.println("member getSubject()");
//            e.printStackTrace();
//        }
//        //指明登录类型为管理员登录(在授权时使用)
//        currentUser.getSession().setAttribute("loginType",MEMBER_LOGIN_TYPE);
//        System.out.println("MEMBER_LOGIN_TYPE"+MEMBER_LOGIN_TYPE);
////        MyAuthenticationToken myAuthenticationToken = new MyAuthenticationToken(member.getUsername(),member.getPassword(),rememberMe,MEMBER_LOGIN_TYPE);
//        MyAuthenticationToken myAuthenticationToken = new MyAuthenticationToken(member.getUsername(),member.getPassword(),rememberMe,MEMBER_LOGIN_TYPE);
//
//        try {
//            currentUser.login(myAuthenticationToken);
//            return "redirect:/";
//        }catch(IncorrectCredentialsException e){
//            System.err.println("登录失败:用户名/密码不匹配!");
//            e.printStackTrace();
//        } catch(LockedAccountException e){
//            System.err.println("登录失败:账户已被冻结!");
//            e.printStackTrace();
//        } catch (AuthenticationException e) {
//            System.err.println(e.getMessage());
//            e.printStackTrace();
//        } finally {
//        }
//        return "redirect:/member/login";
//    }
    @ResponseBody
    @RequestMapping("/signUp")
    public Map<String, Object> signUp(Member member) {
        Map<String, Object> resultMap = new HashMap<>();
        Member testUser = memberService.getMemberByName(member.getUsername());
        if (testUser != null) {
            resultMap.put("success", false);
            resultMap.put("message", "用户名已存在!");
        } else {
            int code = memberService.addNewMember(member);
            if (code == 1) {
                resultMap.put("success", true);
                resultMap.put("message", "注册成功!");
            }
        }
        return resultMap;
    }

    //    @RequestMapping("/doLogout")
//    public void logout() {
//        Subject currentUser = null;
//        currentUser = SecurityUtils.getSubject();
//        currentUser.logout();
//    }
    @ResponseBody
    @RequestMapping("/doLogout")
    public Integer logout(HttpSession session) {
        try {
            session.removeAttribute("currentMember");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }


}
