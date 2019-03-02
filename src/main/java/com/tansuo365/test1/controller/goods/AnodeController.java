//package com.tansuo365.test1.controller.goods;
//
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.tansuo365.test1.bean.goods.Anode;
//import com.tansuo365.test1.bean.log.LogEnum;
//import com.tansuo365.test1.entity.Goods;
//import com.tansuo365.test1.mapper.goods.AnodeMapper;
//import com.tansuo365.test1.service.goods.GoodsCommonService;
//import com.tansuo365.test1.util.LogUtils;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 阳极controller
// */
//@Api(value = "阳极控制层",description = "阳极控制层,之后要弃用,改为统一goods-controller")
//@RestController
//@RequestMapping("/anode")
//public class AnodeController {
//
//    private String instance = "阳极";
//
//    @Autowired
//    private GoodsCommonService goodsCommonService;
//
//    @Resource
//    private AnodeMapper anodeMapper;
//
//    @Autowired
//    private LogUtils logUtils;
//
//    //todo 将不同的货品controller改为一个common controller
//    @ApiOperation(value="其它", notes="其它")
//    @RequestMapping("/selectSelective")
//    public Map<String, Object> selectSelective(Anode anode, Integer page, Integer rows){
//        goodsCommonService.setGoodsTypeMapper(anodeMapper);
//        Map<String, Object> map = new HashMap<String, Object>();
//        PageHelper.startPage(page, rows);
//        List<Goods> list = goodsCommonService.getBySelective(anode);
//        PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);
//        map.put("rows", pageInfo.getList());
//        map.put("total", pageInfo.getTotal());
//        int code = 0;
////        logUtils.whichCodeIsOK(list,code,LogEnum.SEARCH_ACTION.toString(),instance);
//        return map;
//    }
//
//    /*动态插入数据*/
//    @RequestMapping("/insertSelective")
//    public Integer insertSelective(Anode anode) {
//        goodsCommonService.setGoodsTypeMapper(anodeMapper);
//        int code = goodsCommonService.addBySelective(anode);
////        logUtils.whichCodeIsOK(null,code, LogEnum.ADD_ACTION.toString(), instance);
//        return code;
//    }
//
//    /*动态更新数据*/
//    @RequestMapping("/updateByPrimaryKeySelective")
//    public Integer updateByPrimaryKeySelective(Anode anode) {
//        goodsCommonService.setGoodsTypeMapper(anodeMapper);
//        int code = goodsCommonService.updateBySelective(anode);
////        logUtils.whichCodeIsOK(null,code, LogEnum.UPDATE_ACTION.toString(), instance);
//        return code;
//    }
//
//    /*删除数据*/
//    @RequestMapping("/deleteByPrimaryKey")
//    public Integer deleteByPrimaryKey(Long id) {
//        goodsCommonService.setGoodsTypeMapper(anodeMapper);
//        int code = goodsCommonService.delete(id);
////        logUtils.whichCodeIsOK(null,code,LogEnum.DELETE_ACTION.toString(),instance);
//        return code;
//    }
//
//    /*批量删除*/
//    @RequestMapping("/deleteBatchByPKs")
//    public Integer deleteBatch(@RequestParam(value = "ids[]") Long[] ids) {
//        goodsCommonService.setGoodsTypeMapper(anodeMapper);
//        int code = goodsCommonService.deleteBatchByPKs(ids);
////        logUtils.whichCodeIsOK(null,code,LogEnum.DELETE_ACTION.toString(),instance);
//        return code;
//    }
//
//
//    @RequestMapping("/selectAll")
//    public List<Goods> selectAll(){
//        goodsCommonService.setGoodsTypeMapper(anodeMapper);
//        List<Goods> all = goodsCommonService.getAll();
//        int code = 0;
////        logUtils.whichCodeIsOK(all,code,LogEnum.SEARCH_ACTION.toString(),instance);
//        return all;
//    }
//
//
//
//}
