package com.tansuo365.test1.service.log;

import com.tansuo365.test1.bean.log.LogUser;
import com.tansuo365.test1.bean.log.LogMember;

import java.util.List;

/**
 * 系统日志Service接口
 */
public interface LogService {

    //存储或修改管理员日志
    public void saveUserLog(LogUser log);

    //动态获取日志
    public List<LogUser> getLogSelective(LogUser log);


    /*--------------------------------------------*/
    //存储或修改会员日志
    public void saveMemberLog(LogMember log);


}
