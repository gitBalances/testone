package com.tansuo365.test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

    //form样式
    @RequestMapping("/formstyle")
    public String formstyle() {
        return "/webdemo/formstyle";
    }

    //echarts样式
    @RequestMapping("/echarts")
    public String echarts() {
        return "/webdemo/echarts";
    }

    //echarts样式0
    @RequestMapping("/echarts0")
    public String echarts0() {
        return "/webdemo/echarts0";
    }
    //echarts样式01
    @RequestMapping("/echarts01")
    public String echarts01() {
        return "/webdemo/echarts01";
    }

    //echarts样式1
    @RequestMapping("/echarts1")
    public String echarts1() {
        return "/webdemo/echarts1";
    }

    //echarts样式2
    @RequestMapping("/echarts2")
    public String echarts2() {
        return "/webdemo/echarts2";
    }

    //echarts样式3
    @RequestMapping("/echarts3")
    public String echarts3() {
        return "/webdemo/echarts3";
    }

    //echartsdemo1
    @RequestMapping("/echartsdemo1")
    public String echartsdemo1() {
        return "/webdemo/echartsdemo1";
    }

    //test1
    @RequestMapping("/test1")
    public String test1() {
        return "/webdemo/test1";
    }

    //testLogin
    @RequestMapping("/testLogin")
    public String testLogin() {
        return "/webdemo/testLogin";
    }

}
