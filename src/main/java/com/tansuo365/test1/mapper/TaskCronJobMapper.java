package com.tansuo365.test1.mapper;

import com.tansuo365.test1.entity.TaskCronJob;
import com.tansuo365.test1.entity.TaskCronJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskCronJobMapper {
    long countByExample(TaskCronJobExample example);

    int deleteByExample(TaskCronJobExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskCronJob record);

    int insertSelective(TaskCronJob record);

    List<TaskCronJob> selectByExample(TaskCronJobExample example);

    TaskCronJob selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskCronJob record, @Param("example") TaskCronJobExample example);

    int updateByExample(@Param("record") TaskCronJob record, @Param("example") TaskCronJobExample example);

    int updateByPrimaryKeySelective(TaskCronJob record);

    int updateByPrimaryKey(TaskCronJob record);
}