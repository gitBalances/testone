package com.tansuo365.test1.controller.goods;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tansuo365.test1.bean.goods.Anode;
import com.tansuo365.test1.bean.goods.CalcinedCoke;
import com.tansuo365.test1.bean.goods.MAsphalt;
import com.tansuo365.test1.bean.goods.PetroleumCoke;
import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.bean.member.Member;
import com.tansuo365.test1.bean.user.User;
import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.service.goods.GoodsCommonService;
import com.tansuo365.test1.util.GoodsUtils;
import com.tansuo365.test1.util.LogUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "货品信息CRUD公用控制层", tags = "货品信息公用控制接口 GoodsController",description = "货品信息CRUD")
@RestController
@RequestMapping("/goods/{goodsType}")
public class GoodsController {

    @Autowired
    private GoodsCommonService goodsCommonService;

    @Autowired
    private GoodsUtils goodsUtils;


    @Autowired
    private LogUtils logUtils;


    /**
     * 动态获取goods数据
     *
     * @param goodsType
     * @param petroleumCoke
     * @param calcinedCoke
     * @param mAsphalt
     * @param anode
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/selectSelective")
    public Map<String, Object> selectSelective(HttpSession session, @PathVariable String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode, Integer page, Integer rows) throws IllegalAccessException, InstantiationException {
        Map<String, Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page, rows);
        List<Goods> list = goodsCommonService.getBySelective(goodsUtils.goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        logUtils.doLog(list, 0, LogEnum.SEARCH_ACTION, goodsType, session);
        return map;

    }

    /**
     * TODO 在加入数据时,如果是石油焦,需要进行grade字段的触发更新
     *
     * @param goodsType
     * @param petroleumCoke
     * @param calcinedCoke
     * @param mAsphalt
     * @param anode
     * @return
     */
    @RequestMapping("/insertSelective")
    public Integer insertSelective(HttpSession session, @PathVariable String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode) throws IllegalAccessException, InstantiationException {
        int code = goodsCommonService.addBySelective(goodsUtils.goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
        logUtils.doLog(null, code, LogEnum.SEARCH_ACTION, goodsType, session);
        return code;

    }

    /**
     * 动态更新数据 TODO 同样的,如果是石油焦,则需要判定sulfur字段,再进行grade字段的更新.
     *
     * @param goodsType
     * @param petroleumCoke
     * @param calcinedCoke
     * @param mAsphalt
     * @param anode
     * @return
     */
    @RequestMapping("updateByPKSelective")
    public Integer updateByPKSelective(HttpSession session, @PathVariable String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode) throws IllegalAccessException, InstantiationException {
        int code = goodsCommonService.updateBySelective(goodsUtils.goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
        logUtils.doLog(null, code, LogEnum.SEARCH_ACTION, goodsType, session);
        return code;
    }

    /**
     * 根据主键删除数据
     *
     * @param goodsType
     * @param id
     * @return
     */
    @RequestMapping("/deleteByPK")
    public Integer delByPK(HttpSession session, @PathVariable String goodsType, Long id) throws IllegalAccessException, InstantiationException {
        goodsUtils.goodsTypeJudger(goodsType, null, null, null, null);
        int code = goodsCommonService.delete(id);
        logUtils.doLog(null, code, LogEnum.SEARCH_ACTION, goodsType, session);
        return code;
    }

    /**
     * 批量删除
     *
     * @param goodsType
     * @param ids
     * @return
     */
    @RequestMapping("/deleteBatchByPKs")
    public Integer delBatch(HttpSession session, @PathVariable String goodsType, @RequestParam(value = "ids[]") Long[] ids) throws IllegalAccessException, InstantiationException {
        goodsUtils.goodsTypeJudger(goodsType, null, null, null, null);
        int code = goodsCommonService.deleteBatchByPKs(ids);
        logUtils.doLog(null, code, LogEnum.SEARCH_ACTION, goodsType, session);
        return code;
    }

    /**
     * TEST
     *
     * @param goodsType
//     * @param petroleumCoke
//     * @param calcinedCoke
//     * @param mAsphalt
//     * @param anode
     * @return
     */
    @RequestMapping(value = "/testselectSelective")
//    public List<Goods> testselectSelective(HttpSession session, @PathVariable String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode) throws IllegalAccessException, InstantiationException {
    public List<Goods> testselectSelective(HttpSession session, @PathVariable String goodsType, @RequestParam String member_level) throws IllegalAccessException, InstantiationException {
        goodsUtils.goodsTypeJudger(goodsType, null, null, null, null);
        System.out.println("goodsType:" + goodsType);
        System.out.println("member_level:" + member_level);
        List<Goods> all = goodsCommonService.getAll();
//      List<Goods> list = goodsCommonService.getBySelective(goodsUtils.goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
//    logUtils.doLog(all, 0, LogEnum.SEARCH_ACTION, goodsType, session);
        return all;
    }

    /**
     * 无差别选择全部指定货品信息(针对ECharts使用,前端用户,如果为null则返回null)
     *
     * @param goodsType
     * @return
     */
    @RequestMapping("/selectGoodsByType")
    public List<Goods> selectAll(HttpSession session, @PathVariable String goodsType, PetroleumCoke petroleumCoke, CalcinedCoke calcinedCoke, MAsphalt mAsphalt, Anode anode) throws IllegalAccessException, InstantiationException {
        Member currentMember = (Member) session.getAttribute("currentMember");
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentMember == null && currentUser == null) {
            return null;
        } else {
            List<Goods> list = goodsCommonService.getBySelective(goodsUtils.goodsTypeJudger(goodsType, petroleumCoke, calcinedCoke, mAsphalt, anode));
            logUtils.doLog(list, 0, LogEnum.SEARCH_ACTION, goodsType, session);
            return list;
        }
    }


}
