package com.tansuo365.test1.unused;//package com.tansuo365.test1.util;
//
//import java.util.Iterator;
//import java.util.Map;
//
//
//public class BeanUtils {
//    /**
//     *  获取javabean的字段
//     * @param o 对象
//     * @return 字段数组
//     */
//    public static String[] getField(Object o) {
//        String[] bxgs = null;// 不需要修改字段
//        try {
//            if (o != null) {
//                String bxg = "";
//                Map sss = org.apache.commons.beanutils.BeanUtils.describe(o);
//                Iterator iter = sss.entrySet().iterator();
//                while (iter.hasNext()) {
//                    Map.Entry entry = (Map.Entry) iter.next();
//                    /*
//                     * //key 字段名称 val字段值 Object key = entry.getKey(); Object val
//                     * = entry.getValue();
//                     */
//                    if (entry.getValue() == null) {
//                        bxg += entry.getKey().toString() + ",";
//                    }
//
//                }
//
//                if (bxg.length() > 1) {
//                    bxgs = bxg.substring(0, bxg.length() - 1).split(",");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//        return bxgs;
//    }
//
//}
