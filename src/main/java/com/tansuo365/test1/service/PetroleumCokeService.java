package com.tansuo365.test1.service;

import com.tansuo365.test1.bean.PetroleumCoke;
import com.tansuo365.test1.mapper.PetroleumCokeMapper;
import com.tansuo365.test1.util.PetroleumCokeGradeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetroleumCokeService {

    @Resource
    private PetroleumCokeMapper petroleumCokeMapper;

    /**
     * 批量删除
     * @param ids id数组
     * @return
     */
    @Transactional
    public Integer deleteBatchByPKs(Long[] ids){
        int delState = petroleumCokeMapper.deleteBatchByPKArr(ids);
        return delState;
    }

    /**
     * 批量录入
     * @param list 批量录入 通过excel
     * @return
     */
    @Transactional
    public Integer insertBatchList(List<PetroleumCoke> list){
        List newList = new ArrayList();
        for(int i=0;i<list.size();i++){
            newList.add(PetroleumCokeGradeUtil.setGradeBySulfur(list.get(i)));
        }
        int insertState = petroleumCokeMapper.insertBatch(newList);
        return insertState;
    }


}
