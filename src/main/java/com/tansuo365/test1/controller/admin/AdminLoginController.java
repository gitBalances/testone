package com.tansuo365.test1.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tansuo365.test1.bean.user.EMenu;
import com.tansuo365.test1.bean.user.Role;
import com.tansuo365.test1.bean.user.User;
import com.tansuo365.test1.service.user.EMenuService;
import com.tansuo365.test1.service.user.RoleService;
import com.tansuo365.test1.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpSession;
import java.util.*;

@Api(value = "管理员登录控制层",description = "管理员登录,包括获取树形结构菜单")
@RequestMapping("/admin")
@Controller
public class AdminLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private EMenuService eMenuService;

    @ApiOperation(value="/login登录页", notes="返回/admin下login.html")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/admin/login"; //对应用户登录展示
    }


    /**
     * 用户登录请求
     *
     * @param
     * @return
     */
    @ApiOperation(value="登录请求POST", notes="登录请求POST,通过shiro进行鉴权")
    @ResponseBody
    @RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
    public Map<String, Object> login(String username, String password, String rememberMe, HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();

        System.out.println("rememberMe>>>>:" + rememberMe);

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token); // 登录认证
            String userName = (String) SecurityUtils.getSubject().getPrincipal();
            User user = userService.getByName(userName);
//            Session session = currentUser.getSession();
            session.setAttribute("currentUser", currentUser);
            /*通过用户名查询角色list*/
            List<Role> roleList = roleService.listRolesByUserId(user.getId());
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
     * 如果有多个role去除可能role对应重复的emenu,并留下交叉的
     *
     * @param parentId
     * @return
     */
    @ApiOperation(value="读取系统菜单", notes="[待改善]树形结构,根据roleid按需获取,而不是显示没有权限访问")
    @ResponseBody
    @RequestMapping("/loadMenuInfo")
    @RequiresAuthentication
    @RequiresPermissions("系统菜单")
    public String loadMenuInfo(HttpSession session, Integer parentId) {
//        Role currentRole = (Role)session.getAttribute("currentRole");
        List<Role> roleList = (List<Role>) session.getAttribute("roleList");
        System.out.println("roleList.size():" + roleList.size());
        Long[] ids = new Long[roleList.size()];
        int i = 0;


        for (Role role : roleList) {
            Long roleId = role.getId();
            ids[i] = roleId;
//            System.out.println("loadMenuID"+ids[i]);
            i++;
//            getAllMenuByParentId(parentId, ids,i).toString();
        }
        Long[] idsNew = new Long[1];
        idsNew[0] = 1L;
        return getAllMenuByParentIdAndSingleRoleId(parentId, idsNew[0]).toString();
//        if (ids.length == 1) {
//            return getAllMenuByParentIdAndSingleRoleId(parentId, ids[0]).toString();
//        }
//        if (ids.length == 0) {
//            return null;
//        } else {
//            int j = 0;
//            return getAllMenuByParentId(parentId, ids,j).toString();
//        }
//        return allRoleEMenu.toString();
//        return getAllMenuByParentIdAndSingleRoleId(parentId, 1l).toString().replace(string,"");
    }

    //根据多个roleid获取EMenu(已去重复EMenu)
    private JSONArray getAllMenuByParentId(Integer parentId, Long[] ids,int j) { //<<<<<<<<<<

        JSONArray jsonArray = null;
        first:
        for (int k=j;k<ids.length;j++) { //如2个角色该for循环2次
            //先获取如role5的角色以及对应parentid的emenu
            Long id = ids[k];
//            System.out.println("forTIme:ID"+id);
//            jsonArray = this.getMenuByParentIdAndSingleRoleId(parentId, id);
            jsonArray = this.getMenuByParentId(parentId, ids);
            second:
            for (int i = 0; i < jsonArray.size(); i++) {//size为该parentid节点下的含有的,根节点菜单及子菜单的数量
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                if ("open".equals(jsonObject.get("state").toString())) {//叶子节点,无法放children
                    continue;
//                    continue second;//继续执行上面for循环获取另一个菜单(根或子)
//                    break second;
                } else {
                    //-1,10
                    //如果有根节点[0],通过根节点的id即parentid,获取之下的子节点菜单
//                for(int j=0;j<ids.length;j++){
                    jsonObject.put("children", getAllMenuByParentId((Integer) jsonObject.get("id"), ids,j));
//                }
                }
            }
        }
//        System.out.println("getAllMenuByParentId(Integer parentId, Long[] ids):" + jsonArray);
        return jsonArray;
    }

    //假如先传入-1 pid,ids,那么返回的应该是ids对应的所有的-1下的
    private JSONArray getMenuByParentId(Integer parentId, Long[] ids) {
        //获取不重复的EMenuList
        List<EMenu> eMenuList = eMenuService.findByParentIdAndRoleIdArr(parentId, ids);
        System.err.println("eMenuList.size:" + eMenuList.size());
        JSONArray jsonArray = new JSONArray();
        for (EMenu eMenu : eMenuList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", eMenu.getId());//节点id
            jsonObject.put("text", eMenu.getName());//节点名称
            if (eMenu.getState() == 1) {//根节点
                jsonObject.put("state", "closed");
            } else {//叶子节点
                jsonObject.put("state", "open");
            }
            jsonObject.put("iconCls", eMenu.getIcon());
            JSONObject attributeObject = new JSONObject();//扩展属性
            attributeObject.put("url", eMenu.getUrl());//菜单请求地址
            jsonObject.put("attributes", attributeObject);
            jsonArray.add(jsonObject);
        }
        System.out.println("findByParentIdAndRoleIdArr:getEmenuList:jsonArray:"+jsonArray);
        return jsonArray;
    }


    /**
     * 获取所有菜单信息 (单条不适用)
     *
     * @param parentId
     * @param
     * @return
     */
    private JSONArray getAllMenuByParentIdAndSingleRoleId(Integer parentId, Long roleId) {
        JSONArray jsonArray = this.getMenuByParentIdAndSingleRoleId(parentId, roleId);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            if ("open".equals(jsonObject.get("state").toString())) {
                continue;
            } else {
                jsonObject.put("children", getAllMenuByParentIdAndSingleRoleId((Integer) jsonObject.get("id"), roleId));
            }
        }
//        System.out.println("getAllMenuByParentIdAndSingleRoleId(Integer parentId, Long roleId):" + jsonArray);
        return jsonArray;
    }


    /**
     * 根据父节点和用户角色id查询菜单 (单条不适用)
     *
     * @param parentId
     * @param roleId
     * @return
     */
    private JSONArray getMenuByParentIdAndSingleRoleId(Integer parentId, Long roleId) {
        List<EMenu> eMenuList = eMenuService.findByParentIdAndSingleRoleId(parentId, roleId);
        JSONArray jsonArray = new JSONArray();
        for (EMenu eMenu : eMenuList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", eMenu.getId());//节点id
            jsonObject.put("text", eMenu.getName());//节点名称
            if (eMenu.getState() == 1) {//根节点
                jsonObject.put("state", "closed");
            } else {//叶子节点
                jsonObject.put("state", "open");
            }
            jsonObject.put("iconCls", eMenu.getIcon());
            JSONObject attributeObject = new JSONObject();//扩展属性
            attributeObject.put("url", eMenu.getUrl());//菜单请求地址
            jsonObject.put("attributes", attributeObject);
            jsonArray.add(jsonObject);
        }
        System.out.println("findByParentIdAndSingleRoleId:getEmenuList:jsonArray:"+jsonArray);
        return jsonArray;
    }


}
