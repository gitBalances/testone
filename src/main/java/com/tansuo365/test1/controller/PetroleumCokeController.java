package com.tansuo365.test1.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tansuo365.test1.bean.PetroleumCoke;
import com.tansuo365.test1.mapper.PetroleumCokeMapper;
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


    @RequestMapping("selectAll")
    public Map<String, Object> selectAllPetroleumCoke(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<PetroleumCoke> petroleumCokes = petroleumCokeMapper.selectAllPetroleumCoke();
        map.put("petroleumCokes",petroleumCokes);
        return map;
    }

}
