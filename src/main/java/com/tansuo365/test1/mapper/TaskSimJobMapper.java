package com.tansuo365.test1.mapper;

import com.tansuo365.test1.entity.TaskSimJob;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskSimJobMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(TaskSimJob record);

    TaskSimJob selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskSimJob record);

}