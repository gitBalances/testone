//package com.tansuo365.test1.controller;
//
//import com.tansuo365.test1.bean.PetroleumCoke;
//import com.tansuo365.test1.util.ExcelUtils;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class FileController {
//
//    //导出Excel
//    @RequestMapping("/export")
//    public void export(HttpServletResponse response) throws Exception{
//
//        //模拟从数据库获取需要导出的数据
//        List<PetroleumCoke> pcList = new ArrayList<PetroleumCoke>();
//        PetroleumCoke pc = new PetroleumCoke();
//        pc.setAsh(1.2f);
//
//        pcList.add(pc);
//        //导出操作
//        ExcelUtils.exportExcel(pcList,"pc数据","422",PetroleumCoke.class,"pc数据.xls",response);
//    }
//    //Excel导入
//    @RequestMapping("importExcel")
//    public void importExcel(@RequestParam("textFile") MultipartFile file, HttpServletRequest request) throws Exception{
//        //String filePath = "F:\\故乡南.xls";
//        System.out.println(file);//用来检查前端是否把文件传过来
//        //解析excel，
//        List<PetroleumCoke> pcList = ExcelUtils.importExcel(file, 1, 1,PetroleumCoke.class);
//        //也可以使用FileUtil.importExcel(filePath,1,1,FileEntity.class) 导入
//        System.out.println("导入数据一共【"+pcList.size()+"】行");
//        //TODO 保存数据库
//    }
//
//
//}
