package com.tansuo365.test1.mapper;

import com.tansuo365.test1.entity.TaskSimJob;
import com.tansuo365.test1.entity.TaskSimJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskSimJobMapper {
    long countByExample(TaskSimJobExample example);

    int deleteByExample(TaskSimJobExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskSimJob record);

    int insertSelective(TaskSimJob record);

    List<TaskSimJob> selectByExample(TaskSimJobExample example);

    TaskSimJob selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskSimJob record, @Param("example") TaskSimJobExample example);

    int updateByExample(@Param("record") TaskSimJob record, @Param("example") TaskSimJobExample example);

    int updateByPrimaryKeySelective(TaskSimJob record);

    int updateByPrimaryKey(TaskSimJob record);
}