package com.tansuo365.test1.util;

import com.tansuo365.test1.bean.goods.PetroleumCoke;
import com.tansuo365.test1.entity.Goods;

public class PetroleumCokeGradeUtil {

    public static PetroleumCoke setGradeBySulfur(PetroleumCoke petroleumCoke) {
        Double sulfur = null;
        if (petroleumCoke.getSulfur() != null) {
            sulfur = petroleumCoke.getSulfur();
        }else{
            return petroleumCoke;
        }
        if (!(sulfur > 0.5)) {
            //1号 grade
            petroleumCoke.setGrade("1号");
        } else if (!(sulfur > 1.0)) {
            //2A
            petroleumCoke.setGrade("2A");
        } else if (!(sulfur > 1.5)) {
            //2B
            petroleumCoke.setGrade("2B");
        } else if (!(sulfur > 2.0)) {
            //3A
            petroleumCoke.setGrade("3A");
        } else if (!(sulfur > 3.0)) {
            //3B
            petroleumCoke.setGrade("3B");
        } else {
            //3B
            petroleumCoke.setGrade("3B");
        }
        return petroleumCoke;
    }
}
