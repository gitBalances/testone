package com.tansuo365.test1.controller.echarts;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "EasyUI中ECharts图表控制层",tags = "EasyUI中ECharts图表控制接口 EasyUIEChartsController",description = "EasyUI中ECharts图表控制层,只返回给定的货品类型charts")
@Controller
@RequestMapping("/easy/goods/")
public class EasyUIEChartsController {


    @ApiOperation(value="anode_charts阳极图表", notes="[图表]/goods/anode_charts")
    @RequestMapping("/anode_charts")
    public String anode_charts(Model model){
        //设定一个前端页面的id
        model.addAttribute("myChartsContainerId","test");
        return "/admin/goods/anode_charts";
    }

    @ApiOperation(value="asphalt_charts沥青图表", notes="[图表]/goods/asphalt_charts")
    @RequestMapping("/asphalt_charts")
    public String asphalt_charts(Model model){
        //设定一个前端页面的id
        model.addAttribute("myChartsContainerId","test");
        return "/admin/goods/asphalt_charts";
    }

    @ApiOperation(value="calcined_charts煅后焦图表", notes="[图表]/goods/calcined_charts")
    @RequestMapping("/calcined_charts")
    public String calcined_charts(Model model){
        //设定一个前端页面的id
        model.addAttribute("myChartsContainerId","test");
        return "/admin/goods/calcined_charts";
    }

    @ApiOperation(value="coke_charts石油焦图表", notes="[图表]/goods/coke_charts")
    @RequestMapping("/coke_charts")
    public String coke_charts(Model model){
        //设定一个前端页面的id
        model.addAttribute("myChartsContainerId","test");
        return "/admin/goods/coke_charts";
    }

}
