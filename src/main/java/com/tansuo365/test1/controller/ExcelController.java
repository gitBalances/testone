package com.tansuo365.test1.controller;

import com.alibaba.fastjson.JSONObject;
import com.tansuo365.test1.bean.PetroleumCoke;
import com.tansuo365.test1.excel.ExcelLogs;
import com.tansuo365.test1.excel.ExcelUtil;
import com.tansuo365.test1.service.PetroleumCokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private PetroleumCokeService petroleumCokeService;

    @RequestMapping("/importExcel")
    public Integer importExcel(@RequestParam(value = "uploadFile") MultipartFile uploadFile,
                Model model){
        JSONObject jsonObject = new JSONObject();
        InputStream in = null;
        System.err.println("in Excel Controller importExcel method;");
        System.out.println("excel:"+uploadFile);
        //获取前台excel输入流
        try {
            in = uploadFile.getInputStream();
            System.err.println(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //excel的表头与文字对应,获取excel表头.
        if (uploadFile.getOriginalFilename().isEmpty() || uploadFile.getSize() == 0) {
            String message="上传失败";
            model.addAttribute("m",message);
        }
        ExcelLogs log = new ExcelLogs();
        Collection<PetroleumCoke> petroleumCokes = ExcelUtil.importExcel(PetroleumCoke.class, in, "yyyy-MM-dd HH:mm:ss", log, 0);
        System.out.println("petroleumCokes.toString()>>"+petroleumCokes.toString());
        List list = (List) petroleumCokes;
        for (Object p : list){
            System.err.println(p);
        }
//        System.out.println("list.get(0)>>"+list.get(0));
//        System.out.println("list.get(1)>>"+list.get(1));
        Integer message = petroleumCokeService.insertBatchList(list);

        return message;
    }
}
