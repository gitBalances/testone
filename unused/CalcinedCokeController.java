//package com.tansuo365.test1.controller.goods;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.tansuo365.test1.bean.goods.CalcinedCoke;
//import com.tansuo365.test1.bean.log.LogEnum;
//import com.tansuo365.test1.entity.Goods;
//import com.tansuo365.test1.mapper.goods.CalcinedCokeMapper;
//import com.tansuo365.test1.service.goods.GoodsCommonService;
//import com.tansuo365.test1.util.LogUtils;
//import io.swagger.annotations.Api;
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
// * 煅后焦controller
// */
//@Api(value = "煅后焦控制层",description = "煅后焦控制层,之后要弃用,改为统一goods-controller")
//@RestController
//@RequestMapping("/calcinedCoke")
//public class CalcinedCokeController {
//
//    private String instance = "煅后焦";
//
//    @Autowired
//    private GoodsCommonService goodsCommonService;
//
//    @Resource
//    private CalcinedCokeMapper calcinedCokeMapper;
//
//    @Autowired
//    private LogUtils logUtils;
//
//    /**
//     * 分页查询获取数据
//     * @param calcinedCoke
//     * @param page
//     * @param rows
//     * @return
//     */
//    @RequestMapping("/selectSelective")
//    public Map<String, Object> selectSelective(CalcinedCoke calcinedCoke, Integer page, Integer rows){
//        goodsCommonService.setGoodsTypeMapper(calcinedCokeMapper);
//        Map<String, Object> map = new HashMap<String, Object>();
//        PageHelper.startPage(page, rows);
//        List<Goods> list = goodsCommonService.getBySelective(calcinedCoke);
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
//    public Integer insertSelective(CalcinedCoke calcinedCoke) {
//        goodsCommonService.setGoodsTypeMapper(calcinedCokeMapper);
//        int code = goodsCommonService.addBySelective(calcinedCoke);
////        logUtils.whichCodeIsOK(null,code, LogEnum.ADD_ACTION.toString(), instance);
//        return code;
//    }
//
//    /*动态更新数据*/
//    @RequestMapping("/updateByPrimaryKeySelective")
//    public Integer updateByPrimaryKeySelective(CalcinedCoke calcinedCoke) {
//        goodsCommonService.setGoodsTypeMapper(calcinedCokeMapper);
//        int code = goodsCommonService.updateBySelective(calcinedCoke);
////        logUtils.whichCodeIsOK(null,code, LogEnum.UPDATE_ACTION.toString(), instance);
//        return code;
//    }
//
//    /*删除数据*/
//    @RequestMapping("/deleteByPrimaryKey")
//    public Integer deleteByPrimaryKey(Long id) {
//        goodsCommonService.setGoodsTypeMapper(calcinedCokeMapper);
//        int code = goodsCommonService.delete(id);
////        logUtils.whichCodeIsOK(null,code,LogEnum.DELETE_ACTION.toString(),instance);
//        return code;
//    }
//
//    /*批量删除*/
//    @RequestMapping("/deleteBatchByPKs")
//    public Integer deleteBatch(@RequestParam(value = "ids[]") Long[] ids) {
//        goodsCommonService.setGoodsTypeMapper(calcinedCokeMapper);
//        int code = goodsCommonService.deleteBatchByPKs(ids);
////        logUtils.whichCodeIsOK(null,code,LogEnum.DELETE_ACTION.toString(),instance);
//        return code;
//    }
//
//    @RequestMapping("/selectAll")
//    public List<Goods> selectAll(){
//        goodsCommonService.setGoodsTypeMapper(calcinedCokeMapper);
//        List<Goods> all = goodsCommonService.getAll();
//        int code = 0;
////        logUtils.whichCodeIsOK(all,code,LogEnum.SEARCH_ACTION.toString(),instance);
//        return all;
//    }
//
//}
