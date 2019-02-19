//package com.tansuo365.test1.service.user.impl;
//
//import com.tansuo365.test1.unused.Member;
//import com.tansuo365.test1.unused.MemberExample;
//import com.tansuo365.test1.unused.MemberMapper;
//import com.tansuo365.test1.unused.MemberRoleService;
//import com.tansuo365.test1.unused.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@Service
//public class MemberServiceImpl implements MemberService {
//
//    @Resource
//    private MemberMapper memberMapper;
//    @Autowired
//    private MemberRoleService memberRoleService;
//
//    @Override
//    public String getPassword(String name) {
//        Member member = getByName(name);
//        if (null == member) {
//            return null;
//        }
//        return member.getPassword();
//    }
//
//    @Override
//    public Member getByName(String username) {
//        MemberExample example = new MemberExample();
//        example.createCriteria().andUsernameEqualTo(username);
//        List<Member> members = memberMapper.selectByExample(example);
//        if (members.isEmpty()) {
//            return null;
//        }
//        return members.get(0);
//    }
//
//    @Override
//    public Member getMemberByName(String username){
//        Member member = new Member();
//        member.setUsername(username);
//        List<Member> members = memberMapper.selectMemberSelective(member);
//        return members.get(0);
//    }
//
//
//    @Override
//    public List<Member> list() {
//        MemberExample example = new MemberExample();
//        example.setOrderByClause("id desc");
//        return memberMapper.selectByExample(example);
//    }
//
//    @Override
//    public void add(Member member) {
//        memberMapper.insert(member);
//    }
//
//    @Override
//    public void delete(Long id) {
//        memberMapper.deleteByPrimaryKey(id);
//        memberRoleService.deleteByMember(id);
//    }
//
//    @Override
//    public Member get(Long id) {
//        return memberMapper.selectByPrimaryKey(id);
//    }
//
//    @Override
//    public void update(Member member) {
//        memberMapper.updateByPrimaryKeySelective(member);
//    }
//
//}
