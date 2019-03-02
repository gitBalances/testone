package com.tansuo365.test1.util;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 用于货品增删改查的工具类
 *
 * @Author ukzq
 */
@Component
public class GoodsUtils {

    @Autowired
    private GoodsCommonService goodsCommonService;

    final String PETROLEUM_COKE = "PetroleumCoke";
    final String CALCINED_COKE = "CalcinedCoke";
    final String MASPHALT = "MAsphalt";
    final String ANODE = "Anode";
    @Resource
    private PetroleumCokeMapper petroleumCokeMapper;
    @Resource
    private CalcinedCokeMapper calcinedCokeMapper;
    @Resource
    private MAsphaltMapper mAsphaltMapper;
    @Resource
    private AnodeMapper anodeMapper;


    public Goods goodsTypeJudger(String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode) {
        switch (goodsType) {
            case PETROLEUM_COKE:
                goodsCommonService.setGoodsTypeMapper(petroleumCokeMapper);
                if (petroleumCoke == null) {
                    return null;
                }
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

                PetroleumCoke petroleumCokeWithGrade = PetroleumCokeGradeUtil.setGradeBySulfur(petroleumCoke);

                return petroleumCokeWithGrade;
            case CALCINED_COKE:
                goodsCommonService.setGoodsTypeMapper(calcinedCokeMapper);
                if (calcinedCoke == null) {
                    return null;
                }
                String s_sulfur1 = calcinedCoke.getS_sulfur();
                String s_ash1 = calcinedCoke.getS_ash();
                String s_volatile_matter1 = calcinedCoke.getS_volatile_matter();
                String s_water = calcinedCoke.getS_water();
                String s_density1 = calcinedCoke.getS_density();
                String s_p_resistivity = calcinedCoke.getS_p_resistivity();
                String s_vanadium1 = calcinedCoke.getS_vanadium();
                String s_granularity = calcinedCoke.getS_granularity();
                String s_today_price1 = calcinedCoke.getS_today_price();
                checkIndexParams1(calcinedCoke, s_sulfur1, s_ash1, s_volatile_matter1,
                        s_water, s_density1, s_p_resistivity, s_vanadium1, s_granularity, s_today_price1);

                return calcinedCoke;
            case MASPHALT:
                goodsCommonService.setGoodsTypeMapper(mAsphaltMapper);
                if (mAsphalt == null) {
                    return null;
                }
                String s_softening_point = mAsphalt.getS_softening_point();
                String s_toluene = mAsphalt.getS_toluene();
                String s_quinoline = mAsphalt.getS_quinoline();
                String s_beta_resin = mAsphalt.getS_beta_resin();
                String s_coking_value = mAsphalt.getS_coking_value();
                String s_ash2 = mAsphalt.getS_ash();
                String s_today_price2 = mAsphalt.getS_today_price();
                checkIndexParams2(mAsphalt, s_softening_point, s_toluene, s_quinoline, s_beta_resin,
                        s_coking_value, s_ash2, s_today_price2);

                return mAsphalt;
            case ANODE:
                goodsCommonService.setGoodsTypeMapper(anodeMapper);
                if (anode == null) {
                    return null;
                }
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

    //煅后焦数据的转换
    private void checkIndexParams1(CalcinedCoke calcinedCoke, String s_sulfur, String s_ash, String s_v_matter,
                                   String s_water, String s_density, String s_p_resistivity, String s_vanadium,
                                   String s_granularity, String s_price) {
        //区间字段s_granularity
        //输入最小值,则查最小;输入最大值,则查最大,两边都查,则两边都进行查询

        calcinedCoke.setSearchParams(
                columnTextTranslate(s_sulfur),
                columnTextTranslate(s_ash),
                columnTextTranslate(s_v_matter),
                columnTextTranslate(s_water),
                columnTextTranslate(s_density),
                columnTextTranslate(s_p_resistivity),
                columnTextTranslate(s_vanadium),
                columnTextTranslateRegion(s_granularity),//区间
                columnTextTranslate(s_price)
        );

    }

    private void checkIndexParams2(MAsphalt mAsphalt, String s_spoint, String s_toluene,
                                   String s_quinoline, String s_beta_resin, String s_c_value,
                                   String s_ash, String s_price) {
        //区间字段s_spoint,s_toluene,s_quinoline
        //输入最小值,则查最小;输入最大值,则查最大,两边都查,则两边都进行查询
        mAsphalt.setSearchParams(
                columnTextTranslateRegion(s_spoint),//区间
                columnTextTranslateRegion(s_toluene),//区间
                columnTextTranslateRegion(s_quinoline),//区间
                columnTextTranslate(s_beta_resin),
                columnTextTranslate(s_c_value),
                columnTextTranslate(s_ash),
                columnTextTranslate(s_price)
        );
    }

    private void checkIndexParams3(Anode anode, String s_e_density, String s_true_density,
                                   String s_compressive, String s_carbon, String s_flexural,
                                   String s_room, String s_thermal, String s_ash,
                                   String s_size, String s_bowl_sum, String s_bowl_dis,
                                   String s_in_dia, String s_out_dia, String s_slot,
                                   String s_price) {
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
            if ("[null]".equals(columnTextArr[1]) && "[null]".equals(columnTextArr[3])) {
                System.err.println("没有填入任何值");
                return null;
            } else if (!"[null]".equals(columnTextArr[0]) && "[null]".equals(columnTextArr[2])) {
                //只查询一个input (左侧) 情况1
                String mathSymbolLeft = getMathSymbol(columnTextArr[0].toString());
                String valueLeft = columnTextArr[1].toString();
                //如果情况1 value无值,则该字段也设定为null
                if ("[null]".equals(valueLeft)) {
                    return null;
                } else {
                    System.out.println(mathSymbolLeft + ":" + valueLeft);
                    columnText = mathSymbolLeft + " " + valueLeft;
                    return columnText;
                }
            } else if ("[null]".equals(columnTextArr[0]) && !"[null]".equals(columnTextArr[2])) {
                //只查询一个input (右侧,一般不会发生,因为左侧默认不会选null)
                String mathSymbolRight = getMathSymbol(columnTextArr[2].toString());
            } else if (!"[null]".equals(columnTextArr[0]) && !"[null]".equals(columnTextArr[2])) {
                //两个都不为null,即设定了两个查询参数  情况2
                String mathSymbolLeft = getMathSymbol(columnTextArr[0].toString());
                String mathSymbolRight = getMathSymbol(columnTextArr[2].toString());
                String valueLeft = columnTextArr[1].toString();
                String valueRight = columnTextArr[3].toString();
                //如果valueL valueR 其中一个为null,则设定对应符号也为null
                if ("[null]".equals(valueLeft) && !"[null]".equals(valueRight)) {
                    columnText = mathSymbolRight + " " + valueRight;
                    return columnText;
                } else if (!"[null]".equals(valueLeft) && "[null]".equals(valueRight)) {
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


    //区间检索的字段判定
    private String columnTextTranslateRegion(String columnText) {
        if (columnText != null && columnText != "") {
            System.out.println("columnText>>>   " + columnText);
            String[] columnTextArr = columnText.split(":");
            System.out.println(columnTextArr.length);
            //数组[0]是比较符号,[1]是第一个参数,[2]是第二个比较符号,[3]是第二个参数
            if ("[null]".equals(columnTextArr[1]) && "[null]".equals(columnTextArr[3])) {
                System.err.println("没有填入任何值");
                return null;
            } else if (!"[null]".equals(columnTextArr[0]) && "[null]".equals(columnTextArr[2])) {
                //只查询一个input (左侧) 情况1
                String mathSymbolLeft = getMathSymbol(columnTextArr[0].toString());
                String valueLeft = columnTextArr[1].toString();
                //如果情况1 value无值,则该字段也设定为null
                if ("[null]".equals(valueLeft)) {
                    return null;
                } else {
                    System.out.println(mathSymbolLeft + ":" + valueLeft);
                    columnText = mathSymbolLeft + " " + valueLeft;
                    return columnText;
                }
            } else if ("[null]".equals(columnTextArr[0]) && !"[null]".equals(columnTextArr[2])) {
                //只查询一个input (右侧,一般不会发生,因为左侧默认不会选null)
                String mathSymbolRight = getMathSymbol(columnTextArr[2].toString());
            } else if (!"[null]".equals(columnTextArr[0]) && !"[null]".equals(columnTextArr[2])) {
                //两个都不为null,即设定了两个查询参数  情况2
                String mathSymbolLeft = getMathSymbol(columnTextArr[0].toString());
                String mathSymbolRight = getMathSymbol(columnTextArr[2].toString());
                String valueLeft = columnTextArr[1].toString();
                String valueRight = columnTextArr[3].toString();
                //如果valueL valueR 其中一个为null,则设定对应符号也为null
                if ("[null]".equals(valueLeft) && !"[null]".equals(valueRight)) {
                    columnText = "SUBSTRING_INDEX(" + columnTextArr[4].replace("s_", "") + ",'-',-1)" + mathSymbolRight + " " + valueRight;
                    return columnText;
                } else if (!"[null]".equals(valueLeft) && "[null]".equals(valueRight)) {
                    columnText = "SUBSTRING_INDEX(" + columnTextArr[4].replace("s_", "") + ",'-',1)" + mathSymbolLeft + " " + valueLeft;
                    return columnText;
                } else {
                    columnText = "SUBSTRING_INDEX(" + columnTextArr[4].replace("s_", "") + ",'-',1)" + mathSymbolLeft + " " + valueLeft
                            + " and SUBSTRING_INDEX(" + columnTextArr[4].replace("s_", "") + ",'-',-1) " + mathSymbolRight + " " + valueRight;
                    return columnText;
                }
            }
        }
        return columnText;
    }


}
