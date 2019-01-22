package com.tansuo365.test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

    //form样式
    @RequestMapping("/formstyle")
    public String formstyle(){
        return "/webdemo/formstyle";
    }

    //echarts样式0
    @RequestMapping("/echarts")
    public String echarts(){
        return "/webdemo/echarts";
    }

    //echarts样式1
    @RequestMapping("/echarts1")
    public String echarts1(){
        return "/webdemo/echarts1";
    }
    //echarts样式2
    @RequestMapping("/echarts2")
    public String echarts2(){
        return "/webdemo/echarts2";
    }
    //echarts样式3
    @RequestMapping("/echarts3")
    public String echarts3(){
        return "/webdemo/echarts3";
    }


}
