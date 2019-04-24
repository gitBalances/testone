package com.tansuo365.test1.mapper;

import com.tansuo365.test1.entity.TaskCronJob;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskCronJobMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(TaskCronJob record);

    TaskCronJob selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskCronJob record);

}