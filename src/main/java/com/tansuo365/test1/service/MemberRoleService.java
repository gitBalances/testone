package com.tansuo365.test1.service;

import com.tansuo365.test1.bean.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRoleService {
    public void setMroles(Member member, long[] mroleIds);

    public void deleteByMember(long memberId);

    public void deleteByMrole(long mroleId);
}
