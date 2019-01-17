package com.tansuo365.test1;

import com.tansuo365.test1.mapper.PetroleumCokeMapper;
import com.tansuo365.test1.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1ApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;
    @Resource
    PetroleumCokeMapper petroleumCokeMapper;
    @Autowired
    RedisService redisService;

    @Test
    public void contextLoads() {
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
        System.out.println(petroleumCokes);


    }

}

