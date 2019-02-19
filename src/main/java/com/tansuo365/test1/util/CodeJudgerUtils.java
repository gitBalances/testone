package com.tansuo365.test1.util;

import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.bean.log.LogUser;
import com.tansuo365.test1.service.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CodeJudgerUtils {

    private String whenCodeOne;
    private String whenCodeZero;
    private String whenCodeMany;
    private String whenOtherCase;

    @Autowired
    private LogService logService;

    /**
     * 判定CRUD并执行log操作
     * @param list 查询数据list
     * @param code 返回code
     * @param actionType 执行操作类型
     * @param instance 实体类型
     */
    public void whichCodeIsOK(List list, int code, String actionType, String instance){
        code = listJudge(list,code);
        typeJudge(code,actionType,instance);

        if (code == 1) {
            System.out.println(whenCodeOne);
            logService.saveUserLog(new LogUser(actionType, whenCodeOne));
        } else if (code == 0) {
            System.err.println(whenCodeZero);
            logService.saveUserLog(new LogUser(actionType, whenCodeZero));
        }else if(code > 1){
            System.err.println(whenCodeMany);
            logService.saveUserLog(new LogUser(actionType, whenCodeMany));
        }else{
            System.err.println(whenOtherCase);
            logService.saveUserLog(new LogUser(actionType, whenOtherCase));
        }
    }

    /**
     * 判定传入的list大小(一般用于查询获取时)
     * @param list
     * @param code
     */
    public int listJudge(List list,int code){
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
    public void typeJudge(int code,String actionType,String instance){

        if (actionType.equals(LogEnum.SEARCH_ACTION.toString())){
            this.whenCodeOne = "搜索"+instance+"信息成功。数量:"+code;
            this.whenCodeZero = "搜索"+instance+"信息失败。数量"+code;
            this.whenCodeMany = "搜索"+instance+"信息成功。数量:"+code;
            this.whenOtherCase = "搜索"+instance+"信息异常。数量"+code;
        }
        if (actionType.equals(LogEnum.ADD_ACTION.toString())){
            this.whenCodeOne = "添加"+instance+"信息成功。";
            this.whenCodeZero = "添加"+instance+"信息失败。";
            this.whenCodeMany = "添加"+instance+"信息成功。数量:"+code;
            this.whenOtherCase = "添加"+instance+"信息异常。";
        }
        if (actionType.equals(LogEnum.UPDATE_ACTION.toString())){
            this.whenCodeOne = "更新"+instance+"信息成功。";
            this.whenCodeZero = "更新"+instance+"信息失败。";
            this.whenCodeMany = "更新"+instance+"信息成功。数量:"+code;
            this.whenOtherCase = "更新"+instance+"信息异常。";
        }
        if (actionType.equals(LogEnum.DELETE_ACTION.toString())){
            this.whenCodeOne = "删除"+instance+"信息成功。";
            this.whenCodeZero = "删除"+instance+"信息失败。";
            this.whenCodeMany = "删除"+instance+"信息成功。数量:"+code;
            this.whenOtherCase = "删除"+instance+"信息异常。";
        }
        if (actionType.equals(LogEnum.LOGIN_ACTION.toString())){
            this.whenCodeOne = "用户"+instance+"登录成功。";
            this.whenCodeZero = "用户"+instance+"登录失败。";
            this.whenCodeMany = "用户"+instance+"登录成功。数量:"+code;
            this.whenOtherCase = "用户"+instance+"登录异常。";
        }
        if (actionType.equals(LogEnum.LOGOUT_ACTION.toString())){
            this.whenCodeOne = "用户"+instance+"登出成功。";
            this.whenCodeZero = "用户"+instance+"登出失败。";
            this.whenCodeMany = "用户"+instance+"登出成功。数量:"+code;
            this.whenOtherCase = "用户"+instance+"登出异常。";
        }
    }



}
