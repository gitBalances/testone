package com.tansuo365.test1.controller.member;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "前端会员控制层", tags = "前端会员控制接口 MemberController", description = "包含登录,注册,登出控制.")
@Controller
@RequestMapping("/member")
public class MemberFrontController {

    @ApiOperation(value = "会员个人信息", notes = "会员个人信息")
    @GetMapping("/info")
    public String info() {
        return "/member/auth/info";
    }

    @ApiOperation(value = "未授权页面", notes = "未授权页面")
    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "/user/unauthorized";
    }

    @ApiOperation(value = "返回会员登录页", notes = "返回会员登录页")
    @GetMapping("/login")
    public String login() {
        return "/member/login"; //对应用户登录展示
    }
}
