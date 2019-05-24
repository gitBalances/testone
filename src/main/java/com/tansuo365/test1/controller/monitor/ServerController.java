package com.tansuo365.test1.controller.monitor;

import com.tansuo365.test1.entity.server.Server;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(value = "服务器端口",tags = "服务器端口接口 ServerController", description = "服务器端口接口,查看磁盘,硬盘.")
@RestController
@RequestMapping("/host")
public class ServerController {
    @Autowired
    private Server server;

    @ApiOperation(value = "服务器信息监控", notes = "服务器信息监控信息")
    @RequiresPermissions(value = {"服务器监控"})
    @PostMapping("/serverInfo")
    public Map<String,Object> server()throws Exception{
//        Server server = new Server();
//        System.out.println("server.cpu.cpuNum1:"+server.getCpu().getCpuNum()); //0
        Map<String,Object> resultMap = new HashMap<String,Object>();
        server.copyTo();
        resultMap.put("server",server);
//        System.out.println("server.cpu.cpuNum2:"+server.getCpu().getCpuNum());//8
        return resultMap;
    }

}
