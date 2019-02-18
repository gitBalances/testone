package com.tansuo365.test1.mapper;

import com.tansuo365.test1.bean.MAsphalt;
import com.tansuo365.test1.bean.MAsphaltExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 改质沥青Mapper
 */
public interface MAsphaltMapper {
    long countByExample(MAsphaltExample example);

    int deleteByExample(MAsphaltExample example);

    //删除
    int deleteByPrimaryKey(Long id);

    //批量删除 new
    int deleteBatchByPKArr(Long[] ids);

    int insert(MAsphalt record);

    //动态插入 must
    int insertSelective(MAsphalt record);

    //批量插入 new
    int insertBatch(List<MAsphalt> list);

    List<MAsphalt> selectByExample(MAsphaltExample example);

    //动态选择 new
    List<MAsphalt> selectMAsphaltSelective(MAsphalt mAsphalt);

    //选取全部 new
    List<MAsphalt> selectAllMAsphalt();

    MAsphalt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MAsphalt record, @Param("example") MAsphaltExample example);

    int updateByExample(@Param("record") MAsphalt record, @Param("example") MAsphaltExample example);

    //动态更新 must
    int updateByPrimaryKeySelective(MAsphalt record);

    int updateByPrimaryKey(MAsphalt record);
}