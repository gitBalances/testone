package com.tansuo365.test1.util;

import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.bean.log.LogMember;
import com.tansuo365.test1.bean.log.LogUser;
import com.tansuo365.test1.bean.log.UserType;
import com.tansuo365.test1.bean.member.Member;
import com.tansuo365.test1.bean.user.User;
import com.tansuo365.test1.entity.LogUsers;
import com.tansuo365.test1.entity.MyLoginInstance;
import com.tansuo365.test1.mapper.log.LogMemberMapper;
import com.tansuo365.test1.mapper.log.LogUserMapper;
import com.tansuo365.test1.service.log.ILogCommonService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class LogUtils {

    private String whenCodeOne;
    private String whenCodeZero;
    private String whenCodeMany;
    private String whenOtherCase;

    final String MEMBER_LOGIN = "";
    final String ADMIN_LOGIN = "";
    final String MEMBER_LOGOUT= "";
    final String ADMIN_LOGOUT = "";

    final private String PETROLEUM_COKE = "PetroleumCoke";
    final private String CALCINED_COKE = "CalcinedCoke";
    final private String MASPHALT = "MAsphalt";
    final private String ANODE = "Anode";

    final private String MEMBER_TYPE = "member";
    final private String ADMIN_TYPE = "admin";

    final private String COMMON_LOG = "syslog";
    final private String MEMBER_LOG = "member_log";
    final private String ADMIN_LOG = "admin_log";

    final private String ADMIN_ROLE = "admin_role";

    final private String DB_TABlES = "DBTables";

    //标注此次查询日志时的日志类型
    private String thisLogInstance = null;

    @Resource
    private ILogCommonService logCommonService;
    @Resource
    private LogUserMapper logUserMapper;
    @Resource
    private LogMemberMapper logMemberMapper;
    /**
     * 判定CRUD并执行log操作
     * @param list 查询数据list
     * @param code 回code
//     * @param userType 操作用户类型
     * @param actionType 执行操作类型
     * @param instance 操作的实体类型
     */
    public void doLog(List list, int code, Enum<LogEnum> actionType, String instance, HttpSession session) {
        //执行日志记录,通过session判定操作日志的是member还是admin(user)
        //获取当前登录用户实例
        Session session1 = SecurityUtils.getSubject().getSession();
        User currentUser = (User) session1.getAttribute("currentUser");
        MyLoginInstance myLoginInstance = null;
        String user = null;

        //如果使用者即可以查看后台又可以查看前端时,当查询数据时,先指定为admin后端查看
        if(currentUser != null) {
            user = UserType.ADMIN.toString();
            myLoginInstance = currentUser;
        }else{
            Member currentMember = (Member) session.getAttribute("currentMember");
//        User currentUser = (User) session.getAttribute("currentUser");
            if (currentMember != null) {
                user = UserType.MEMBER.toString();
                myLoginInstance = currentUser;
            }
        }
        //如果是公共日志,则判定字符串user
        if(instance.equals(COMMON_LOG)){
            instance  = thisLogInstance;
        }
//        String user = userType.toString();
        String action = actionType.toString();

        System.out.println("user"+user);

        code = listJudge(list,code);

        //与goodsTypeJudger一样,判定该次的user类型,传入不同mapper
        LogUsers logUsers = typeJudge(code, user, action, instance);

        try {
            if (code == 1) {
                System.out.println(whenCodeOne);
                logUsers.setTypeContent(action,whenCodeOne);
                logCommonService.saveLog(logUsers,myLoginInstance);
            } else if (code == 0) {
                System.err.println(whenCodeZero);
                logUsers.setTypeContent(action,whenCodeZero);
                logCommonService.saveLog(logUsers,myLoginInstance);
            }else if(code > 1){
                System.err.println(whenCodeMany);
                logUsers.setTypeContent(action,whenCodeMany);
                logCommonService.saveLog(logUsers,myLoginInstance);
            }else{
                System.err.println(whenOtherCase);
                logUsers.setTypeContent(action,whenOtherCase);
                logCommonService.saveLog(logUsers,myLoginInstance);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
        }
    }

    /**
     * 判定传入的list大小(一般用于查询获取时)
     * @param list
     * @param code
     */
    private int listJudge(List list,int code){
        if (list == null){
            return code;
        }
        int size = list.size();
        if (size == 0|| size > 1 || size == 1) {
            code = size;
            return code;
        }else{
            return code;
        }
    }

    /**
     * 判定用户操作类型及设置语句
     * @param code
     * @param actionType
     * @param instance
     */
    private LogUsers typeJudge(int code,String user,String actionType,String instance){
        instance = getInstance(instance);

        if (actionType.equals(LogEnum.SEARCH_ACTION.toString())){
            this.whenCodeOne = "搜索"+instance+"信息成功。数量:"+code;
            this.whenCodeZero = "搜索"+instance+"信息失败。数量"+code;
            this.whenCodeMany = "搜索"+instance+"信息成功。数量:"+code;
            this.whenOtherCase = "搜索"+instance+"信息异常。数量"+code;
        }
        if (actionType.equals(LogEnum.ADD_ACTION.toString())){
            this.whenCodeOne = "添加"+instance+"信息成功。数量:"+code;
            this.whenCodeZero = "添加"+instance+"信息失败。数量:"+code;
            this.whenCodeMany = "添加"+instance+"信息成功。数量:"+code;
            this.whenOtherCase = "添加"+instance+"信息异常。数量:"+code;
        }
        if (actionType.equals(LogEnum.UPDATE_ACTION.toString())){
            this.whenCodeOne = "更新"+instance+"信息成功。数量:"+code;
            this.whenCodeZero = "更新"+instance+"信息失败。数量:"+code;
            this.whenCodeMany = "更新"+instance+"信息成功。数量:"+code;
            this.whenOtherCase = "更新"+instance+"信息异常。数量:"+code;
        }
        if (actionType.equals(LogEnum.DELETE_ACTION.toString())){
            this.whenCodeOne = "删除"+instance+"信息成功。数量:"+code;
            this.whenCodeZero = "删除"+instance+"信息失败。数量:"+code;
            this.whenCodeMany = "删除"+instance+"信息成功。数量:"+code;
            this.whenOtherCase = "删除"+instance+"信息异常。数量:"+code;
        }
        if (actionType.equals(LogEnum.LOGIN_ACTION.toString())){
            this.whenCodeOne = user+"登录成功。数量:"+code;
            this.whenCodeZero = user+"登录失败。数量:"+code;
            this.whenCodeMany = user+"登录成功。数量:"+code;
            this.whenOtherCase = user+"登录异常。数量:"+code;
        }
        if (actionType.equals(LogEnum.LOGOUT_ACTION.toString())){
            this.whenCodeOne = user+"登出成功。数量:"+code;
            this.whenCodeZero = user+"登出失败。数量:"+code;
            this.whenCodeMany = user+"登出成功。数量:"+code;
            this.whenOtherCase = user+"登出异常。数量:"+code;
        }
        if(actionType.equals(LogEnum.BACKUP_ACTION.toString())){
            this.whenCodeOne = user+"备份数据库表成功。数量:"+code;
            this.whenCodeZero = user+"备份数据库表失败。数量:"+code;
            this.whenCodeMany = user+"备份数据库表成功。数量:"+code;
            this.whenOtherCase = user+"备份数据库表异常。数量:"+code;
        }
        if(user.equals(UserType.MEMBER.toString())){
            logCommonService.setLogTypeMapper(logMemberMapper);
            return new LogMember();
        }
        if(user.equals(UserType.ADMIN.toString())){
            logCommonService.setLogTypeMapper(logUserMapper);
            return new LogUser();
        }
        if(user.equals(UserType.SYSTEM_ADMIN.toString())){
            //TODO 系统管理员未设置
        }
        return null;
    }

    /**
     * 判定日志操作类型
     * @param logType 前端传入日志类型
     * @param logUser 管理员
     * @param logMember 会员
     * @return
     */
    public LogUsers logTypeJudger(String logType,LogUser logUser,LogMember logMember){
        if(logType.equals(ADMIN_TYPE)){
            logCommonService.setLogTypeMapper(logUserMapper);
            thisLogInstance = ADMIN_LOG;
            return logUser;
        }
        if (logType.equals(MEMBER_TYPE)){
            logCommonService.setLogTypeMapper(logMemberMapper);
            thisLogInstance = MEMBER_LOG;
            return logMember;
        }
        return null;
    }

    /**
     * 转义instance字符串用于存入数据库字段 如"查询石油焦数据成功"=>content
     * @param instance
     * @return
     */
    private String getInstance(String instance){
        switch (instance){
            case PETROLEUM_COKE:return "石油焦";
            case CALCINED_COKE:return "煅后焦";
            case MASPHALT:return "改质沥青";
            case ANODE:return "阳极";
            case MEMBER_LOG:return "会员日志";
            case ADMIN_LOG:return "管理员日志";
            case ADMIN_ROLE:return "管理员角色";
            case DB_TABlES:return "数据库表";
            default:return null;
        }
    }

}
