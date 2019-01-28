package com.tansuo365.test1.service;

import com.tansuo365.test1.bean.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberService {

    public String getPassword(String name);

    public Member getByName(String name);

    public List<Member> list();

    public void add(Member member);

    public void delete(Long id);

    public Member get(Long id);

    public void update(Member member);

}
