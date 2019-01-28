package com.tansuo365.test1.service;

import com.tansuo365.test1.bean.MemberPermission;
import com.tansuo365.test1.bean.Mrole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface MemberPermissionService {

    public Set<String> listMemberPermissions(String userName);

    public List<MemberPermission> list();

    public void add(MemberPermission memberPermission);

    public void delete(Long id);

    public MemberPermission get(Long id);

    public void update(MemberPermission memberPermission);

    public List<MemberPermission> list(Mrole mrole);

    public boolean needInterceptor(String requestURI);

    public Set<String> listMemberPermissionURLs(String userName);
}
