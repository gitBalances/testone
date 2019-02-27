package com.tansuo365.test1.controller.goods;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tansuo365.test1.bean.goods.MAsphalt;
import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.mapper.goods.MAsphaltMapper;
import com.tansuo365.test1.service.goods.GoodsCommonService;
import com.tansuo365.test1.util.LogUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 改质沥青controller
 */
@Api(value = "沥青控制层",description = "沥青控制层,之后要弃用,改为统一goods-controller")
@RestController
@RequestMapping("/mAsphalt")
public class MAsphaltController {

    private String instance = "改质沥青";

    @Autowired
    private GoodsCommonService goodsCommonService;

    @Resource
    private MAsphaltMapper mAsphaltMapper;

    @Autowired
    private LogUtils logUtils;

    @RequestMapping("/selectSelective")
    public Map<String, Object> selectSelective(MAsphalt mAsphalt, Integer page, Integer rows){
        goodsCommonService.setGoodsTypeMapper(mAsphaltMapper);
        Map<String, Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page, rows);
        List<Goods> list = goodsCommonService.getBySelective(mAsphalt);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        int code = 0;
//        logUtils.whichCodeIsOK(list,code,LogEnum.SEARCH_ACTION.toString(),instance);
        return map;
    }

    /*动态插入数据*/
    @RequestMapping("/insertSelective")
    public Integer insertSelective(MAsphalt mAsphalt) {
        goodsCommonService.setGoodsTypeMapper(mAsphaltMapper);
        int code = goodsCommonService.addBySelective(mAsphalt);
//        logUtils.whichCodeIsOK(null,code, LogEnum.ADD_ACTION.toString(), instance);
        return code;
    }

    /*动态更新数据*/
    @RequestMapping("/updateByPrimaryKeySelective")
    public Integer updateByPrimaryKeySelective(MAsphalt mAsphalt) {
        goodsCommonService.setGoodsTypeMapper(mAsphaltMapper);
        int code = goodsCommonService.updateBySelective(mAsphalt);
//        logUtils.whichCodeIsOK(null,code, LogEnum.UPDATE_ACTION.toString(), instance);
        return code;
    }

    /*删除数据*/
    @RequestMapping("/deleteByPrimaryKey")
    public Integer deleteByPrimaryKey(Long id) {
        goodsCommonService.setGoodsTypeMapper(mAsphaltMapper);
        int code = goodsCommonService.delete(id);
//        logUtils.whichCodeIsOK(null,code,LogEnum.DELETE_ACTION.toString(),instance);
        return code;
    }

    /*批量删除*/
    @RequestMapping("/deleteBatchByPKs")
    public Integer deleteBatch(@RequestParam(value = "ids[]") Long[] ids) {
        goodsCommonService.setGoodsTypeMapper(mAsphaltMapper);
        int code = goodsCommonService.deleteBatchByPKs(ids);
//        logUtils.whichCodeIsOK(null,code,LogEnum.DELETE_ACTION.toString(),instance);
        return code;
    }


    @RequestMapping("/selectAll")
    public List<Goods> selectAll(){
        goodsCommonService.setGoodsTypeMapper(mAsphaltMapper);
        List<Goods> all = goodsCommonService.getAll();
        int code = 0;
//        logUtils.whichCodeIsOK(all,code,LogEnum.SEARCH_ACTION.toString(),instance);
        return all;
    }



}
