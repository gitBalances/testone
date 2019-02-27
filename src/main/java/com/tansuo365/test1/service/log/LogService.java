//package com.tansuo365.test1.service.log;
//
//import com.tansuo365.test1.bean.log.LogMember;
//import com.tansuo365.test1.bean.log.LogUser;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//import java.util.Map;
//
///**
// * 系统日志Service接口
// */
//public interface LogService {
//
//    //存储或修改管理员日志
//    public void saveUserLog(LogUser log);
//
//    //动态获取日志
//    public List<LogUser> getLogSelective(LogUser log);
//
//    //获取log并分页
//    public Map<String, Object> getLogSelectiveByPage(LogUser logUser, Integer page, Integer rows);
//
//    /*--------------------------------------------*/
//    //存储或修改会员日志
//    public void saveMemberLog(LogMember log, HttpSession session);
//
//
//}
