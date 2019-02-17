package com.tansuo365.test1.controller;

import com.tansuo365.test1.bean.Role;
import com.tansuo365.test1.bean.User;
import com.tansuo365.test1.mapper.UserMapper;
import com.tansuo365.test1.service.RoleService;
import com.tansuo365.test1.service.UserRoleService;
import com.tansuo365.test1.service.UserService;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*管理员控制层*/
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Resource
    private UserMapper userMapper;


    /**
     * 查询用户信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/listAllUser")
    public Map<String, Object> list() throws Exception {
        //TODO
        List<User> userList = userService.list();
        for (User u : userList) {
            List<Role> roleList = roleService.listRoles(u);
            StringBuffer sb = new StringBuffer();
            //放入用户role字符串,以,分开
            for (Role r : roleList) {
                sb.append("," + r.getName());
            }
            // @the bean User
            // @Transient
            // private String roles; //展示用户角色
            u.setRoles(sb.toString().replaceFirst(",", ""));
        }
        //省略count现
        Long total = userMapper.getCount();
        System.err.println("total:" + total);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("rows", userList);
        resultMap.put("total", total);
        return resultMap;
    }

    /**
     * 保存用户角色设置
     * @param roleIds 角色id字符串 (含多个)
     * @param userId 管理员id 单个
     * @return
     */
    @RequestMapping("/saveRoleSet")
    public Map<String, Object> saveRoleSet(String roleIds, Long userId) {
        Map<String, Object> resultMap = new HashMap<>();
        roleService.delete(userId); //根据用户id删除所有用户角色关联实体
        if (!StringUtils.isEmpty(roleIds)) {
            String idsStr[] = roleIds.split(",");
            long rIds[] = (long[])ConvertUtils.convert(idsStr,long.class);
            userRoleService.setRoles(userService.get(userId),rIds);
        }
        resultMap.put("success",true);
        return resultMap;
    }

    /**
     * 添加或者修改用户信息
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public Map<String,Object> saveUser(User user) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        if(user.getId()==null){
            if(userService.getByName(user.getName())!=null){
                resultMap.put("success",false);
                resultMap.put("errorInfo","用户名已经存在!");
                return resultMap;
            }
        }
        int updateCode = 0;
        int insertCode = 0;
        if(user.getId()!=null){ //不为空,则要进行升级管理员user信息
            updateCode = userService.update(user);
            resultMap.put("saveMessage","管理员信息更新成功!");
        }else{ //为空,则说明是要注册新的管理员user
            insertCode = userService.add(user);
            resultMap.put("saveMessage","管理员添加成功!");
        }
        /*如果更新code或者插入code成功状态则success true,否则不是*/
        if(updateCode==1 || insertCode==1){
            resultMap.put("success",true);
            return resultMap;
        }else{
            resultMap.put("success",false);
            resultMap.put("errorInfo","保存失败!(⊙o⊙)？");
            return resultMap;
        }
    }

    /**
     * 删除管理员信息 (包含删除管理员角色)
     * @param id
     * @return
     */
    @RequestMapping("/deleteUserById")
    public Map<String,Object> deleteUserById(Long id){
        Map<String,Object> resultMap = new HashMap<>();
        //内部包含删除用户以及删除用户角色
        int deleteCode = userService.delete(id);
        if(deleteCode==1){
            resultMap.put("success",true);
        }else{
            resultMap.put("success",false);
            resultMap.put("errorInfo","删除失败了(⊙o⊙)？");
        }
        return resultMap;

    }

//    /**
//     * 加载权限菜单 (该方法表明用户需要选定一个角色登录,而不是多角色共享)
//     * @param session
//     * @return
//     * @throws Exception
//     */
//    @ResponseBody
//    @RequestMapping("/loadMenuInfo")
//    public String loadMenuInfo(HttpSession session, Integer parentId)throws Exception{
//        Role currentRole=(Role) session.getAttribute("currentRole");
//        return getAllMenuByParentId(parentId,currentRole.getId()).toString();
//    }


}
