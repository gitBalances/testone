package com.tansuo365.test1.controller.front;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*前端页面展示*/
//TODO 将title改为后台页面设定 (高扩展)
@Api(value = "展示前端页面控制层",description = "展示前端页面控制层")
@Controller
public class ShowPageController {

    /*展示首页*/
    @ApiOperation(value="首页", notes="首页")
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("title","有色网 测试网页!");
        return "index";
    }


    /*about介绍页面*/
    @ApiOperation(value="关于", notes="关于")
    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("title","关于碳索365");
        return "about";
    }

    /*services*/
    @ApiOperation(value="服务", notes="服务")
    @RequestMapping("/services")
    public String services(Model model){
        model.addAttribute("title","services");
        return "services";
    }

    /*contact*/
    @ApiOperation(value="联系", notes="联系")
    @RequestMapping("/contact")
    public String contact(Model model){
        model.addAttribute("title","contact");
        return "contact";
    }

    //TODO 其它待定页面
    @ApiOperation(value="其它", notes="其它")
    @RequestMapping("/others")
    public String others(Model model){
        model.addAttribute("title","others");
        return "others";
    }

//    @RequestMapping("/login")
//    public String login(){
//        return "/admin/login";
//    }



}
