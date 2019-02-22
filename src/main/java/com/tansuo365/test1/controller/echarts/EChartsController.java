package com.tansuo365.test1.controller.echarts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data")
public class EChartsController {


//    @RequestMapping("/common")
//    public String common(){
//        return "/admin/data/common";
//    }


    @RequestMapping("/echarts0")
    public String echarts0(){
        return "/admin/data/echarts0";
    }
}
