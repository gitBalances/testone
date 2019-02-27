package com.tansuo365.test1.mapper.log;

import com.tansuo365.test1.entity.LogUsers;

import java.util.List;

public interface ILogCommonMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(LogUsers logUsers);

    int insertSelective(LogUsers logUsers);

    List<LogUsers> getBySelective(LogUsers logUsers);

    LogUsers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogUsers logUsers);

    int updateByPrimaryKey(LogUsers logUsers);
    
}
