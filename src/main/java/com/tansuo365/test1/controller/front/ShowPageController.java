package com.tansuo365.test1.controller.front;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*前端页面展示*/
//TODO 将title改为后台页面设定 (高扩展)
@Api(value = "展示前端页面控制层",tags = "前端页面控制接口 ShowPageController",description = "展示前端页面控制层")
@Controller
public class ShowPageController {

    /*展示首页*/
    @ApiOperation(value="首页", notes="首页")
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("title","首页");
        return "/front/index";
    }

    /*资讯*/
    @ApiOperation(value="资讯", notes="资讯")
    @GetMapping("/information")
    public String information(Model model){
        model.addAttribute("title","资讯");
        return "/front/information";
    }

    /*产业地图*/
    @ApiOperation(value="产业地图", notes="产业地图")
    @GetMapping("/map")
    public String map(Model model){
        model.addAttribute("title","产业地图");
        return "/front/map";
    }

    /*大宗原料*/
    @ApiOperation(value="大宗原料", notes="大宗原料")
    @GetMapping("/materials")
    public String materials(Model model){
        model.addAttribute("title","大宗原料");
        return "/front/materials";
    }

    /*行情*/
    @ApiOperation(value="行情", notes="行情")
    @GetMapping("/quotation")
    public String quotation(Model model){
        model.addAttribute("title","行情");
        return "/front/quotation";
    }

    /*上半年*/
    @ApiOperation(value="上半年", notes="上半年")
    @GetMapping("/f_year")
    public String f_year(Model model){
//        model.addAttribute("title","关于碳索365");
        return "/front/f_year";
    }

    /*下半年*/
    @ApiOperation(value="下半年", notes="下半年")
    @GetMapping("/s_year")
    public String s_year(Model model){
//        model.addAttribute("title","关于碳索365");
        return "/front/s_year";
    }

//    关于我们
    @ApiOperation(value="关于我们", notes="关于我们")
    @GetMapping("/aboutUs")
    public String aboutUs(Model model){
        model.addAttribute("title","关于我们");
        return "/front/aboutUs";
    }

//    发展历程
    @ApiOperation(value="发展历程", notes="发展历程")
    @GetMapping("/development")
    public String development(Model model){
        model.addAttribute("title","发展历程");
        return "/front/development";
    }

    //    行情列表页
    @ApiOperation(value="行情列表页", notes="行情列表页")
    @GetMapping("/market_list")
    public String market_list(Model model){
        model.addAttribute("title","行情列表");
        return "/front/market_list";
    }

    //    行情图表页
    @ApiOperation(value="行情图表页", notes="行情图表页")
    @GetMapping("/market_listmore")
    public String market_listmore(Model model){
        model.addAttribute("title","行情图表");
        return "/front/market_listmore";
    }

    //    网站地图
    @ApiOperation(value="网站地图", notes="网站地图")
    @GetMapping("/site_map")
    public String site_map(Model model){
        model.addAttribute("title","网站地图");
        return "/front/site_map";
    }

    /*old set*/

    /*services*/
    @ApiOperation(value="服务", notes="服务")
    @GetMapping("/services")
    public String services(Model model){
        model.addAttribute("title","服务");
        return "services";
    }

    /*contact*/
    @ApiOperation(value="联系", notes="联系")
    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("title","联系");
        return "contact";
    }

    //TODO 其它待定页面
    @ApiOperation(value="其它", notes="其它")
    @GetMapping("/others")
    public String others(Model model){
        model.addAttribute("title","其它");
        return "others";
    }


    /*=====================error page====================*/
    @GetMapping("/error404")
    public String  error404(){
        return "/front/404";
    }

    @GetMapping("/error500")
    public String  error500(){
        return "/front/500";
    }





//    @RequestMapping("/login")
//    public String login(){
//        return "/admin/login";
//    }



}
