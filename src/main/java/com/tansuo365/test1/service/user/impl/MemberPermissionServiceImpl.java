//package com.tansuo365.test1.service.user.impl;
//
//import com.tansuo365.test1.unused.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///*会员权限实现*/
//@Service
//public class MemberPermissionServiceImpl implements MemberPermissionService {
//
//    @Resource
//    private MemberPermissionMapper memberPermissionMapper;
//    @Autowired
//    private MemberService memberService;
//    @Autowired
//    private MroleService mroleService;
//    @Resource
//    private MrolePermissionMapper mrolePermissionMapper;
//
//    @Override
//    public Set<String> listMemberPermissions(String userName) {
//        Set<String> result = new HashSet<>();
//        List<Mrole> mroles = mroleService.listMroles(userName);
//
//        List<MrolePermission> mrolePermissions = new ArrayList<>();
//
//        for (Mrole mrole : mroles) {
//            MrolePermissionExample example = new MrolePermissionExample();
//            example.createCriteria().andRidEqualTo(mrole.getId());
//            List<MrolePermission> rps = mrolePermissionMapper.selectByExample(example);
//            mrolePermissions.addAll(rps);
//        }
//
//        for (MrolePermission mrolePermission : mrolePermissions) {
//            MemberPermission mp = memberPermissionMapper.selectByPrimaryKey(mrolePermission.getPid());
//            result.add(mp.getName());
//        }
//
//        return result;
//    }
//
//    @Override
//    public List<MemberPermission> list() {
//        MemberPermissionExample example = new MemberPermissionExample();
//        example.setOrderByClause("id desc");
//        return memberPermissionMapper.selectByExample(example);
//    }
//
//    @Override
//    public void add(MemberPermission memberPermission) {
//        memberPermissionMapper.insert(memberPermission);
//    }
//
//    @Override
//    public void delete(Long id) {
//        memberPermissionMapper.deleteByPrimaryKey(id);
//    }
//
//    @Override
//    public MemberPermission get(Long id) {
//        return memberPermissionMapper.selectByPrimaryKey(id);
//    }
//
//    @Override
//    public void update(MemberPermission memberPermission) {
//        memberPermissionMapper.updateByPrimaryKeySelective(memberPermission);
//    }
//
//    @Override
//    public List<MemberPermission> list(Mrole mrole) {
//        List<MemberPermission> result = new ArrayList<>();
//        MrolePermissionExample example = new MrolePermissionExample();
//        example.createCriteria().andRidEqualTo(mrole.getId());
//        List<MrolePermission> rps = mrolePermissionMapper.selectByExample(example);
//        for (MrolePermission mrolePermission : rps) {
//            result.add(memberPermissionMapper.selectByPrimaryKey(mrolePermission.getPid()));
//        }
//
//        return result;
//    }
//
//    @Override
//    public boolean needInterceptor(String requestURI) {
//        List<MemberPermission> ps = list();
//        for (MemberPermission mp : ps) {
//            if (mp.getUrl().equals(requestURI))
//                return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<String> listMemberPermissionURLs(String userName) {
//        Set<String> result = new HashSet<>();
//        List<Mrole> mroles = mroleService.listMroles(userName);
//
//        List<MrolePermission> mrolePermissions = new ArrayList<>();
//
//        for (Mrole mrole : mroles) {
//            MrolePermissionExample example = new MrolePermissionExample();
//            example.createCriteria().andRidEqualTo(mrole.getId());
//            List<MrolePermission> rps = mrolePermissionMapper.selectByExample(example);
//            mrolePermissions.addAll(rps);
//        }
//
//        for (MrolePermission mrolePermission : mrolePermissions) {
//            MemberPermission mp = memberPermissionMapper.selectByPrimaryKey(mrolePermission.getPid());
//            result.add(mp.getUrl());
//        }
//
//        return result;
//    }
//
//}
