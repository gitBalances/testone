package com.tansuo365.test1.controller.excel;

import com.tansuo365.test1.bean.goods.Anode;
import com.tansuo365.test1.bean.goods.CalcinedCoke;
import com.tansuo365.test1.bean.goods.MAsphalt;
import com.tansuo365.test1.bean.goods.PetroleumCoke;
import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.bean.log.UserType;
import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.excel.ExcelLogs;
import com.tansuo365.test1.excel.ExcelUtil;
import com.tansuo365.test1.mapper.goods.AnodeMapper;
import com.tansuo365.test1.mapper.goods.CalcinedCokeMapper;
import com.tansuo365.test1.mapper.goods.MAsphaltMapper;
import com.tansuo365.test1.mapper.goods.PetroleumCokeMapper;
import com.tansuo365.test1.service.goods.GoodsCommonService;
import com.tansuo365.test1.util.GoodsUtils;
import com.tansuo365.test1.util.LogUtils;
import com.tansuo365.test1.util.PetroleumCokeGradeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用于excel导入的controller
 * {@link #importExcel 导入excel,接收excel导入,文件为uploadFile,接收文件参数String instance标识上传类型}
 */

@PropertySource(value="classpath:excel.properties")
@Api(value = "Excel导入控制层",tags = "Excel导入控制接口 ExcelController",description = "Excel导入控制层,导出使用js插件")
@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private GoodsCommonService goodsCommonService;
    @Autowired
    private LogUtils logUtils;
    @Autowired
    private GoodsUtils goodsUtils;
    @Value("${excel.date.pattern}")
    private String datePattern;

    @Resource
    private PetroleumCokeMapper petroleumCokeMapper;
    @Resource
    private CalcinedCokeMapper calcinedCokeMapper;
    @Resource
    private MAsphaltMapper mAsphaltMapper;
    @Resource
    private AnodeMapper anodeMapper;

    private Class C;

    public Class getC() {
        return this.C;
    }

    public void setC(Class c) {
        this.C = c;
    }

    @ApiOperation(value="导入Excel", notes="导入Excel")
    @RequestMapping("/importExcel")
    public Integer importExcel(@RequestParam(value = "uploadFile") MultipartFile uploadFile,
                               @RequestParam(value = "instance") String instance, Model model, HttpSession session) {
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
        int code = 0;
        List<Goods> list = null;


        //通过前端instance实例类型进行Class和Mapper类型的设置
        instanceJudge(instance);
        //获取货品泛型集合
        System.out.println("datePattern:"+datePattern);
        Collection<Goods> goodsCollection = ExcelUtil.importExcel(getC(), in, datePattern, log, 0);
        list = (List) goodsCollection;

//        System.out.println("excelController: list.size():"+list.size());
        if(instance.equals("石油焦")){
            //如果是石油焦,则获取每个实例元组,通过sulfur字段改变grade字段值(品级)
            List<Goods> newList = null;
            for(Goods goods:list){
                PetroleumCoke petroleumCoke = (PetroleumCoke) goods;
                Goods newGoodsAfterSetGrade = PetroleumCokeGradeUtil.setGradeBySulfur(petroleumCoke);
                if(newList == null){
                    newList = new ArrayList<>();
                }
                newList.add(newGoodsAfterSetGrade);
            }
            code = goodsCommonService.insertBatchList(newList);
            logUtils.doLog(list,code,LogEnum.ADD_ACTION,instance,session);
        }else{
            //如果不是石油焦就直接批量插入数据
          code = goodsCommonService.insertBatchList(list);
          logUtils.doLog(list,code,LogEnum.ADD_ACTION,instance,session);
        }

        System.out.println(">>>list in excelcontro : "+list);
        //TODO 更改批量插入数据时,如果是petrolumn则按照sulfur更改grade
//        logUtils.doLog(list, code,UserType.MEMBER,LogEnum.ADD_ACTION, instance,session);

        return code;
    }

    //判定前端导入instance类型
    private void instanceJudge(String instance) {
        if ("PetroleumCoke".equals(instance)) {
            goodsCommonService.setGoodsTypeMapper(petroleumCokeMapper);
            setC(PetroleumCoke.class);
        }
        if ("CalcinedCoke".equals(instance)) {
            goodsCommonService.setGoodsTypeMapper(calcinedCokeMapper);
            setC(CalcinedCoke.class);
        }
        if ("MAsphalt".equals(instance)) {
            goodsCommonService.setGoodsTypeMapper(mAsphaltMapper);
            setC(MAsphalt.class);
        }
        if ("Anode".equals(instance)) {
            goodsCommonService.setGoodsTypeMapper(anodeMapper);
            setC(Anode.class);
        }
    }
}
