package com.tansuo365.test1.service.log;

import com.tansuo365.test1.bean.log.LogMember;
import com.tansuo365.test1.bean.log.LogUser;
import com.tansuo365.test1.mapper.LogUserMapper;
import com.tansuo365.test1.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 日志service实现
 */
@Service
public class LogServiceImpl implements LogService{

    @Resource
    private UserService userService;
    @Resource
    private LogUserMapper logUserMapper;

    @Override
    public void saveUserLog(LogUser log) {
        Long userId = userService.getByName((String) SecurityUtils.getSubject().getPrincipal()).getId();
        log.setUser_id(Integer.parseInt(userId.toString()));
        logUserMapper.insertSelective(log);
    }

    //动态获取log
    @Override
    public List<LogUser> getLogSelective(LogUser log) {
        return logUserMapper.getBySelective(log);
    }


    /*--------------------------------------------*/
    @Override
    public void saveMemberLog(LogMember log) {

    }
}
