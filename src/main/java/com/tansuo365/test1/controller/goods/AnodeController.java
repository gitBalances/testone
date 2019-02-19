package com.tansuo365.test1.controller.goods;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tansuo365.test1.bean.goods.Anode;
import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.mapper.goods.AnodeMapper;
import com.tansuo365.test1.service.goods.GoodsCommonService;
import com.tansuo365.test1.util.CodeJudgerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 煅后焦controller
 */
@RestController
@RequestMapping("/anode")
public class AnodeController {

    private String instance = "阳极";

    @Autowired
    private GoodsCommonService goodsCommonService;

    @Resource
    private AnodeMapper anodeMapper;

    @Autowired
    private CodeJudgerUtils codeJudgerUtils;

    @RequestMapping("/selectSelective")
    public Map<String, Object> selectSelective(Anode anode, Integer page, Integer rows){
        goodsCommonService.setGoodsTypeMapper(anodeMapper);
        Map<String, Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page, rows);
        List<Goods> list = goodsCommonService.getBySelective(anode);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        int code = 0;
        codeJudgerUtils.whichCodeIsOK(list,code,LogEnum.SEARCH_ACTION.toString(),instance);
        return map;
    }

    /*动态插入数据*/
    @RequestMapping("/insertSelective")
    public Integer insertSelective(Anode anode) {
        goodsCommonService.setGoodsTypeMapper(anodeMapper);
        int code = goodsCommonService.addBySelective(anode);
        codeJudgerUtils.whichCodeIsOK(null,code, LogEnum.ADD_ACTION.toString(), instance);
        return code;
    }

    /*动态更新数据*/
    @RequestMapping("/updateByPrimaryKeySelective")
    public Integer updateByPrimaryKeySelective(Anode anode) {
        goodsCommonService.setGoodsTypeMapper(anodeMapper);
        int code = goodsCommonService.updateBySelective(anode);
        codeJudgerUtils.whichCodeIsOK(null,code, LogEnum.UPDATE_ACTION.toString(), instance);
        return code;
    }

    /*删除数据*/
    @RequestMapping("/deleteByPrimaryKey")
    public Integer deleteByPrimaryKey(Long id) {
        goodsCommonService.setGoodsTypeMapper(anodeMapper);
        int code = goodsCommonService.delete(id);
        codeJudgerUtils.whichCodeIsOK(null,code,LogEnum.DELETE_ACTION.toString(),instance);
        return code;
    }

    /*批量删除*/
    @RequestMapping("/deleteBatchByPKs")
    public Integer deleteBatch(@RequestParam(value = "ids[]") Long[] ids) {
        goodsCommonService.setGoodsTypeMapper(anodeMapper);
        int code = goodsCommonService.deleteBatchByPKs(ids);
        codeJudgerUtils.whichCodeIsOK(null,code,LogEnum.DELETE_ACTION.toString(),instance);
        return code;
    }


    @RequestMapping("/selectAll")
    public List<Goods> selectAll(){
        goodsCommonService.setGoodsTypeMapper(anodeMapper);
        List<Goods> all = goodsCommonService.getAll();
        int code = 0;
        codeJudgerUtils.whichCodeIsOK(all,code,LogEnum.SEARCH_ACTION.toString(),instance);
        return all;
    }



}
