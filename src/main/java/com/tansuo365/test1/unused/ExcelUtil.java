package com.tansuo365.test1.unused;//package com.tansuo365.test1.util;
//
//import com.google.protobuf.ServiceException;
//import org.apache.poi.hssf.usermodel.HSSFDateUtil;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.commons.lang3.math.NumberUtils;
//
//import java.io.InputStream;
//import java.lang.reflect.Field;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//
//public class ExcelUtil {
//
//    static private Workbook wb;
//    static private Sheet sheet;
//
//    /**
//     * @param in          ：承载着Excel的输入流
//     * @param sheetIndex  ：要导入的工作表序号
//     * @param skipRows    跳过读取的条数,默认为0
//     * @param entityClass ：List中对象的类型（Excel中的每一行都要转化为该类型的对象）
//     * @param fieldMap    ：Excel中的中文列头和类的英文属性的对应关系Map
//     * @param fileName    ：文件名
//     * @return ：List
//     * @MethodName : excelToList
//     * @Description : 将Excel转化为List
//     */
//    public static <T> List<T> excelToList(InputStream in, int sheetIndex, int skipRows, Class<T> entityClass,
//                                          List<FieldDefine> fieldMap, String fileName) throws ServiceException{
//        // 定义要返回的list
//        List<T> resultList = new ArrayList<>();
//        try {
//            // 根据Excel数据源创建WorkBook
//            String postfix = fileName.substring(fileName.lastIndexOf("."),
//                    fileName.length());
//            if (postfix.equals(".xls")) {
//                // 针对 2003 Excel 文件
//                wb = new HSSFWorkbook(in);
//                //获取excel文件某个sheet
//                sheet = wb.getSheetAt(sheetIndex);
//            } else {
//                // 针对2007 Excel 文件
//                wb = new XSSFWorkbook(in);
//                sheet = wb.getSheetAt(sheetIndex);
//            }
//            // 获取工作表
//            Integer rowCount = sheet.getLastRowNum();
//            Row firstRow = sheet.getRow(skipRows);
//            String[] excelFieldNames = new String[firstRow.getLastCellNum()];
//            // 获取Excel中的列名
//            for (int i = 0; i < firstRow.getLastCellNum(); i++) {
//                Cell currentCell = firstRow.getCell(i);
//                excelFieldNames[i] = currentCell.getStringCellValue();
//            }
//            // 将列名和列号放入Map中,这样通过列名就可以拿到列号
//            HashMap<String, Integer> colMap = new HashMap<>();
//            for (int i = 0; i < excelFieldNames.length; i++) {
//                colMap.put(excelFieldNames[i], firstRow.getCell(i).getColumnIndex());
//            }
//            // 将sheet转换为list
//            for (int i = 1; i <= rowCount; i++) {
//                // 新建要转换的对象，每一行都可以理解为一个对象
//                T entity = entityClass.newInstance();
//                // 给对象中的字段赋值
//                for (FieldDefine field : fieldMap) {
//                    // 获取中文字段名
//                    String cnName = field.title;
//                    // 获取英文字段名
//                    String enName = field.fieldName;
//                    // 根据中文字段名获取列号
//                    int col = colMap.get(enName);
//                    // 获取当前单元格中的内容
//                    String content = getCellFormatValue(sheet.getRow(i).getCell(col));
//                    // 给对象赋值
//                    setFieldValueByName(enName, content, entity);
//                }
//                resultList.add(entity);
//            }
//        } catch (Exception e) {
//        }
//        return resultList;
//    }
//
//    public static <T> List<T> excelToList(InputStream in, Class<T> entityClass,
//                                          List<FieldDefine> fieldMap, String fileName) throws ServiceException {
//        return excelToList(in, 0, 0, entityClass, fieldMap, fileName);
//    }
//
//    /**
//     * @param in
//     * @param skipRows    跳过读取的条数,默认为0
//     */
//    public static <T> List<T> excelToList(InputStream in, int skipRows, Class<T> entityClass,
//                                          List<FieldDefine> fieldMap, String fileName) throws ServiceException {
//        return excelToList(in, 0, skipRows, entityClass, fieldMap, fileName);
//    }
//
//    /**
//     * @param fieldName 字段名
//     * @param clazz     包含该字段的类
//     * @return 字段
//     * @MethodName : getFieldByName
//     * @Description : 根据字段名获取字段
//     */
//    private static Field getFieldByName(String fieldName, Class<?> clazz) {
//        // 拿到本类的所有字段
//        Field[] selfFields = clazz.getDeclaredFields();
//        // 如果本类中存在该字段，则返回
//        for (Field field : selfFields) {
//            if (field.getName().equals(fieldName)) {
//                return field;
//            }
//        }
//        // 否则，查看父类中是否存在此字段，如果有则返回
//        Class<?> superClazz = clazz.getSuperclass();
//        if (superClazz != null && superClazz != Object.class) {
//            return getFieldByName(fieldName, superClazz);
//        }
//        // 如果本类和父类都没有，则返回空
//        return null;
//    }
//
//    /**
//     * 根据Cell类型设置数据
//     */
//    private static String getCellFormatValue(Cell cell) {
//        String cellvalue;
//        if (cell != null) {
//            // 判断当前Cell的Type
//            switch (cell.getCellType()) {
//                // 如果当前Cell的Type为NUMERIC
//                case Cell.CELL_TYPE_NUMERIC:
//                case Cell.CELL_TYPE_FORMULA: {
//                    // 判断当前的cell是否为Date
//                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
//                        Date date = cell.getDateCellValue();
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                        cellvalue = sdf.format(date);
//                    } else {
//                        // 如果是纯数字取得当前Cell的数值
//                        cellvalue = String.valueOf(cell.getNumericCellValue());
//                    }
//                    break;
//                }
//                // 如果当前Cell的Type为STRIN
//                case Cell.CELL_TYPE_STRING:
//                    // 取得当前的Cell字符串
//                    cellvalue = cell.getRichStringCellValue().getString();
//                    break;
//                default:
//                    // 默认的Cell值
//                    cellvalue = " ";
//            }
//        } else {
//            cellvalue = "";
//        }
//        return cellvalue;
//
//    }
//
//    /**
//     * @param fieldName  字段名
//     * @param fieldValue 字段值
//     * @param entity          对象
//     * @MethodName : setFieldValueByName
//     * @Description : 根据字段名给对象的字段赋值
//     */
//    private static void setFieldValueByName(String fieldName, Object fieldValue, Object entity)
//            throws Exception {
//
//        //通过反射得到成员变量
//        Field field = getFieldByName(fieldName, entity.getClass());
//        if (field != null) {
//            //暴力反射：获取本类private修饰的成员变量
//            field.setAccessible(true);
//            // 获取成员变量类型
//            Class<?> fieldType = field.getType();
//
//            // 根据字段类型给字段赋值
//            if (String.class == fieldType) {
//                field.set(entity, String.valueOf(fieldValue));
//            } else if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
//                field.set(entity, NumberUtils.createNumber(fieldValue.toString()).intValue());
//            } else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
//                field.set(entity, NumberUtils.createNumber(fieldValue.toString()).longValue());
//            } else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
//                field.set(entity, NumberUtils.createNumber(fieldValue.toString()).floatValue());
//            } else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
//                field.set(entity, NumberUtils.createNumber(fieldValue.toString()).shortValue());
//            } else if ((Double.TYPE == fieldType) || (Double.class == fieldType)) {
//                field.set(entity, NumberUtils.createNumber(fieldValue.toString()).doubleValue());
//            } else if (Character.TYPE == fieldType) {
//                if ((fieldValue != null) && (fieldValue.toString().length() > 0)) {
//                    field.set(entity, Character.valueOf(fieldValue.toString().charAt(0)));
//                }
//            } else if (Date.class == fieldType) {
//                field.set(entity, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fieldValue.toString()));
//            } else {
//                field.set(entity, fieldValue);
//            }
//        } else {
//            throw new ServiceException("获取excel数据异常，请检查excel数据是否异常");
//        }
//    }
//
//    public static class FieldDefine {
//
//        private String title;
//
//        private String fieldName;
//
//        public FieldDefine(String title, String fieldName) {
//            this.fieldName = fieldName;
//            this.title = title;
//        }
//    }
//
//}
