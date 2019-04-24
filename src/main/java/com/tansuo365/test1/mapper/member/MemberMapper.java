package com.tansuo365.test1.mapper.member;

import com.tansuo365.test1.bean.member.Member;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {

    int deleteByPrimaryKey(Long id);

    int deleteBatchByPKArr(Long[] ids);

    int insertSelective(Member member);

    List<Member> selectInstanceSelective(Member member);

    Member selectInstanceByName(String username);

    Member selectByPrimaryKey(Long id);

    int selectMemberLevelById(Long id);

    int updateByPrimaryKeySelective(Member member);

}