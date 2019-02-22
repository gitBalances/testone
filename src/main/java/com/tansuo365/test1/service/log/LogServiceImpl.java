package com.tansuo365.test1.service.log;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.bean.log.LogMember;
import com.tansuo365.test1.bean.log.LogUser;
import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.mapper.LogUserMapper;
import com.tansuo365.test1.service.user.UserService;
import com.tansuo365.test1.util.CodeJudgerUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志service实现
 */
@Service
public class LogServiceImpl implements LogService{

    private String instance = "系统日志";
    @Resource
    private UserService userService;
    @Resource
    private LogUserMapper logUserMapper;
    @Resource
    private CodeJudgerUtils codeJudgerUtils;

    @Override
    public void saveUserLog(LogUser log) {
        Integer userId = userService.getByName((String) SecurityUtils.getSubject().getPrincipal()).getId();
        log.setUser_id(userId);
        logUserMapper.insertSelective(log);
    }

    //动态获取log
    @Override
    public List<LogUser> getLogSelective(LogUser log) {
        return logUserMapper.getBySelective(log);
    }

    @Override
    public Map<String, Object> getLogSelectiveByPage(LogUser logUser, Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page, rows);
        List<LogUser> logList = logUserMapper.getBySelective(logUser);
        PageInfo<LogUser> pageInfo = new PageInfo<LogUser>(logList);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        int code = 0;
        codeJudgerUtils.whichCodeIsOK(logList,code,LogEnum.SEARCH_ACTION.toString(),instance);
        return map;
    }




    /*--------------------------------------------*/
    @Override
    public void saveMemberLog(LogMember log) {

    }
}
