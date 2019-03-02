package com.tansuo365.test1.controller.log;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.bean.log.LogMember;
import com.tansuo365.test1.bean.log.LogUser;
import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.entity.LogUsers;
import com.tansuo365.test1.service.log.ILogCommonService;
import com.tansuo365.test1.util.LogUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询日志的公用controller TODO 现在只有搜索,并无其它方法
 */
@Api(value = "查询日志的公用控制层", description = "日志信息")
@RestController
@RequestMapping("/admin/syslog/{logType}")
public class LogCommonController {

    private String instance = "syslog";
    @Autowired
    private LogUtils logUtils;
    @Autowired
    private ILogCommonService logCommonService;

    @ApiOperation(value="分页查询日志信息", notes="分页查询日志信息listLogSelectiveByPage")
    @RequestMapping("/listLogSelectiveByPage")
    @RequiresPermissions(value={"系统日志","会员日志"},logical = Logical.OR)
    public Map<String, Object> getLogSelectiveByPage(HttpSession session, @PathVariable String logType, LogUser logUser, LogMember logMember,Integer page, Integer rows){
        Map<String, Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page, rows);
        List<LogUsers> list = logCommonService.getLogSelective(logUtils.logTypeJudger(logType,logUser,logMember));
        PageInfo<LogUsers> pageInfo = new PageInfo<LogUsers>(list);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        //执行log日志
        logUtils.doLog(list, 0, LogEnum.SEARCH_ACTION, instance, session);
        return map;
    }



}
