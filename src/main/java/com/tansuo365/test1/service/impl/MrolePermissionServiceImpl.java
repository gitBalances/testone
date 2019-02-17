//package com.tansuo365.test1.service.impl;
//
//import com.tansuo365.test1.unused.*;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///*会员角色权限实现*/
//@Service
//public class MrolePermissionServiceImpl implements MrolePermissionService {
//
//    @Resource
//    private MrolePermissionMapper mrolePermissionMapper;
//
//    @Override
//    public void setMemberPermissions(Mrole mrole, long[] pIds) {
//        //删除当前角色所有的权限
//        MrolePermissionExample example = new MrolePermissionExample();
//        example.createCriteria().andRidEqualTo(mrole.getId());
//        List<MrolePermission> mrps = mrolePermissionMapper.selectByExample(example);
//        for (MrolePermission mrolePermission : mrps) {
//            mrolePermissionMapper.deleteByPrimaryKey(mrolePermission.getId());
//        }
//
//        //设置新的权限关系
//        if (null != pIds) {
//            for (long pid : pIds) {
//                MrolePermission mrolePermission = new MrolePermission();
//                mrolePermission.setPid(pid);
//                mrolePermission.setRid(mrole.getId());
//                mrolePermissionMapper.insert(mrolePermission);
//            }
//        }
//
//
//    }
//
//    @Override
//    public void deleteByMrole(long rId) {
//        MrolePermissionExample example = new MrolePermissionExample();
//        example.createCriteria().andRidEqualTo(rId);
//        List<MrolePermission> mrps = mrolePermissionMapper.selectByExample(example);
//        for (MrolePermission mrolePermission : mrps) {
//            mrolePermissionMapper.deleteByPrimaryKey(mrolePermission.getId());
//        }
//    }
//
//    @Override
//    public void deleteByPermission(long pId) {
//        MrolePermissionExample example = new MrolePermissionExample();
//        example.createCriteria().andPidEqualTo(pId);
//        List<MrolePermission> mrps = mrolePermissionMapper.selectByExample(example);
//        for (MrolePermission mrolePermission : mrps) {
//            mrolePermissionMapper.deleteByPrimaryKey(mrolePermission.getId());
//        }
//    }
//}
