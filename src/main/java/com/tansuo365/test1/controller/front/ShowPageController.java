package com.tansuo365.test1.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*前端页面展示*/
//TODO 将title改为后台页面设定 (高扩展)
@Controller
public class ShowPageController {

    /*展示首页*/
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("title","碳索365 测试网页!");
        return "index";
    }


    /*about介绍页面*/
    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("title","关于碳索365");
        return "about";
    }

    /*services*/
    @RequestMapping("/services")
    public String services(Model model){
        model.addAttribute("title","services");
        return "services";
    }

    /*contact*/
    @RequestMapping("/contact")
    public String contact(Model model){
        model.addAttribute("title","contact");
        return "contact";
    }

    //TODO 其它待定页面
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
