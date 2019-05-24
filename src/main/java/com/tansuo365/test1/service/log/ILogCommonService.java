package com.tansuo365.test1.service.log;

import com.tansuo365.test1.entity.LogUsers;
import com.tansuo365.test1.entity.MyLoginInstance;
import com.tansuo365.test1.mapper.log.ILogCommonMapper;

import java.util.List;
import java.util.Map;

public interface ILogCommonService {

    public void setLogTypeMapper(ILogCommonMapper goodsTypeMapper);

    public ILogCommonMapper getLogTypeMapper();

    public Integer saveLog(LogUsers logUsers,MyLoginInstance myLoginInstance) throws IllegalAccessException, InstantiationException;

    //动态获取日志
    public List<LogUsers> getLogSelective(LogUsers logUsers);

    //获取log并分页
    public Map<String, Object> getLogSelectiveByPage(LogUsers logUsers, Integer page, Integer rows);

    /*--------------------------------------------*/

}
