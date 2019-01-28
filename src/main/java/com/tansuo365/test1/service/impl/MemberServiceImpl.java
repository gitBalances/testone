package com.tansuo365.test1.service.impl;

import com.tansuo365.test1.bean.Member;
import com.tansuo365.test1.bean.MemberExample;
import com.tansuo365.test1.mapper.MemberMapper;
import com.tansuo365.test1.service.MemberRoleService;
import com.tansuo365.test1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;
    @Autowired
    private MemberRoleService memberRoleService;

    @Override
    public String getPassword(String name) {
        Member member = getByName(name);
        if(null == member){
            return null;
        }
        return member.getPassword();
    }

    @Override
    public Member getByName(String name) {
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(name);
        List<Member> members = memberMapper.selectByExample(example);
        if(members.isEmpty()){
            return null;
        }
        return members.get(0);
    }

    @Override
    public List<Member> list() {
        MemberExample example = new MemberExample();
        example.setOrderByClause("id desc");
        return memberMapper.selectByExample(example);
    }

    @Override
    public void add(Member member) {
        memberMapper.insert(member);
    }

    @Override
    public void delete(Long id) {
        memberMapper.deleteByPrimaryKey(id);
        memberRoleService.deleteByMember(id);
    }

    @Override
    public Member get(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Member member) {
        memberMapper.updateByPrimaryKeySelective(member);
    }
}
