package com.tansuo365.test1.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/salesman")
    public String salesMan(){
        return "webtest/salesman";
    }

    @GetMapping("/bootstrap")
    public String anode_test(){
        return "webtest/anode_test";
    }

    @GetMapping("/addNews")
    public String addNews(){
        return "/news/add_news";
    }




}
