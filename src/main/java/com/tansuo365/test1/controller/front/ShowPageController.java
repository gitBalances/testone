package com.tansuo365.test1.controller.front;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*前端页面展示*/
//TODO 将title改为后台页面设定 (高扩展)
@Api(value = "展示前端页面控制层",tags = "前端页面控制接口 ShowPageController",description = "展示前端页面控制层")
@Controller
public class ShowPageController {

    /*展示首页*/
    @ApiOperation(value="首页", notes="首页")
    @RequestMapping("/")
    public String index(Model model){
//        model.addAttribute("title","有色网 测试网页!");
        return "/front/index";
    }

    /*资讯*/
    @ApiOperation(value="资讯", notes="资讯")
    @RequestMapping("/information")
    public String information(Model model){
//        model.addAttribute("title","关于碳索365");
        return "/front/information";
    }

    /*产业地图*/
    @ApiOperation(value="产业地图", notes="产业地图")
    @RequestMapping("/map")
    public String map(Model model){
//        model.addAttribute("title","关于碳索365");
        return "/front/map";
    }

    /*大宗原料*/
    @ApiOperation(value="大宗原料", notes="大宗原料")
    @RequestMapping("/materials")
    public String materials(Model model){
//        model.addAttribute("title","关于碳索365");
        return "/front/materials";
    }

    /*行情*/
    @ApiOperation(value="行情", notes="行情")
    @RequestMapping("/quotation")
    public String quotation(Model model){
//        model.addAttribute("title","关于碳索365");
        return "/front/quotation";
    }

    /*上半年*/
    @ApiOperation(value="上半年", notes="上半年")
    @RequestMapping("/f_year")
    public String f_year(Model model){
//        model.addAttribute("title","关于碳索365");
        return "/front/f_year";
    }

    /*下半年*/
    @ApiOperation(value="下半年", notes="下半年")
    @RequestMapping("/s_year")
    public String s_year(Model model){
//        model.addAttribute("title","关于碳索365");
        return "/front/s_year";
    }





    /*old set*/

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
