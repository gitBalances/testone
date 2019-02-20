package com.tansuo365.test1.service.goods;

import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.mapper.goods.IGoodsCommonMapper;
import com.tansuo365.test1.util.PetroleumCokeGradeUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 货物curd公用service
 */
@Service
public class GoodsCommonService implements IGoodsCommonService{


    private IGoodsCommonMapper goodsCommonMapper;

    @Override
    public void setGoodsTypeMapper(IGoodsCommonMapper goodsTypeMapper) {
        this.goodsCommonMapper = goodsTypeMapper;
    }

    @Override
    public IGoodsCommonMapper getGoodsTypeMapper() {
        return goodsCommonMapper;
    }

    @Override
    public Integer delete(Long id) {
        return goodsCommonMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatchByPKs(Long[] ids) {
        return goodsCommonMapper.deleteBatchByPKArr(ids);
    }

    @Override
    public Integer addBySelective(Goods goods) {
        return goodsCommonMapper.insertSelective(goods);
    }

    @Override
    public Integer insertBatchList(List<Goods> list) {
        return goodsCommonMapper.insertBatch(list);
    }

    @Override
    public List<Goods> getBySelective(Goods goods) {
        return goodsCommonMapper.selectGoodsSelective(goods);
    }

    @Override
    public List<Goods> getAll() {
        return goodsCommonMapper.selectAll();
    }

    @Override
    public Integer updateBySelective(Goods goods) {
        return goodsCommonMapper.updateByPrimaryKeySelective(goods);
    }
}
