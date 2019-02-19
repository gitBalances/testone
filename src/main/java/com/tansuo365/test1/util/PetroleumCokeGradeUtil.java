package com.tansuo365.test1.util;

import com.tansuo365.test1.bean.goods.PetroleumCoke;
import com.tansuo365.test1.entity.Goods;

public class PetroleumCokeGradeUtil {

    public static Goods setGradeBySulfur(Goods goods){

        Double sulfur = goods.getSulfur();
        if(!(sulfur > 0.5)){
            //1号 grade
            goods.setGrade("1号");
        }else if(!(sulfur > 1.0)){
            //2A
            goods.setGrade("2A");
        }else if(!(sulfur > 1.5)){
            //2B
            goods.setGrade("2B");
        }else if(!(sulfur > 2.0)){
            //3A
            goods.setGrade("3A");
        }else if(!(sulfur > 3.0)){
            //3B
            goods.setGrade("3B");
        }else{
            //3B
            goods.setGrade("3B");
        }
        return goods;
    }
}
