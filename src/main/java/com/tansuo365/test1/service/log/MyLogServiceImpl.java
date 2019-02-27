package com.tansuo365.test1.service.log;

import com.tansuo365.test1.bean.log.UserType;
import com.tansuo365.test1.bean.member.Member;
import com.tansuo365.test1.entity.LogUsers;
import com.tansuo365.test1.entity.MyLoginInstance;
import com.tansuo365.test1.mapper.log.ILogCommonMapper;
import com.tansuo365.test1.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class MyLogServiceImpl implements ILogCommonService {

    private ILogCommonMapper logCommonMapper;
    @Autowired
    private UserService userService;

    @Override
    public void setLogTypeMapper(ILogCommonMapper logCommonMapper) {
        this.logCommonMapper = logCommonMapper;
    }

    @Override
    public ILogCommonMapper getLogTypeMapper() {
        return logCommonMapper;
    }

    @Override
    public Integer saveLog(LogUsers logUsers, MyLoginInstance myLoginInstance) throws IllegalAccessException, InstantiationException {
        System.out.println("loginInstance:"+myLoginInstance);
        System.out.println("logUsers"+logUsers);
        logUsers.setUsersId(myLoginInstance.getInstanceId());
        return logCommonMapper.insertSelective(logUsers);
    }

    @Override
    public List<LogUsers> getLogSelective(LogUsers logUsers) {
        return logCommonMapper.getBySelective(logUsers);
    }

    @Override
    public Map<String, Object> getLogSelectiveByPage(LogUsers logUsers, Integer page, Integer rows) {
        return null;
    }

}
