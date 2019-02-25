package com.tansuo365.test1.controller.goods;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tansuo365.test1.bean.goods.Anode;
import com.tansuo365.test1.bean.goods.CalcinedCoke;
import com.tansuo365.test1.bean.goods.MAsphalt;
import com.tansuo365.test1.bean.goods.PetroleumCoke;
import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.mapper.goods.AnodeMapper;
import com.tansuo365.test1.mapper.goods.CalcinedCokeMapper;
import com.tansuo365.test1.mapper.goods.MAsphaltMapper;
import com.tansuo365.test1.mapper.goods.PetroleumCokeMapper;
import com.tansuo365.test1.service.goods.GoodsCommonService;
import com.tansuo365.test1.util.CodeJudgerUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "货品信息CRUD公用控制层",description = "货品信息CRUD")
@RestController
//@RequestMapping(value = {"petroleumCoke","calcinedCoke","mAsphalt","anode"})
@RequestMapping("/goods/{goodsType}")
public class GoodsController {

    @Autowired
    private GoodsCommonService goodsCommonService;

    final String PETROLEUM_COKE = "PetroleumCoke";
    final String CALCINED_COKE = "CalcinedCoke";
    final String MASPHALT = "MAsphalt";
    final String ANODE = "Anode";

    @Resource
    private PetroleumCokeMapper petroleumCokeMapper;//石油焦
    @Resource
    private CalcinedCokeMapper calcinedCokeMapper;//煅后焦
    @Resource
    private MAsphaltMapper mAsphaltMapper;//沥青
    @Resource
    private AnodeMapper anodeMapper;//阳极


    @Autowired
    private CodeJudgerUtils codeJudgerUtils;


    /**
     * 动态获取goods数据
     * @param goodsType
     * @param petroleumCoke
     * @param calcinedCoke
     * @param mAsphalt
     * @param anode
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/selectSelective")
    public Map<String, Object> selectSelective(@PathVariable String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode, Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page, rows);
        List<Goods> list = goodsCommonService.getBySelective(goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        int code = 0;
        //TODO 加入日志记录
//        codeJudgerUtils.whichCodeIsOK(list, code, LogEnum.SEARCH_ACTION.toString(), instance);
        return map;

    }

    /**
     * TODO 在加入数据时,如果是石油焦,需要进行grade字段的触发更新
     * @param goodsType
     * @param petroleumCoke
     * @param calcinedCoke
     * @param mAsphalt
     * @param anode
     * @return
     */
    @RequestMapping("/insertSelective")
    public Integer insertSelective(@PathVariable String goodsType,PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode){
        int code = goodsCommonService.addBySelective(goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
        //TODO 加入日志记录
        return code;

    }

    /**
     * 动态更新数据 TODO 同样的,如果是石油焦,则需要判定sulfur字段,再进行grade字段的更新.
     * @param goodsType
     * @param petroleumCoke
     * @param calcinedCoke
     * @param mAsphalt
     * @param anode
     * @return
     */
    @RequestMapping("updateByPKSelective")
    public Integer updateByPKSelective(@PathVariable String goodsType,PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode){
        int code = goodsCommonService.updateBySelective(goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
        //TODO 加入日志记录
        return code;
    }

    /**
     * 根据主键删除数据
     * @param goodsType
     * @param id
     * @return
     */
    @RequestMapping("/deleteByPK")
    public Integer delByPK(@PathVariable String goodsType,Long id){
        goodsTypeJudger(goodsType,null,null,null,null);
        int code = goodsCommonService.delete(id);
        //TODO 加入日志记录
        return code;
    }

    /**
     * 批量删除
     * @param goodsType
     * @param ids
     * @return
     */
    @RequestMapping("/deleteBatchByPK")
    public Integer delBatch(@PathVariable String goodsType,@RequestParam(value = "ids[]") Long[] ids){
        goodsTypeJudger(goodsType,null,null,null,null);
        int code = goodsCommonService.deleteBatchByPKs(ids);
        //TODO 加入日志记录
        return code;
    }

    /**
     * TEST
     * @param goodsType
     * @param petroleumCoke
     * @param calcinedCoke
     * @param mAsphalt
     * @param anode
     * @return
     */
    @RequestMapping(value = "/testselectSelective")
    public List<Goods> testselectSelective(@PathVariable String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode) {
        System.out.println("goodsType:"+goodsType);
        List<Goods> list = goodsCommonService.getBySelective(goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
//        codeJudgerUtils.whichCodeIsOK(list,code,LogEnum.SEARCH_ACTION.toString(),instance);
        return list;
    }

    /**
     * 无差别选择全部指定货品信息(针对ECharts使用)
     * @param goodsType
     * @return
     */
    @RequestMapping("/selectGoodsByType")
    public List<Goods> selectAll(@PathVariable String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode) {
        List<Goods> list = goodsCommonService.getBySelective(goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
//        goodsTypeJudger(goodsType,goods);
        List<Goods> all = goodsCommonService.getAll();
        return list;
    }


    private Goods goodsTypeJudger(String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode) {
        switch (goodsType) {
            case PETROLEUM_COKE:
                goodsCommonService.setGoodsTypeMapper(petroleumCokeMapper);
                return petroleumCoke;
            case CALCINED_COKE:
                goodsCommonService.setGoodsTypeMapper(calcinedCokeMapper);
                return calcinedCoke;
            case MASPHALT:
                goodsCommonService.setGoodsTypeMapper(mAsphaltMapper);
                return mAsphalt;
            case ANODE:
                goodsCommonService.setGoodsTypeMapper(anodeMapper);
                return anode;
        }
        return null;
//        if(goodsType.equals(PETROLEUM_COKE)){
//
//        }
    }

}
