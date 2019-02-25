package com.tansuo365.test1.mapper.goods;

import com.tansuo365.test1.entity.Goods;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

//货品Mapper总接口
public interface IGoodsCommonMapper {
//    long countByExample(CalcinedCokeExample example);
//    int deleteByExample(CalcinedCokeExample example);

    //删除
    int deleteByPrimaryKey(Long id);

    //批量删除
    int deleteBatchByPKArr(Long[] ids);

    int insert(Goods goods);

    //动态插入 must
    int insertSelective(Goods goods);

    //批量插入 new
    int insertBatch(List<Goods> list);

//    List<CalcinedCoke> selectByExample(CalcinedCokeExample example);

    //动态选择 new
    List<Goods> selectGoodsSelective(Goods goods);

    //选取全部 new
    List<Goods> selectAll();

    //根据货品类型选择全部
    List<Goods> selectAllByTypeForECharts(Goods goods);

    //根据PK获取货品实例
    Goods selectByPrimaryKey(Long id);

//    int updateByExampleSelective(@Param("record") CalcinedCoke record, @Param("example") CalcinedCokeExample example);

//    int updateByExample(@Param("record") CalcinedCoke record, @Param("example") CalcinedCokeExample example);

    //动态更新 must
    int updateByPrimaryKeySelective(Goods goods);

    int updateByPrimaryKey(Goods goods);
}
