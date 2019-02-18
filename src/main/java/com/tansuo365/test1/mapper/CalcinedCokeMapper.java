package com.tansuo365.test1.mapper;

import com.tansuo365.test1.bean.CalcinedCoke;
import com.tansuo365.test1.bean.CalcinedCokeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 煅后焦Mapper
 */
public interface CalcinedCokeMapper {
    long countByExample(CalcinedCokeExample example);

    int deleteByExample(CalcinedCokeExample example);

    //删除
    int deleteByPrimaryKey(Long id);

    //批量删除
    int deleteBatchByPKArr(Long[] ids);

    int insert(CalcinedCoke record);

    //动态插入 must
    int insertSelective(CalcinedCoke calcinedCoke);

    //批量插入 new
    int insertBatch(List<CalcinedCoke> list);

    List<CalcinedCoke> selectByExample(CalcinedCokeExample example);

    //动态选择 new
    List<CalcinedCoke> selectCalcinedCokeSelective(CalcinedCoke calcinedCoke);

    //选取全部 new
    List<CalcinedCoke> selectAllCalcinedCoke();

    CalcinedCoke selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CalcinedCoke record, @Param("example") CalcinedCokeExample example);

    int updateByExample(@Param("record") CalcinedCoke record, @Param("example") CalcinedCokeExample example);

    //动态更新 must
    int updateByPrimaryKeySelective(CalcinedCoke record);

    int updateByPrimaryKey(CalcinedCoke record);
}