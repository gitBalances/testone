package com.tansuo365.test1.controller.admin;

import com.tansuo365.test1.bean.user.Role;
import com.tansuo365.test1.bean.user.User;
import com.tansuo365.test1.service.redis.RedisService;
import com.tansuo365.test1.service.user.EMenuService;
import com.tansuo365.test1.service.user.RoleService;
import com.tansuo365.test1.service.user.UserService;
import com.tansuo365.test1.util.EMenuUtils;
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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

@Api(value = "管理员登录控制层", tags = "管理员登录接口 AdminLoginController", description = "管理员登录,包括获取树形结构菜单")
@RequestMapping("/admin")
@RestController
public class AdminLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private EMenuService eMenuService;
    @Autowired
    private EMenuUtils eMenuUtils;

//    @ApiOperation(value = "/login登录页", notes = "返回/admin下login.html")
//    @GetMapping(value = "/login")
//    public String login() {
//        return "/admin/login"; //对应用户登录展示
//    }

    /**
     * 用户登录请求
     *
     * @param
     * @return
     */
    @ApiOperation(value = "登录请求POST", notes = "登录请求POST,通过shiro进行鉴权")
    @ResponseBody
    @PostMapping(value = "/loginAdmin")
    public Map<String, Object> login(String username, String password, String rememberMe, HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();

        System.out.println("rememberMe>>>>:" + rememberMe);

        Session session1 = SecurityUtils.getSubject().getSession();
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token); // 登录认证
            String userName = (String) SecurityUtils.getSubject().getPrincipal();
            User user = userService.getUserByName(userName);
//            Session session = currentUser.getSession();
            session.setAttribute("currentUser", user);
            session.setAttribute("userName", user.getName());
            session1.setAttribute("currentUser", user);
            List<Role> roleList = new ArrayList<>();
            roleList = roleService.listRolesByUserId(user.getId());//最新
            System.out.println("roleList-------:"+roleList);
            //从缓存中获取查看是否已经有该用户的roleList
            /*通过用户名查询角色list*/
            roleList.remove(null);// TODO 会有null,异常
            redisService.set(user.getName() + "-roleList", roleList);//redis存储该user有哪些roles

            Integer[] ids = new Integer[roleList.size()];
            int i = 0;
            for (Role role : roleList) {
                Long roleId = role.getId();
                ids[i] = Integer.parseInt(roleId.toString());
                i++;
            }
            int e = 0;
            List<Integer> menuIdListByRoleIds = eMenuService.findMenuIdListByRoleIds(ids);
            //menuId数组
            int[] menuIdArr = new int[menuIdListByRoleIds.size()];
            String menuIdStr = "";
            for (int menuId : menuIdListByRoleIds) {
                menuIdArr[e] = menuId;
                menuIdStr += menuId + ",";
                e++;
            }
            Arrays.sort(menuIdArr);
            Object allMenuObj = redisService.get(menuIdStr);
            System.out.println("menuIdStr:" + menuIdStr);
            if (allMenuObj != null) {
                redisService.set(menuIdStr, allMenuObj.toString());
                System.out.println("(String)allMenuObj:" + (String) allMenuObj);
                session.setAttribute("menuIds", menuIdArr);
                redisService.set(session.getAttribute("menuIds").toString() + session.getAttribute("currentUser").toString(), allMenuObj.toString());
            } else {
                String allMenu = eMenuUtils.getAllEMenuByParentIdAndMenuIds(-1, menuIdArr).toString();
                System.out.println("login.allMenu:" + allMenu);
                redisService.set(menuIdStr, allMenu);
                session.setAttribute("menuIds", menuIdArr);
                redisService.set(session.getAttribute("menuIds").toString() + session.getAttribute("currentUser").toString(), allMenu);
            }

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
     * TODO 完善树形菜单
     * 加载权限菜单 通过用户roleList,如有权限菜单重复则去除
     * 如果有多个role去除可能role对应重复的emenu,并留下交叉的
     * 根据用户实例,用户角色list作为key存储redis,下次不再查询节约资源
     *
     * @param parentId
     * @return
     */
    @ApiOperation(value = "读取系统菜单", notes = "[待改善]树形结构,根据roleid按需获取,而不是显示没有权限访问")
    //使用会员实例+roleList为key,当变动role时,更新allMenu
//    @Cacheable(value = "allMenu", key = "#session.getAttribute('currentUser').toString()+#session.getAttribute('roleList').toString()", condition = "#parentId !=  '' ")
    @Cacheable(value = "allMenu", key = "#session.getAttribute('menuIds').toString()+#session.getAttribute('currentUser').toString()", condition = "#parentId !=  '' ")
    @ResponseBody
    @PostMapping("/loadMenuInfo")
    @RequiresAuthentication
    @RequiresPermissions("系统菜单")
    public String loadMenuInfo(HttpSession session, Integer parentId) {
//        Role currentRole = (Role)session.getAttribute("currentRole");
        System.out.println("读取系统菜单中");

        String allMenu = "";
        allMenu = (String) redisService.get(session.getAttribute("menuIds").toString() + session.getAttribute("currentUser").toString());
        if (allMenu.length() > 0) {
            System.out.println("通过redis获取session的menuids+currentUser获取了allMenu");
            return allMenu;
        }
        Object menuIdArr = session.getAttribute("menuIds");
        int[] menuIds = (int[]) menuIdArr;
        Arrays.sort(menuIds);

        String menuIdStr = "";
        for (int menuId : menuIds) {
            menuIdStr += menuId + ",";
        }

        if (redisService.get(menuIdStr) != null) {
            System.out.println("loadMenuInfo获取到了redis中的allMenu数据");

            allMenu = redisService.get(menuIdStr).toString();
            return allMenu;
        } else {
            System.out.println("loadMenuInfo从redis中获取allMenu数据失败.");
            Object menuIdArr1 = session.getAttribute("menuIds");
            int[] menuIds1 = (int[]) menuIdArr1;
            Arrays.sort(menuIds);
            String menuIdStr1 = "";
            for (int menuId : menuIds1) {
                menuIdStr1 += menuId + ",";
            }
            System.out.println("menuIdStr1:" + menuIdStr1);
            Object allMenuObj = redisService.get(menuIdStr1);
            if (allMenuObj != null) {
                System.out.println("(String)allMenuObj:" + allMenuObj.toString());
                System.out.println("loadMenuInfo获取到了redis中的allMenu数据,第二次成功.");
                allMenu = allMenuObj.toString();
                return allMenu;
            } else {
                System.out.println("loadMenuInfo从redis中获取allMenu数据失败.正式开始走数据库获取.");
//        String allMenu = eMenuUtils.getAllEMenuByParentIdAndMenuIds(parentId, menuIdArr).toString();
                allMenu = eMenuUtils.getAllEMenuByParentIdAndMenuIds(parentId, menuIds).toString();
                System.out.println("loadMenuInfo获取数据库后,allMenu:" + allMenu);
                redisService.set(menuIdStr1, allMenu);
                return allMenu;
            }
        }

    }


}
