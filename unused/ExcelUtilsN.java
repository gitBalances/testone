package com.tansuo365.test1.unused;//package com.tansuo365.test1.util;
//
//import java.io.InputStream;
//import java.util.*;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelUtilsN {
//    //读取两种格式的Excel内容
//    /**
//     * @description: 读取两种格式的Excel
//     * @param stream 输入流
//     * @param extString excel后缀
//     * @param columns 列名称
//     * @author: baipengfei
//     * @since: 2018年3月21日 下午12:01:44
//     */
//    public static List<Map<String, String>> readExcelByStream(InputStream stream, String extString, String[] columns) throws Exception {
//        Workbook wb = getExcelWb(stream, extString);
//        List<Map<String, String>> list = null;
//        String cellData = null;
//        if(wb != null){
//            //用来存放表中数据
//            list = new ArrayList<Map<String,String>>();
//            //获取第一个sheet
//            Sheet sheet = wb.getSheetAt(0);
//            //获取最大行数
//            int rownum = sheet.getPhysicalNumberOfRows();
//            //获取第一行
//            Row row = sheet.getRow(0);
//            //获取最大列数
//            int column = row.getPhysicalNumberOfCells();
//            for(int i = 1; i < rownum; i++){
//                Map<String, String> map = new LinkedHashMap<String, String>();
//                row = sheet.getRow(i);
//                if(row != null){
//                    for(int j = 0; j < column; j++){
//                        cellData = String.valueOf(getCellFormatValue(row.getCell(j)));
//                        map.put(columns[j], cellData);
//                    }
//                }else {
//                    break;
//                }
//                list.add(map);
//            }
//
//        }
//        return list;
//    }
//
//    //获取Workbook对象
//    public static Workbook getExcelWb(InputStream stream, String extString) throws Exception {
//        Workbook wb = null;
//        if(stream == null){
//            return null;
//        }
//
//        if(".xls".equals(extString)){
//            return wb = new HSSFWorkbook(stream);
//        }else if(".xlsx".equals(extString)){
//            return wb = new XSSFWorkbook(stream);
//        }else{
//            return wb = null;
//        }
//
//    }
//
//    //获取单元格值
//    public static Object getCellFormatValue(Cell cell) {
//        Object cellValue = null;
//        if(cell != null){
//            switch (cell.getCellType()) {
//                case Cell.CELL_TYPE_NUMERIC:{
//                    cellValue = String.valueOf(cell.getNumericCellValue());
//                    break;
//                }
//
//                case Cell.CELL_TYPE_FORMULA:{
//                    if(DateUtil.isCellDateFormatted(cell)){
//                        cellValue = cell.getDateCellValue();
//                    }else {
//                        cellValue = String.valueOf(cell.getNumericCellValue());
//                    }
//                    break;
//                }
//
//                case Cell.CELL_TYPE_STRING:{
//                    cellValue = cell.getRichStringCellValue();
//                    break;
//                }
//
//                default:
//                    cellValue = "";
//
//            }
//        }else {
//            cellValue = "";
//        }
//        return cellValue;
//    }
//}
////需引入poi-version.jar和poi-ooxml-version.jar