package com.tansuo365.test1.mapper;

import com.tansuo365.test1.bean.PetroleumCoke;
import com.tansuo365.test1.bean.PetroleumCokeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PetroleumCokeMapper {
    //更改grade品级
    int updateGradeByPrimaryKey(PetroleumCoke petroleumCoke);

    long countByExample(PetroleumCokeExample example);

    int deleteByExample(PetroleumCokeExample example);

    //删除
    int deleteByPrimaryKey(Long id);

    //批量删除
    int deleteBatchByPKArr(Long[] ids);

    int insert(PetroleumCoke record);

    //动态插入
    int insertSelective(PetroleumCoke petroleumCoke);

    //批量动态插入
    int insertBatchSelective(List<PetroleumCoke> list);

    List<PetroleumCoke> selectByExample(PetroleumCokeExample example);

    //动态选择
    List<PetroleumCoke> selectPetroleumCokeSelective(PetroleumCoke petroleumCoke);

    //选取全部
    List<PetroleumCoke> selectAllPetroleumCoke();

    PetroleumCoke selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PetroleumCoke record, @Param("example") PetroleumCokeExample example);

    int updateByExample(@Param("record") PetroleumCoke record, @Param("example") PetroleumCokeExample example);

    //动态更新
    int updateByPrimaryKeySelective(PetroleumCoke record);

    int updateByPrimaryKey(PetroleumCoke record);
}