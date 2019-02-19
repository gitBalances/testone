package com.tansuo365.test1.mapper;

import com.tansuo365.test1.bean.log.LogUser;
import com.tansuo365.test1.bean.log.LogUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogUserMapper {
    long countByExample(LogUserExample example);

    int deleteByExample(LogUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LogUser record);

    int insertSelective(LogUser record);

    List<LogUser> selectByExample(LogUserExample example);

    List<LogUser> getBySelective(LogUser logUser);

    LogUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LogUser record, @Param("example") LogUserExample example);

    int updateByExample(@Param("record") LogUser record, @Param("example") LogUserExample example);

    int updateByPrimaryKeySelective(LogUser record);

    int updateByPrimaryKey(LogUser record);
}