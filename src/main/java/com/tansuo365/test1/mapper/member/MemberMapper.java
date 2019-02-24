package com.tansuo365.test1.mapper.member;

import com.tansuo365.test1.bean.member.Member;
import com.tansuo365.test1.bean.member.MemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {

    long countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Member record);

    int insertSelective(Member member);

    List<Member> selectByExample(MemberExample example);

    List<Member> selectInstanceSelective(Member member);

    Member selectInstanceByName(String username);

//    Member selectInstanceByNameAndPWD(String username,String password);

    Member selectByPrimaryKey(Long id);

    int selectMemberLevelById(Long id);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member member);

    int updateByPrimaryKey(Member record);
}