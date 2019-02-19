package com.tansuo365.test1.controller.excel;

import com.tansuo365.test1.bean.goods.Anode;
import com.tansuo365.test1.bean.goods.CalcinedCoke;
import com.tansuo365.test1.bean.goods.MAsphalt;
import com.tansuo365.test1.bean.goods.PetroleumCoke;
import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.excel.ExcelLogs;
import com.tansuo365.test1.excel.ExcelUtil;
import com.tansuo365.test1.service.goods.GoodsCommonService;
import com.tansuo365.test1.util.CodeJudgerUtils;
import com.tansuo365.test1.util.PetroleumCokeGradeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用于excel导入的controller
 * {@link #importExcel 导入excel,接收excel导入,文件为uploadFile,接收文件参数String instance标识上传类型}
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private GoodsCommonService goodsCommonService;
    @Autowired
    private CodeJudgerUtils codeJudgerUtils;

    private Class C;

    public Class getC() {
        return this.C;
    }

    public void setC(Class c) {
        this.C = c;
    }

    @RequestMapping("/importExcel")
    public Integer importExcel(@RequestParam(value = "uploadFile") MultipartFile uploadFile,
                               @RequestParam(value = "instance") String instance, Model model) {
        InputStream in = null;
        System.out.println("in Excel Controller importExcel method;");
        //获取前台excel输入流
        try {
            in = uploadFile.getInputStream();
            System.err.println(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //excel的表头与文字对应,获取excel表头.
        if (uploadFile.getOriginalFilename().isEmpty() || uploadFile.getSize() == 0) {
            String message = "上传失败";
            model.addAttribute("m", message);
        }
        ExcelLogs log = new ExcelLogs();

        if(instance.equals("石油焦")){
            setC(PetroleumCoke.class);
        }
        if(instance.equals("煅后焦")){
            setC(CalcinedCoke.class);
        }
        if(instance.equals("改质沥青")){
            setC(MAsphalt.class);
        }
        if(instance.equals("阳极")){
            setC(Anode.class);
        }
//        if(instance.equals("石油焦")){
//            List<Goods> newList = null;
//            for(Goods goods:list){
//                Goods newGoods = PetroleumCokeGradeUtil.setGradeBySulfur(goods);
//                if(newList == null){
//                    newList = new ArrayList<>();
//                }
//                newList.add(newGoods);
//            }
//        }

        Collection<Goods> goodsCollection = ExcelUtil.importExcel(getC(), in, "yyyy/MM/dd HH:mm:ss", log, 0);
        List<Goods> list = (List) goodsCollection;
        int code = 0;
        if(instance.equals("石油焦")){
            List<Goods> newList = null;
            for(Goods goods:list){
                Goods newGoods = PetroleumCokeGradeUtil.setGradeBySulfur(goods);
                if(newList == null){
                    newList = new ArrayList<>();
                }
                newList.add(newGoods);
            }
            code = goodsCommonService.insertBatchList(newList);
        }else{
            code = goodsCommonService.insertBatchList(list);
        }

        codeJudgerUtils.whichCodeIsOK(list, code, LogEnum.ADD_ACTION.toString(), instance);

        return code;
    }
}
