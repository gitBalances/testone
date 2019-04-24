package com.tansuo365.test1.controller.member;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tansuo365.test1.bean.member.Member;
import com.tansuo365.test1.service.member.MemberService;
import com.tansuo365.test1.config.shiro.realm.LoginEnum;
import com.tansuo365.test1.util.PasswordEncrypt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 会员控制层(前端使用用户)
 */
@PropertySource(value="classpath:member.properties")
@Api(value = "前端会员控制层", tags = "前端会员控制接口 MemberController", description = "包含登录,注册,登出控制.")
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private PasswordEncrypt passwordEncrypt;

    @Autowired
    private MemberService memberService;
    private static final String MEMBER_LOGIN_TYPE = LoginEnum.MEMBER.toString();

    //    @RequestMapping("login")
//    public String login(){
//        return "/user/login";
//    }


    /**
     * 使用非shiro登录
     * @param member
     * @param session
     * @return
     */
    @ApiOperation(value = "会员登录请求处理", notes = "会员登录请求处理,非shiro")
    @PostMapping("/loginMember")
    public Map<String, Object> login(Member member, HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>();
        if (member.getUsername() != null && member.getPassword() != null) {
            if (member.getUsername().length() != 0 && member.getPassword().length() != 0) {
                String plainPassword = member.getPassword();

                Member currentMember = memberService.getMemberByName(member.getUsername());

                boolean b = passwordEncrypt.passwordComparison(currentMember, plainPassword);

                if (b) {
                    session.setAttribute("currentMember", currentMember);
                    resultMap.put("success", true);
                    resultMap.put("message", "登录成功!");
                } else {//密码比对错误,密码填写错误
                    resultMap.put("success", false);
                    resultMap.put("message", "登录失败!用户名或密码错误!");
                }

            }
        }else{
            System.err.println("没有填写用户名和密码并提交到了后台");
            resultMap.put("success", false);
            resultMap.put("message", "登录失败!请填写用户名或密码!");//一般不会发生,使用前端正则校验
        }
        return resultMap;
    }

    /**
     * 使用shiro登录
     */
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

    /*邀请码 测试码*/
    @Value("${member.activation}")
    private String activationCode;

    /**
     * 会员注册
     * @param member
     * @return
     */
    @ApiOperation(value = "会员注册处理", notes = "会员注册请求处理")
    @PostMapping("/signUp")
    public Map<String, Object> signUp(Member member) {
        System.out.println("this activationCode : "+activationCode);
        Map<String, Object> resultMap = new HashMap<>();
        if(!member.getActivation().equals(activationCode)){
            resultMap.put("success", false);
            resultMap.put("message", "邀请码填写错误!");
            return resultMap;
        }
        Member testUser = memberService.getMemberByName(member.getUsername());
        if (testUser != null) {
            resultMap.put("success", false);
            resultMap.put("message", "用户名已存在!");
            return resultMap;
        } else {
            passwordEncrypt.encryptPWD(member);//对密码加密,并设置salt
            int code = memberService.addNewMember(member);
            if (code == 1) {
                resultMap.put("success", true);
                resultMap.put("message", "注册成功!");
                return resultMap;
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
    @ApiOperation(value = "会员登出", notes = "会员登出")
    @PostMapping("/doLogout")
    public Integer logout(HttpSession session) {
        try {
            session.removeAttribute("currentMember");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }


    /*=============会员easyui界面调用方法==============*/

    /**
     * 动态选择
     * @param session
     * @param member
     * @param page
     * @param rows
     * @return
     */
    @PostMapping("/selectSelective")
    public Map<String, Object> listAllMemberSelective(HttpSession session,Member member,Integer page, Integer rows){
        Map<String, Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page, rows);
        List<Member> memberList = memberService.getMemberSelective(member);
        PageInfo<Member> pageInfo = new PageInfo<Member>(memberList);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return map;
    }

    /**
     * 动态插入
     * @param session
     * @param member
     * @return
     */
    @PostMapping("/insertSelective")
    public Integer insertSelective(HttpSession session,Member member){
        boolean b = passwordEncrypt.encryptPWD(member);//加密密码,加入salt
        if(b){
            return memberService.addNewMember(member);
        }else{
            return 0;
        }
    }

    /**
     * 动态更新
     * @param session
     * @param member
     * @return
     */
    @PostMapping("/updateByPKSelective")
    public Integer updateByPKSelective(HttpSession session, Member member){
        return memberService.updateMemberSelective(member);
    }


    /**
     * 删除
     * @param session
     * @param id
     * @return
     */
    @PostMapping("/delByPK")
    public Integer delByPK(HttpSession session,Long id){
        return memberService.delMemberById(id);
    }

    /**
     * 批量删除
     * @param session
     * @param ids
     * @return
     */
    @PostMapping("/deleteBatchByPKs")
    public Integer deleteBatchByPKs(HttpSession session,@RequestParam(value = "ids[]") Long[] ids){
        return memberService.delBatchByPKArr(ids);
    }

}
