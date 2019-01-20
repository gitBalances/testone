package com.tansuo365.test1.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tansuo365.test1.bean.PetroleumCoke;
import com.tansuo365.test1.mapper.PetroleumCokeMapper;
import com.tansuo365.test1.service.PetroleumCokeService;
import com.tansuo365.test1.service.RedisService;
import com.tansuo365.test1.util.PetroleumCokeGradeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private PetroleumCokeService petroleumCokeService;
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
    //插入数据时根据sulfur字段判定品级并更新品级字段grade
    @RequestMapping("insertSelective")
    public Integer insertSelective(PetroleumCoke petroleumCoke) {
        petroleumCoke = PetroleumCokeGradeUtil.setGradeBySulfur(petroleumCoke);
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

    /*批量删除*/
    @RequestMapping("deleteBatchByPKs")
    public Integer delete(@RequestParam(value = "ids[]") Long[] ids){
        System.err.println(ids[0]);
        return petroleumCokeService.deleteBatchByPKs(ids);
    }

//    @Cacheable(value = "petroleumCokes") 不能加入缓存
    /*选取所有石油焦信息*/
    @RequestMapping("selectAll")
    public List selectAllPetroleumCoke(){
        System.err.println("进入selectAll,表示要走数据库了~");
        List<PetroleumCoke> petroleumCokes = petroleumCokeMapper.selectAllPetroleumCoke();
        return petroleumCokes;
    }
    //查询所有石油焦,加入缓存机制
//    @RequestMapping("selectAll")
//    public List selectAllPetroleumCoke(){
////        List<PetroleumCoke> petroleumCokes = petroleumCokeMapper.selectAllPetroleumCoke();
////        map.put("petroleumCokes",petroleumCokes);
////        return map;
//
//        //字符串的序列化器 redis
//        RedisSerializer redisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(redisSerializer);
//        List petroleumCokes = redisService.lGet("petroleumCokes", 0, -1);
//        System.out.println("查询缓存数据为"+petroleumCokes);
//        if (0 == petroleumCokes.size()) {
//            synchronized(this){
//                System.out.println("进入第一个if");
//                petroleumCokes = redisService.lGet("petroleumCokes", 0, -1);
//                if(0 == petroleumCokes.size()){
//                    System.out.println("第二个if显示了,表示缓存没有查到petroleumCokes.");
//                    //缓存为空,查询数据库
//                    petroleumCokes = petroleumCokeMapper.selectAllPetroleumCoke();
//                    //把数据库查询出来的数据放入redis
//                    redisService.lSet("petroleumCokes",petroleumCokes);
//                }
//            }
//
//        }
//        return petroleumCokes;
//
//    }




}
