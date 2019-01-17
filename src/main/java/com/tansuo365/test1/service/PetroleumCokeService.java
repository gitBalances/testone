package com.tansuo365.test1.service;

import com.tansuo365.test1.mapper.PetroleumCokeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PetroleumCokeService {

    @Resource
    private PetroleumCokeMapper petroleumCokeMapper;

    //待加入事务

    /**
     * 批量删除
     * @param ids id数组
     * @return
     */
    public Integer deleteBatchByPKs(Long[] ids){
        System.err.println(ids[0]);
        int delState = 0;
        try {
            for (int i = 0; i < ids.length; i++) {
                Long id = ids[i];
                delState = petroleumCokeMapper.deleteByPrimaryKey(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delState;
    }


}
