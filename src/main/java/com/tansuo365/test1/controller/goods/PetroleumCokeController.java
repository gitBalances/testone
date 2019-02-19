package com.tansuo365.test1.controller.goods;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tansuo365.test1.bean.goods.PetroleumCoke;
import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.mapper.goods.PetroleumCokeMapper;
import com.tansuo365.test1.service.goods.IGoodsCommonService;
//import com.tansuo365.test1.service.goods.PetroleumCokeServiceImpl;
import com.tansuo365.test1.service.redis.RedisService;
import com.tansuo365.test1.util.CodeJudgerUtils;
import com.tansuo365.test1.util.PetroleumCokeGradeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/petroleumCoke")
public class PetroleumCokeController {

    private String instance = "石油焦";

    //    @Autowired
//    private PetroleumCokeServiceImpl petroleumCokeService;
    @Autowired
    private IGoodsCommonService goodsCommonService;
    @Resource
    private PetroleumCokeMapper petroleumCokeMapper;

    @Autowired
    private RedisService redisService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CodeJudgerUtils codeJudgerUtils;


    /*动态获取数据*/
    @RequestMapping("/selectSelective")
    public Map<String, Object> selectSelective(PetroleumCoke petroleumCoke, Integer page, Integer rows) {
        goodsCommonService.setGoodsTypeMapper(petroleumCokeMapper);
        Map<String, Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page, rows);
        List<Goods> list = goodsCommonService.getBySelective(petroleumCoke);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        int code = 0;
        codeJudgerUtils.whichCodeIsOK(list,code,LogEnum.SEARCH_ACTION.toString(), instance);
        return map;
    }

    /*动态插入数据*/
    //插入数据时根据sulfur字段判定品级并更新品级字段grade(特有)
    @RequestMapping("/insertSelective")
    public Integer insertSelective(PetroleumCoke petroleumCoke) {
        goodsCommonService.setGoodsTypeMapper(petroleumCokeMapper);
        Goods goods = PetroleumCokeGradeUtil.setGradeBySulfur(petroleumCoke);
        int code = goodsCommonService.addBySelective(goods);
        codeJudgerUtils.whichCodeIsOK(null,code, LogEnum.ADD_ACTION.toString(), instance);
        return code;
    }

    /*动态更新数据*/
    @RequestMapping("/updateByPrimaryKeySelective")
    public Integer updateByPrimaryKeySelective(PetroleumCoke petroleumCoke) {
        goodsCommonService.setGoodsTypeMapper(petroleumCokeMapper);
        int code = goodsCommonService.updateBySelective(petroleumCoke);
        codeJudgerUtils.whichCodeIsOK(null,code, LogEnum.UPDATE_ACTION.toString(), instance);
        return code;
    }

    /*删除数据*/
    @RequestMapping("/deleteByPrimaryKey")
    public Integer deleteByPrimaryKey(Long id) {
        goodsCommonService.setGoodsTypeMapper(petroleumCokeMapper);
        int code = goodsCommonService.delete(id);
        codeJudgerUtils.whichCodeIsOK(null,code,LogEnum.DELETE_ACTION.toString(),instance);
        return code;
    }

    /*批量删除*/
    @RequestMapping("/deleteBatchByPKs")
    public Integer deleteBatch(@RequestParam(value = "ids[]") Long[] ids) {
        goodsCommonService.setGoodsTypeMapper(petroleumCokeMapper);
        int code = goodsCommonService.deleteBatchByPKs(ids);
        codeJudgerUtils.whichCodeIsOK(null,code,LogEnum.DELETE_ACTION.toString(),instance);
        return code;
    }

    //    @Cacheable(value = "petroleumCokes") 不能加入缓存
    /*选取所有石油焦信息*/
    @RequestMapping("/selectAll")
    public List<Goods> selectAllPetroleumCoke() {
        goodsCommonService.setGoodsTypeMapper(petroleumCokeMapper);
        List<Goods> all = goodsCommonService.getAll();
        int code = 0;
        codeJudgerUtils.whichCodeIsOK(all,code,LogEnum.SEARCH_ACTION.toString(),instance);
        return all;
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
