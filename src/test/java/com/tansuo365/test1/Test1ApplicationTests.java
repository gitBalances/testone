package com.tansuo365.test1;

import com.tansuo365.test1.mapper.goods.PetroleumCokeMapper;
import com.tansuo365.test1.service.redis.RedisService;
import com.tansuo365.test1.util.FileUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

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
    public void testDbPathFiles(){
        FileUtils.getFiles("C:/Users/ukyo/Desktop/test1-dbbackup-test"); //OK
    }


    @Test //测试redis存储
    public void contextLoads() {
        //字符串的序列化器 redis
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
//        System.out.println(petroleumCokes);


    }

    @Test //测试食用盐
    public void testSalt(){
        String password = "123123";
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";

        String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();

        System.out.printf("原始密码是 %s , 盐是： %s, 运算次数是： %d, 运算出来的密文是：%s ",password,salt,times,encodedPassword);

    }

    @Test //测试log存储时间
    public void testSetTime(){

        Date date = new Date();
        System.out.println(date);

    }

    public void testMenuId(){
    }

    @Test
    public void testDruid(){

    }


    @Test
    public void testUnicode(){
        String proA = "山东";
        String proB = "新疆";
        String proA_ = "东山";
        String proC = "山西";

        System.out.println("山东:"+proA.hashCode());
        System.out.println("东山:"+proA_.hashCode());
        System.out.println("新疆:"+proB.hashCode());

        System.out.println("山西:"+proC.hashCode());
    }



}

