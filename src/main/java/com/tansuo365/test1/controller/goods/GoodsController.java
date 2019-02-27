package com.tansuo365.test1.controller.goods;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tansuo365.test1.bean.goods.Anode;
import com.tansuo365.test1.bean.goods.CalcinedCoke;
import com.tansuo365.test1.bean.goods.MAsphalt;
import com.tansuo365.test1.bean.goods.PetroleumCoke;
import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.bean.log.UserType;
import com.tansuo365.test1.bean.member.Member;
import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.mapper.goods.AnodeMapper;
import com.tansuo365.test1.mapper.goods.CalcinedCokeMapper;
import com.tansuo365.test1.mapper.goods.MAsphaltMapper;
import com.tansuo365.test1.mapper.goods.PetroleumCokeMapper;
import com.tansuo365.test1.service.goods.GoodsCommonService;
import com.tansuo365.test1.util.LogUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "货品信息CRUD公用控制层", description = "货品信息CRUD")
@RestController
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
    private LogUtils logUtils;


    /**
     * 动态获取goods数据
     *
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
    public Map<String, Object> selectSelective(HttpSession session, @PathVariable String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode, Integer page, Integer rows) throws IllegalAccessException, InstantiationException {
        Map<String, Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page, rows);
        List<Goods> list = goodsCommonService.getBySelective(goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        logUtils.doLog(list, 0, LogEnum.SEARCH_ACTION, goodsType, session);
        return map;

    }

    /**
     * TODO 在加入数据时,如果是石油焦,需要进行grade字段的触发更新
     *
     * @param goodsType
     * @param petroleumCoke
     * @param calcinedCoke
     * @param mAsphalt
     * @param anode
     * @return
     */
    @RequestMapping("/insertSelective")
    public Integer insertSelective(HttpSession session, @PathVariable String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode) throws IllegalAccessException, InstantiationException {
        int code = goodsCommonService.addBySelective(goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
        logUtils.doLog(null, code, LogEnum.SEARCH_ACTION, goodsType, session);
        return code;

    }

    /**
     * 动态更新数据 TODO 同样的,如果是石油焦,则需要判定sulfur字段,再进行grade字段的更新.
     *
     * @param goodsType
     * @param petroleumCoke
     * @param calcinedCoke
     * @param mAsphalt
     * @param anode
     * @return
     */
    @RequestMapping("updateByPKSelective")
    public Integer updateByPKSelective(HttpSession session, @PathVariable String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode) throws IllegalAccessException, InstantiationException {
        int code = goodsCommonService.updateBySelective(goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
        logUtils.doLog(null, code, LogEnum.SEARCH_ACTION, goodsType, session);
        return code;
    }

    /**
     * 根据主键删除数据
     *
     * @param goodsType
     * @param id
     * @return
     */
    @RequestMapping("/deleteByPK")
    public Integer delByPK(HttpSession session, @PathVariable String goodsType, Long id) throws IllegalAccessException, InstantiationException {
        goodsTypeJudger(goodsType, null, null, null, null);
        int code = goodsCommonService.delete(id);
        logUtils.doLog(null, code, LogEnum.SEARCH_ACTION, goodsType, session);
        return code;
    }

    /**
     * 批量删除
     *
     * @param goodsType
     * @param ids
     * @return
     */
    @RequestMapping("/deleteBatchByPKs")
    public Integer delBatch(HttpSession session, @PathVariable String goodsType, @RequestParam(value = "ids[]") Long[] ids) throws IllegalAccessException, InstantiationException {
        goodsTypeJudger(goodsType, null, null, null, null);
        int code = goodsCommonService.deleteBatchByPKs(ids);
        logUtils.doLog(null, code, LogEnum.SEARCH_ACTION, goodsType, session);
        return code;
    }

    /**
     * TEST
     *
     * @param goodsType
     * @param petroleumCoke
     * @param calcinedCoke
     * @param mAsphalt
     * @param anode
     * @return
     */
    @RequestMapping(value = "/testselectSelective")
    public List<Goods> testselectSelective(HttpSession session, @PathVariable String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode) throws IllegalAccessException, InstantiationException {
        System.out.println("goodsType:" + goodsType);
        List<Goods> list = goodsCommonService.getBySelective(goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
        logUtils.doLog(list, 0, LogEnum.SEARCH_ACTION, goodsType, session);
        return list;
    }

    /**
     * 无差别选择全部指定货品信息(针对ECharts使用,前端用户,如果为null则返回null)
     *
     * @param goodsType
     * @return
     */
    @RequestMapping("/selectGoodsByType")
    public List<Goods> selectAll(HttpSession session, @PathVariable String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode) throws IllegalAccessException, InstantiationException {
        Member currentMember = (Member) session.getAttribute("currentMember");
        if (currentMember == null) {
            return null;
        } else {
            List<Goods> list = goodsCommonService.getBySelective(goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
            logUtils.doLog(list, 0, LogEnum.SEARCH_ACTION, goodsType, session);
            return list;
        }
    }


    private Goods goodsTypeJudger(String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode) {
        switch (goodsType) {
            case PETROLEUM_COKE:

                String s_sulfur = petroleumCoke.getS_sulfur();
                String s_ash = petroleumCoke.getS_ash();
                String s_volatile_matter = petroleumCoke.getS_volatile_matter();
                String s_wdr = petroleumCoke.getS_wdr();
                String s_vanadium = petroleumCoke.getS_vanadium();
                String s_density = petroleumCoke.getS_density();
                String s_coke_content = petroleumCoke.getS_coke_content();
                String s_today_price = petroleumCoke.getS_today_price();
                checkIndexParams(petroleumCoke, s_sulfur, s_ash, s_volatile_matter, s_wdr, s_vanadium,
                        s_density, s_coke_content, s_today_price);

                goodsCommonService.setGoodsTypeMapper(petroleumCokeMapper);
                return petroleumCoke;
            case CALCINED_COKE:

                String s_sulfur1 = calcinedCoke.getS_sulfur();
                String s_ash1 = calcinedCoke.getS_ash();
                String s_volatile_matter1 = calcinedCoke.getS_volatile_matter();
                String s_water = calcinedCoke.getS_water();
                String s_density1 = calcinedCoke.getS_density();
                String s_p_resistivity = calcinedCoke.getS_p_resistivity();
                String s_vanadium1 = calcinedCoke.getS_vanadium();
                String s_granularity = calcinedCoke.getS_granularity();
                String s_today_price1 = calcinedCoke.getS_today_price();
                checkIndexParams1(calcinedCoke,s_sulfur1,s_ash1,s_volatile_matter1,
                        s_water,s_density1, s_p_resistivity,s_vanadium1,s_granularity,s_today_price1);

                goodsCommonService.setGoodsTypeMapper(calcinedCokeMapper);
                return calcinedCoke;
            case MASPHALT:

                String s_softening_point = mAsphalt.getS_softening_point();
                String s_toluene = mAsphalt.getS_toluene();
                String s_quinoline = mAsphalt.getS_quinoline();
                String s_beta_resin = mAsphalt.getS_beta_resin();
                String s_coking_value = mAsphalt.getS_coking_value();
                String s_ash2 = mAsphalt.getS_ash();
                String s_today_price2 = mAsphalt.getS_today_price();
                checkIndexParams2(mAsphalt,s_softening_point,s_toluene,s_quinoline,s_beta_resin,
                        s_coking_value,s_ash2,s_today_price2);

                goodsCommonService.setGoodsTypeMapper(mAsphaltMapper);
                return mAsphalt;
            case ANODE:

                checkIndexParams3(anode,
                anode.getS_e_density(),
                anode.getS_true_density(),
                anode.getS_compressive(),
                anode.getS_carbon(),
                anode.getS_flexural(),
                anode.getS_room(),
                anode.getS_thermal(),
                anode.getS_ash(),
                anode.getS_size(),
                anode.getS_bowl_sum(),
                anode.getS_bowl_distance(),
                anode.getS_in_diameter(),
                anode.getS_out_diameter(),
                anode.getS_slot(),
                anode.getS_today_price());

                goodsCommonService.setGoodsTypeMapper(anodeMapper);
                return anode;
        }
        return null;
//        if(goodsType.equals(PETROLEUM_COKE)){
//
//        }
    }


    private void checkIndexParams(PetroleumCoke petroleumCoke, String s_sulfur, String s_ash, String s_v_matter, String s_wdr, String s_vanadium
            , String s_density, String s_c_content, String s_price) {

        petroleumCoke.setSearchParams(
                columnTextTranslate(s_sulfur),
                columnTextTranslate(s_ash),
                columnTextTranslate(s_v_matter),
                columnTextTranslate(s_wdr),
                columnTextTranslate(s_vanadium),
                columnTextTranslate(s_density),
                columnTextTranslate(s_c_content),
                columnTextTranslate(s_price)
        );

    }

    private void checkIndexParams1(CalcinedCoke calcinedCoke, String s_sulfur, String s_ash, String s_v_matter,
                                   String s_water, String s_density, String s_p_resistivity, String s_vanadium,
                                   String s_granularity, String s_price) {
        calcinedCoke.setSearchParams(
                columnTextTranslate(s_sulfur),
                columnTextTranslate(s_ash),
                columnTextTranslate(s_v_matter),
                columnTextTranslate(s_water),
                columnTextTranslate(s_density),
                columnTextTranslate(s_p_resistivity),
                columnTextTranslate(s_vanadium),
                columnTextTranslate(s_granularity),
                columnTextTranslate(s_price)
        );

    }

    private void checkIndexParams2(MAsphalt mAsphalt,String s_spoint,String s_toluene,
                                   String s_quinoline,String s_beta_resin,String s_c_value,
                                   String s_ash,String s_price){
        mAsphalt.setSearchParams(
                columnTextTranslate(s_spoint),
                columnTextTranslate(s_toluene),
                columnTextTranslate(s_quinoline),
                columnTextTranslate(s_beta_resin),
                columnTextTranslate(s_c_value),
                columnTextTranslate(s_ash),
                columnTextTranslate(s_price)
        );
    }

    private void checkIndexParams3(Anode anode,String s_e_density,String s_true_density,
                                   String s_compressive,String s_carbon,String s_flexural,
                                   String s_room,String s_thermal,String s_ash,
                                   String s_size,String s_bowl_sum,String s_bowl_dis,
                                   String s_in_dia,String s_out_dia,String s_slot,
                                   String s_price){
        anode.setSearchParams(
                columnTextTranslate(s_e_density),
                columnTextTranslate(s_true_density),
                columnTextTranslate(s_compressive),
                columnTextTranslate(s_carbon),
                columnTextTranslate(s_flexural),
                columnTextTranslate(s_room),
                columnTextTranslate(s_thermal),
                columnTextTranslate(s_ash),
                columnTextTranslate(s_size),
                columnTextTranslate(s_bowl_sum),
                columnTextTranslate(s_bowl_dis),
                columnTextTranslate(s_in_dia),
                columnTextTranslate(s_out_dia),
                columnTextTranslate(s_slot),
                columnTextTranslate(s_price)
        );
    }


    private String getMathSymbol(String mathSymbol) {
        switch (mathSymbol) {
//            case "＝" : return "eq"; //equals
//            case "＜" : return "lt"; //less than
//            case "≤" : return  "le"; // less equals
//            case "＞" : return "bt"; // big than
//            case "≥" : return "be"; //big equals
            case "＝":
                return "="; //equals
            case "＜":
                return "<"; //less than
            case "≤":
                return "<="; // less equals
            case "＞":
                return ">"; // big than
            case "≥":
                return ">="; //big equals
            default:
                return "";
        }
    }

    private String columnTextTranslate(String columnText) {
        if (columnText != null && columnText != "") {
            System.out.println("columnText>>>   " + columnText);
            String[] columnTextArr = columnText.split(":");
            System.out.println(columnTextArr.length);
            //数组[0]是比较符号,[1]是第一个参数,[2]是第二个比较符号,[3]是第二个参数
            if (columnTextArr[1].equals("[null]") && columnTextArr[3].equals("[null]")) {
                System.err.println("没有填入任何值");
                return null;
            } else if (!columnTextArr[0].equals("[null]") && columnTextArr[2].equals("[null]")) {
                //只查询一个input (左侧) 情况1
                String mathSymbolLeft = getMathSymbol(columnTextArr[0].toString());
                String valueLeft = columnTextArr[1].toString();
                //如果情况1 value无值,则该字段也设定为null
                if (valueLeft.equals("[null]")) {
                    return null;
                } else {
                    System.out.println(mathSymbolLeft + ":" + valueLeft);
                    columnText = mathSymbolLeft + " " + valueLeft;
                    return columnText;
                }
            } else if (columnTextArr[0].equals("[null]") && !columnTextArr[2].equals("[null]")) {
                //只查询一个input (右侧,一般不会发生,因为左侧默认不会选null)
                String mathSymbolRight = getMathSymbol(columnTextArr[2].toString());
            } else if (!columnTextArr[0].equals("[null]") && !columnTextArr[2].equals("[null]")) {
                //两个都不为null,即设定了两个查询参数  情况2
                String mathSymbolLeft = getMathSymbol(columnTextArr[0].toString());
                String mathSymbolRight = getMathSymbol(columnTextArr[2].toString());
                String valueLeft = columnTextArr[1].toString();
                String valueRight = columnTextArr[3].toString();
                //如果valueL valueR 其中一个为null,则设定对应符号也为null
                if (valueLeft.equals("[null]") && !valueRight.equals("[null]")) {
                    columnText = mathSymbolRight + " " + valueRight;
                    return columnText;
                } else if (!valueLeft.equals("[null]") && valueRight.equals("[null]")) {
                    columnText = mathSymbolLeft + " " + valueLeft;
                    return columnText;
                } else {
                    columnText = mathSymbolLeft + " " + valueLeft + " and " + columnTextArr[4].replace("s_", "") + " " + mathSymbolRight + " " + valueRight;
                    return columnText;
                }
            }
        }
        return columnText;
    }
}
