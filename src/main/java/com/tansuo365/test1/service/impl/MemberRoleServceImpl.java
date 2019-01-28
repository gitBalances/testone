package com.tansuo365.test1.service.impl;

import com.tansuo365.test1.bean.Member;
import com.tansuo365.test1.bean.MemberRole;
import com.tansuo365.test1.bean.MemberRoleExample;
import com.tansuo365.test1.mapper.MemberRoleMapper;
import com.tansuo365.test1.service.MemberRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*会员角色实现*/
@Service
public class MemberRoleServceImpl implements MemberRoleService {

    @Resource
    private MemberRoleMapper memberRoleMapper;

    @Override
    public void setMroles(Member member, long[] mroleIds) {
        //删除当前用户所有的角色
        MemberRoleExample example = new MemberRoleExample();
        example.createCriteria().andMidEqualTo(member.getId());
        List<MemberRole> mrs = memberRoleMapper.selectByExample(example);
        for (MemberRole memberRole : mrs) {
            memberRoleMapper.deleteByPrimaryKey(memberRole.getId());
        }
        //设置新的角色关系
        if (null != mroleIds) {
            for (long mrid : mroleIds) {
                MemberRole memberRole = new MemberRole();
                memberRole.setRid(mrid);
                memberRole.setMid(member.getId());
                memberRoleMapper.insert(memberRole);
            }
        }
    }


    @Override
    public void deleteByMember(long memberId) {
        MemberRoleExample example = new MemberRoleExample();
        example.createCriteria().andMidEqualTo(memberId);
        List<MemberRole> mrs = memberRoleMapper.selectByExample(example);
        for (MemberRole memberRole : mrs) {
            memberRoleMapper.deleteByPrimaryKey(memberRole.getId());
        }

    }

    @Override
    public void deleteByMrole(long mroleId) {
        MemberRoleExample example = new MemberRoleExample();
        example.createCriteria().andRidEqualTo(mroleId);
        List<MemberRole> mrs = memberRoleMapper.selectByExample(example);
        for(MemberRole memberRole : mrs){
            memberRoleMapper.deleteByPrimaryKey(memberRole.getId());
        }
    }
}
