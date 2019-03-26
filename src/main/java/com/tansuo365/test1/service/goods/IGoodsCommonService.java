package com.tansuo365.test1.service.goods;

import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.mapper.goods.IGoodsCommonMapper;

import java.util.List;

/**
 * 货品公用service接口
 * {@link #setGoodsTypeMapper 设置货品类型}
 * {@link #delete 删除单条元组}
 * {@link #deleteBatchByPKs 批量删除}
 * {@link #addBySelective 单条动态录入}
 * {@link #insertBatchList 批量录入}
 */
public interface IGoodsCommonService {

    public void setGoodsTypeMapper(IGoodsCommonMapper goodsTypeMapper);

    public IGoodsCommonMapper getGoodsTypeMapper();

    //根据主键删除
    public Integer delete(Long id);

    //根据主键批量删除
    public Integer deleteBatchByPKs(Long[] ids);

    //录入(动态)
    public Integer addBySelective(Goods goods);

    //批量录入
    public Integer insertBatchList(List<Goods> list);

    //按需获取
    public List<Goods> getBySelective(Goods goods);

    //选择全部
    public List<Goods> getAll();

    //根据会员等级获取数据量
    public List<Goods> getAllByLevel(Integer member_level);

    //选择全部根据货品实例(针对ECharts使用)
    public List<Goods> getGoodsByType(Goods goods);

    //动态更新
    public Integer updateBySelective(Goods goods);
}
