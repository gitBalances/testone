package com.tansuo365.test1.controller.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "前端页面测试",description = "echarts等前端页面测试")
@Controller
public class DemoController {

    @ApiOperation(value="开发过程文档", notes="开发过程文档")
    @RequestMapping("/doc")
    public String doc(){
        return "doc";
    }
    //form样式
    @ApiOperation(value="form表单样式", notes="[前端]form表单样式")
    @RequestMapping("/formstyle")
    public String formstyle() {
        return "/webdemo/formstyle";
    }

    //echarts样式
    @ApiOperation(value="echarts样式", notes="[前端]echarts样式")
    @RequestMapping("/echarts")
    public String echarts() {
        return "/webdemo/echarts";
    }

    //echarts样式0
    @ApiOperation(value="echarts0样式", notes="[前端]echarts样式0")
    @RequestMapping("/echarts0")
    public String echarts0() {
        return "/webdemo/echarts0";
    }
    //echarts样式01
    @ApiOperation(value="echarts01样式", notes="[前端]echarts样式01")
    @RequestMapping("/echarts01")
    public String echarts01() {
        return "/webdemo/echarts01";
    }

    //echarts样式1
    @ApiOperation(value="echarts1样式", notes="[前端]echarts样式1")
    @RequestMapping("/echarts1")
    public String echarts1() {
        return "/webdemo/echarts1";
    }

    //echarts样式2
    @ApiOperation(value="echarts2样式", notes="[前端]echarts样式2")
    @RequestMapping("/echarts2")
    public String echarts2() {
        return "/webdemo/echarts2";
    }

    //echarts样式3
    @ApiOperation(value="echarts3样式", notes="[前端]echarts样式3")
    @RequestMapping("/echarts3")
    public String echarts3() {
        return "/webdemo/echarts3";
    }

    //echartsdemo1
    @ApiOperation(value="echartsdemo1", notes="[前端]echartsdemo1")
    @RequestMapping("/echartsdemo1")
    public String echartsdemo1() {
        return "/webdemo/echartsdemo1";
    }

    //test1
    @ApiOperation(value="test1", notes="[前端]test1")
    @RequestMapping("/test1")
    public String test1() {
        return "/webdemo/test1";
    }

    //testLogin
    @ApiOperation(value="测试登录", notes="[前端]测试登录")
    @RequestMapping("/testLogin")
    public String testLogin() {
        return "/webdemo/testLogin";
    }

}
