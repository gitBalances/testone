package com.tansuo365.test1.mapper.member;

import java.util.List;

import com.tansuo365.test1.bean.log.LogMember;
import com.tansuo365.test1.bean.log.LogMemberExample;
import org.apache.ibatis.annotations.Param;

public interface LogMemberMapper {

    long countByExample(LogMemberExample example);

    int deleteByExample(LogMemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LogMember record);

    int insertSelective(LogMember record);

    List<LogMember> selectByExample(LogMemberExample example);

    LogMember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LogMember record, @Param("example") LogMemberExample example);

    int updateByExample(@Param("record") LogMember record, @Param("example") LogMemberExample example);

    int updateByPrimaryKeySelective(LogMember record);

    int updateByPrimaryKey(LogMember record);
}