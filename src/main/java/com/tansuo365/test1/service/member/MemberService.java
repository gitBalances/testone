package com.tansuo365.test1.service.member;

import com.tansuo365.test1.bean.member.Member;

import java.util.List;
import java.util.Map;

public interface MemberService {

    Integer addNewMember(Member member);

    List<Member> getMemberSelective(Member member);

    Integer delMemberById(Long id);

    Member getMemberById(Long id);

    Member getMemberByName(String username);

    Integer getMemberLevelById(Long id);

    Integer updateMemberSelective(Member member);

    Map<String, Object> updatePasswordBySalt(String password);

}
