package com.tansuo365.test1.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tansuo365.test1.bean.EMenu;
import com.tansuo365.test1.bean.Role;
import com.tansuo365.test1.service.EMenuService;
import com.tansuo365.test1.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequestMapping("/admin")
@Controller
public class AdminLoginController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private EMenuService eMenuService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/admin/login"; //对应用户登录展示
    }


    /**
     * 用户登录请求
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/loginadmin",method = RequestMethod.POST)
    public Map<String,Object> login(String username,String password, String rememberMe) {
        Map<String, Object> map = new HashMap<String, Object>();

        System.out.println("rememberMe>>>>:"+rememberMe);

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token); // 登录认证
            String userName = (String) SecurityUtils.getSubject().getPrincipal();
            Session session = currentUser.getSession();
            session.setAttribute("currentUser", currentUser);
            /*通过用户名查询角色list*/
            List<Role> roleList = roleService.listRoles(userName);
            roleList.remove(null);// TODO 会有null,异常
//            for(Role role:roleList){
//                System.out.println("LoginController.roleName:"+role.getName());
//            }
            session.setAttribute("roleList", roleList);
            map.put("roleList", roleList);
            map.put("roleSize", roleList.size());
            map.put("success", true);
            return map;
        } catch (IncorrectCredentialsException e) {
            System.err.println("登录失败:用户名/密码不匹配!");
            e.printStackTrace();
            map.put("success", false);
            map.put("errorInfo", "用户名或者密码错误！");
            return map;
        } catch (LockedAccountException e) {
            System.err.println("登录失败:账户已被冻结!");
            e.printStackTrace();
            map.put("success", false);
            map.put("errorInfo", "登录失败:账户已被冻结!");
            return map;
        } catch (AuthenticationException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            map.put("success", false);
            map.put("errorInfo", "登录失败!");
            return map;
        }


    }

    //    @CachePut(value = "subject") 即保证方法被调用,又加入缓存
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(Model model, User user, boolean rememberMe, String loginType) throws AuthenticationException {
////        System.err.println("loginType:"+loginType);
//        System.err.println("rememberMe:" + rememberMe);
//        Subject currentUser = SecurityUtils.getSubject();
//        //指明登录类型为管理员登录(在授权时使用)
////        currentUser.getSession().setAttribute("loginType",ADMIN_LOGIN_TYPE);
//        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword(), rememberMe);
////        MyAuthenticationToken myAuthenticationToken = new MyAuthenticationToken(user.getName(),user.getPassword(),rememberMe,ADMIN_LOGIN_TYPE);
//
//        try {
//            currentUser.login(token);
//            String userName = (String) SecurityUtils.getSubject().getPrincipal();
//            Session session = currentUser.getSession();
//            session.setAttribute("currentUser", currentUser);
//            //通过用户名查询角色list
//            List<Role> roleList = roleService.listRoles(userName);
//            session.setAttribute("roleList", roleList);
//            return "redirect:/admin/main"; //TODO JXC的main页面进行整合
////            return "redirect:/admin/"; 原来的index
//        } catch (IncorrectCredentialsException e) {
//            System.err.println("登录失败:用户名/密码不匹配!");
//            e.printStackTrace();
//        } catch (LockedAccountException e) {
//            System.err.println("登录失败:账户已被冻结!");
//            e.printStackTrace();
//        } catch (AuthenticationException e) {
//            System.err.println(e.getMessage());
//            e.printStackTrace();
//        } finally {
//        }
//        return "redirect:/admin/login";
//    }

    /**
     * 加载权限菜单 通过用户roleList,如有权限菜单重复则去除
     *
     * @param parentId
     * @return
     */
    @ResponseBody
    @RequestMapping("/loadMenuInfo")
    public String loadMenuInfo(HttpSession session,Integer parentId) {
        Role currentRole = (Role)session.getAttribute("currentRole");
        return getAllMenuByParentIdAndSingleRoleId(parentId, currentRole.getId()).toString();
//        List<Role> roleList = (List<Role>) SecurityUtils.getSubject().getSession().getAttribute("roleList");
////        System.err.println("loadMenuInfo.roleList:"+roleList.toArray().toString());
//        Set<Long> roleIdSet = new HashSet<>();
//        Long rid = null;
//        for (Role role : roleList) {
//            Long roleId = role.getId();
//            roleIdSet.add(roleId);
//            rid = roleId;
//        }
//        for(Long roleid:roleIdSet){
//            System.err.println("roleid:"+roleid);
//        }
//        System.err.println("loadMenuInfo.return"+getAllMenuByParentId(parentId, roleIdSet).toString());
    }

    //不适用
    private JSONArray getAllMenuByParentId(Integer parentId, Set<Long> roleIdSet) {
        JSONArray jsonArray = this.getMenuByParentId(parentId, roleIdSet);
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject=(JSONObject) jsonArray.get(i);
            if("open".equals(jsonObject.get("state").toString())){
                continue;
            }else{
                jsonObject.put("children", getAllMenuByParentId((Integer) jsonObject.get("id"),roleIdSet));
                System.err.println("children:"+roleIdSet.toString());
            }
        }
        return jsonArray;
    }

    /**
     * 获取所有菜单信息
     *
     * @param parentId
     * @param
     * @return
     */
    private JSONArray getAllMenuByParentIdAndSingleRoleId(Integer parentId,Long roleId){
        JSONArray jsonArray = this.getMenuByParentIdAndSingleRoleId(parentId,roleId);
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject=(JSONObject) jsonArray.get(i);
            if("open".equals(jsonObject.get("state").toString())){
                continue;
            }else{
                jsonObject.put("children", getAllMenuByParentIdAndSingleRoleId((Integer) jsonObject.get("id"),roleId));
            }
//            if(1==(Integer)jsonObject.get("state")){
//                continue;
//            }else{
//                jsonObject.put("children", getAllMenuByParentIdAndSingleRoleId((Integer) jsonObject.get("id"),roleId));
//            }
        }
        return jsonArray;
    }

    /**
     * 根据父节点和用户角色id查询菜单
     * @param parentId
     * @param roleId
     * @return
     */
    private JSONArray getMenuByParentIdAndSingleRoleId(Integer parentId, Long roleId) {
        List<EMenu> eMenuList = eMenuService.findByParentIdAndSingleRoleId(parentId,roleId);
        JSONArray jsonArray = new JSONArray();
        for(EMenu eMenu:eMenuList){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",eMenu.getId());//节点id
            jsonObject.put("text",eMenu.getName());//节点名称
            if(eMenu.getState()==1){//根节点
                jsonObject.put("state","closed");
            }else{//叶子节点
                jsonObject.put("state","open");
            }
            jsonObject.put("iconCls",eMenu.getIcon());
            JSONObject attributeObject = new JSONObject();//扩展属性
            attributeObject.put("url",eMenu.getUrl());//菜单请求地址
            jsonObject.put("attributes",attributeObject);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    //不适用
    private JSONArray getMenuByParentId(Integer parentId, Set<Long> roleIdSet) {
        List<EMenu> eMenuList = eMenuService.findByParentIdAndRoleId(parentId, roleIdSet);
        System.err.println("eMenuList.size:"+eMenuList.size());
        JSONArray jsonArray = new JSONArray();
        for(EMenu eMenu:eMenuList){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",eMenu.getId());//节点id
            jsonObject.put("text",eMenu.getName());//节点名称
            if(eMenu.getState()==1){//根节点
                jsonObject.put("state","closed");
            }else{//叶子节点
                jsonObject.put("state","open");
            }
            jsonObject.put("iconCls",eMenu.getIcon());
            JSONObject attributeObject = new JSONObject();//扩展属性
            attributeObject.put("url",eMenu.getUrl());//菜单请求地址
            jsonObject.put("attributes",attributeObject);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }




}
