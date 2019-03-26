package com.tansuo365.test1.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/salesman")
    public String salesMan(){
        return "webtest/salesman";
    }

    @RequestMapping("/bootstrap")
    public String anode_test(){
        return "webtest/anode_test";
    }



}
