package com.tansuo365.test1.service.impl;

import com.tansuo365.test1.bean.*;
import com.tansuo365.test1.mapper.MemberRoleMapper;
import com.tansuo365.test1.mapper.MroleMapper;
import com.tansuo365.test1.service.MemberService;
import com.tansuo365.test1.service.MroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*会员角色实现*/
@Service
public class MroleServiceImpl implements MroleService {

    @Resource
    private MroleMapper mroleMapper;
    @Resource
    private MemberRoleMapper memberRoleMapper;
    @Resource
    private MemberService memberService;

    @Override
    public Set<String> listMroleNames(String userName) {
        Set<String> result = new HashSet<>();
        List<Mrole> mroles = listMroles(userName);
        for (Mrole mrole : mroles) {
            result.add(mrole.getName());
        }
        return result;
    }

    @Override
    public List<Mrole> listMroles(String userName) {
        List<Mrole> mroles = new ArrayList<>();
        Member member = memberService.getByName(userName);
        if (null == member) {
            return mroles;
        }

        mroles = listMroles(member);
        return mroles;
    }

    @Override
    public List<Mrole> listMroles(Member member) {
        List<Mrole> mroles = new ArrayList<>();

        MemberRoleExample example = new MemberRoleExample();

        example.createCriteria().andMidEqualTo(member.getId());
        List<MemberRole> memberRoles = memberRoleMapper.selectByExample(example);

        for (MemberRole memberRole : memberRoles) {
            Mrole mrole = mroleMapper.selectByPrimaryKey(memberRole.getRid());
            mroles.add(mrole);
        }
        return mroles;
    }

    @Override
    public List<Mrole> list() {
        MroleExample example = new MroleExample();
        example.setOrderByClause("id desc");
        return mroleMapper.selectByExample(example);
    }

    @Override
    public void add(Mrole mrole) {
        mroleMapper.insert(mrole);
    }

    @Override
    public void delete(Long id) {
        mroleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Mrole get(Long id) {
        return mroleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Mrole mrole) {
        mroleMapper.updateByPrimaryKeySelective(mrole);
    }
}
