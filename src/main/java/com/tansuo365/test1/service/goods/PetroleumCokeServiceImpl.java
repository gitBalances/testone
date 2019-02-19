//package com.tansuo365.test1.service.goods;
//
//import com.tansuo365.test1.bean.goods.PetroleumCoke;
//import com.tansuo365.test1.mapper.goods.PetroleumCokeMapper;
//import com.tansuo365.test1.util.PetroleumCokeGradeUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 石油焦service接口实现
// */
//@Service
//public class PetroleumCokeServiceImpl implements PetroleumCokeService{
//
//    @Resource
//    private PetroleumCokeMapper petroleumCokeMapper;
//
//    /**
//     * 根据主键删除元组
//     * @param id
//     * @return
//     */
//    @Override
//    public Integer delete(Long id) {
//        return petroleumCokeMapper.deleteByPrimaryKey(id);
//    }
//
//    /**
//     * 批量删除
//     * @param ids id数组
//     * @return
//     */
//    @Override
//    @Transactional
//    public Integer deleteBatchByPKs(Long[] ids){
//        int delState = petroleumCokeMapper.deleteBatchByPKArr(ids);
//        return delState;
//    }
//
//    //动态录入
//    @Override
//    public Integer addBySelective(PetroleumCoke petroleumCoke) {
//        return petroleumCokeMapper.insertSelective(petroleumCoke);
//    }
//
//    /**
//     * 批量录入
//     * @param list 批量录入 通过excel
//     * @return
//     */
//    @Override
//    @Transactional
//    public Integer insertBatchList(List<PetroleumCoke> list){
//        List newList = new ArrayList();
//        for(int i=0;i<list.size();i++){
//            newList.add(PetroleumCokeGradeUtil.setGradeBySulfur(list.get(i)));
//        }
//        int insertState = petroleumCokeMapper.insertBatch(newList);
//        return insertState;
//    }
//
//    /**
//     * 按需获取
//     * @param petroleumCoke
//     * @return
//     */
//    @Override
//    public List<PetroleumCoke> getBySelective(PetroleumCoke petroleumCoke) {
//        return petroleumCokeMapper.selectPetroleumCokeSelective(petroleumCoke);
//    }
//
//    /**
//     * 无条件 获取全部元组
//     * @return
//     */
//    @Override
//    public List<PetroleumCoke> getAll() {
//        return petroleumCokeMapper.selectAllPetroleumCoke();
//    }
//
//    /**
//     * 动态更新
//     * @param petroleumCoke
//     * @return
//     */
//    @Override
//    public Integer updateBySelective(PetroleumCoke petroleumCoke) {
//        return petroleumCokeMapper.updateByPrimaryKeySelective(petroleumCoke);
//    }
//
//
//}
