package com.tansuo365.test1.mapper;

import com.tansuo365.test1.bean.Anode;
import com.tansuo365.test1.bean.AnodeExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 阳极Mapper
 */
public interface AnodeMapper {
    long countByExample(AnodeExample example);

    int deleteByExample(AnodeExample example);

    //删除
    int deleteByPrimaryKey(Integer id);

    //批量删除 new
    int deleteBatchByPKArr(Long[] ids);

    int insert(Anode record);

    //动态插入 must
    int insertSelective(Anode anode);

    //批量动态插入 new
    int insertBatch(List<Anode> list);

    List<Anode> selectByExample(AnodeExample example);

    //动态选择 new
    List<Anode> selectAnodeSelective(Anode anode);

    //选取全部 new
    List<Anode> selectAllAnode();

    Anode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Anode record, @Param("example") AnodeExample example);

    int updateByExample(@Param("record") Anode record, @Param("example") AnodeExample example);

    //动态更新 must
    int updateByPrimaryKeySelective(Anode record);

    int updateByPrimaryKey(Anode record);
}