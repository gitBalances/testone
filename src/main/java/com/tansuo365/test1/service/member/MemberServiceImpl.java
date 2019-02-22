package com.tansuo365.test1.service.member;

import com.tansuo365.test1.bean.member.Member;
import com.tansuo365.test1.mapper.member.MemberMapper;
import com.tansuo365.test1.util.PasswordEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public Integer addNewMember(Member member) {
        return memberMapper.insertSelective(member);
    }

    @Override
    public List<Member> getMemberSelective(Member member) {
        return memberMapper.selectInstanceSelective(member);
    }

    @Override
    public Integer delMemberById(Long id) {
        return memberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Member getMemberById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public Member getMemberByName(String username) {
        return memberMapper.selectInstanceByName(username);
    }

    @Override
    public Integer getMemberLevelById(Long id) {
        return memberMapper.selectMemberLevelById(id);
    }

    @Override
    public Integer updateMemberSelective(Member member) {
        if(member.getPassword().length()!=0){
            Map<String, Object> encryptMap = this.updatePasswordBySalt(member.getPassword());
            member.setPassword((String) encryptMap.get("pwd"));
            member.setSalt((String) encryptMap.get("salt"));
        }
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public Map<String, Object> updatePasswordBySalt(String password){
        Map<String, Object> resultMap = PasswordEncrypt.encryptPWDBySalt(password, 2);
        if(resultMap!=null){
            password =(String) resultMap.get("encryptPWD");
            String salt = (String)resultMap.get("salt");
            resultMap.put("pwd",password);
            resultMap.put("salt",salt);
        }
        return resultMap;
    }
}
