package com.tansuo365.test1.util;

import com.tansuo365.test1.entity.TablesEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@PropertySource(value = "classpath:db-tables.properties")
public class TablesBriefUtils {

    @Value("${dbtbl.table1.name}")
    private String tblName1;
    @Value("${dbtbl.table1.breif}")
    private String tblBrief1;
    @Value("${dbtbl.table2.name}")
    private String tblName2;
    @Value("${dbtbl.table2.breif}")
    private String tblBrief2;
    @Value("${dbtbl.table3.name}")
    private String tblName3;
    @Value("${dbtbl.table3.breif}")
    private String tblBrief3;
    @Value("${dbtbl.table4.name}")
    private String tblName4;
    @Value("${dbtbl.table4.breif}")
    private String tblBrief4;
    @Value("${dbtbl.table5.name}")
    private String tblName5;
    @Value("${dbtbl.table5.breif}")
    private String tblBrief5;
    @Value("${dbtbl.table6.name}")
    private String tblName6;
    @Value("${dbtbl.table6.breif}")
    private String tblBrief6;
    @Value("${dbtbl.table7.name}")
    private String tblName7;
    @Value("${dbtbl.table7.breif}")
    private String tblBrief7;
    @Value("${dbtbl.table8.name}")
    private String tblName8;
    @Value("${dbtbl.table8.breif}")
    private String tblBrief8;
    @Value("${dbtbl.table9.name}")
    private String tblName9;
    @Value("${dbtbl.table9.breif}")
    private String tblBrief9;
    @Value("${dbtbl.table10.name}")
    private String tblName10;
    @Value("${dbtbl.table10.breif}")
    private String tblBrief10;
    @Value("${dbtbl.table11.name}")
    private String tblName11;
    @Value("${dbtbl.table11.breif}")
    private String tblBrief11;
    @Value("${dbtbl.table12.name}")
    private String tblName12;
    @Value("${dbtbl.table12.breif}")
    private String tblBrief12;
    @Value("${dbtbl.table13.name}")
    private String tblName13;
    @Value("${dbtbl.table13.breif}")
    private String tblBrief13;
    @Value("${dbtbl.table14.name}")
    private String tblName14;
    @Value("${dbtbl.table14.breif}")
    private String tblBrief14;
    @Value("${dbtbl.table15.name}")
    private String tblName15;
    @Value("${dbtbl.table15.breif}")
    private String tblBrief15;
    @Value("${dbtbl.table16.name}")
    private String tblName16;
    @Value("${dbtbl.table16.breif}")
    private String tblBrief16;
    @Value("${dbtbl.table17.name}")
    private String tblName17;
    @Value("${dbtbl.table17.breif}")
    private String tblBrief17;
    @Value("${dbtbl.table18.name}")
    private String tblName18;
    @Value("${dbtbl.table18.breif}")
    private String tblBrief18;
    @Value("${dbtbl.table19.name}")
    private String tblName19;
    @Value("${dbtbl.table19.breif}")
    private String tblBrief19;
    @Value("${dbtbl.table20.name}")
    private String tblName20;
    @Value("${dbtbl.table20.breif}")
    private String tblBrief20;

    public TablesBriefUtils() {
    }

    /*nameMap Singleton*/
    private static Map nameMap = null;
    private static synchronized void syncInitNameMap(){
        if(nameMap==null){
            nameMap=new HashMap();
            System.out.println("init nameMap in TablesBriefUtils OK");
        }
    }
    public void initTables() {
        if (nameMap == null) {
            syncInitNameMap();
        }
        nameMap.put(tblName1, tblBrief1);
        nameMap.put(tblName2, tblBrief2);
        nameMap.put(tblName3, tblBrief3);
        nameMap.put(tblName4, tblBrief4);
        nameMap.put(tblName5, tblBrief5);
        nameMap.put(tblName6, tblBrief6);
        nameMap.put(tblName7, tblBrief7);
        nameMap.put(tblName8, tblBrief8);
        nameMap.put(tblName9, tblBrief9);
        nameMap.put(tblName10, tblBrief10);

        nameMap.put(tblName11, tblBrief11);
        nameMap.put(tblName12, tblBrief12);
        nameMap.put(tblName13, tblBrief13);
        nameMap.put(tblName14, tblBrief14);
        nameMap.put(tblName15, tblBrief15);
        nameMap.put(tblName16, tblBrief16);
        nameMap.put(tblName17, tblBrief17);
        nameMap.put(tblName18, tblBrief18);
        nameMap.put(tblName19, tblBrief19);
        nameMap.put(tblName20, tblBrief20);

    }
    /*end nameMap Singleton*/

    //设置简介根据返回的数据库表对象的list集合
    public List<TablesEntity> settingBriefByAllList(List list) {
        initTables();
        List<TablesEntity> newlyTableList = new ArrayList<>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            TablesEntity tablesEntity = (TablesEntity) iterator.next();
            String tableName = tablesEntity.getTableName();
            tablesEntity.setTableBrief(getBriefByName(tableName));
            newlyTableList.add(tablesEntity);
        }
        return newlyTableList;
    }

    //根据表名获取简介
    private String getBriefByName(String tableName) {

        String result = "";
        Set<String> nameSet = nameMap.keySet();
        for (String tblName : nameSet) {
            if (tblName.equals(tableName)) {
                result = nameMap.get(tblName).toString();
                break;
            }
        }
        return result;
    }
}
