package com.tansuo365.test1.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tansuo365.test1.bean.PetroleumCoke;
import com.tansuo365.test1.mapper.PetroleumCokeMapper;
import com.tansuo365.test1.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("petroleumCoke")
public class PetroleumCokeController {

    @Resource
    private PetroleumCokeMapper petroleumCokeMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private RedisTemplate redisTemplate;
    /*动态获取数据*/
    @RequestMapping("selectPetroleumCokeSelective")
    public Map<String, Object> selectPetroleumCokeSelective(PetroleumCoke petroleumCoke, Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page, rows);
        List<PetroleumCoke> list = petroleumCokeMapper.selectPetroleumCokeSelective(petroleumCoke);
        PageInfo<PetroleumCoke> pageInfo = new PageInfo<PetroleumCoke>(list);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return map;
    }

    /*动态插入数据*/
    @RequestMapping("insertSelective")
    public Integer insertSelective(PetroleumCoke petroleumCoke) {
        return petroleumCokeMapper.insertSelective(petroleumCoke);
    }

    /*动态更新数据*/
    @RequestMapping("updateByPrimaryKeySelective")
    public Integer updateByPrimaryKeySelective(PetroleumCoke petroleumCoke){
        return petroleumCokeMapper.updateByPrimaryKeySelective(petroleumCoke);
    }

    /*删除数据*/
    @RequestMapping("deleteByPrimaryKey")
    public Integer deleteByPrimaryKey(Long id){
        return petroleumCokeMapper.deleteByPrimaryKey(id);
    }


    //查询所有石油焦,加入缓存机制
    @RequestMapping("selectAll")
    public List selectAllPetroleumCoke(){
//        List<PetroleumCoke> petroleumCokes = petroleumCokeMapper.selectAllPetroleumCoke();
//        map.put("petroleumCokes",petroleumCokes);
//        return map;

        //字符串的序列化器 redis
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        List petroleumCokes = redisService.lGet("petroleumCokes", 0, -1);
        System.out.println("查询缓存数据为"+petroleumCokes);
        if (0 == petroleumCokes.size()) {
            synchronized(this){
                System.out.println("进入第一个if");
                petroleumCokes = redisService.lGet("petroleumCokes", 0, -1);
                if(0 == petroleumCokes.size()){
                    System.out.println("第二个if显示了,表示缓存没有查到petroleumCokes.");
                    //缓存为空,查询数据库
                    petroleumCokes = petroleumCokeMapper.selectAllPetroleumCoke();
                    //把数据库查询出来的数据放入redis
                    redisService.lSet("petroleumCokes",petroleumCokes);
                }
            }

        }
        return petroleumCokes;

    }

}
