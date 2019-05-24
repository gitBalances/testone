package com.tansuo365.test1.util;

import com.tansuo365.test1.entity.TablesEntity;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileUtils {

    /**
     * 创建数据库备份路径 如果路径不存在,则创建,如果路径后不包含分隔符,则创建
     * @param dbBackUpPath
     * @return
     */
    public static String dbBackUpPathCreate(String dbBackUpPath){
        File saveFile = new File(dbBackUpPath);
        if(!saveFile.exists()){
            System.out.println("backupPath->mkdirs");
            saveFile.mkdirs();
        }
        if(!dbBackUpPath.endsWith(File.separator)){
            dbBackUpPath = dbBackUpPath+File.separator;
        }
        return dbBackUpPath;
    }

    /**
     * 从数据库备份文件目录中获取文件名集合,去除了路径
     * @param dbBackUpPath
     * @return
     */
    public static ArrayList<String> getFiles(String dbBackUpPath) {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(dbBackUpPath);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
//              System.out.println("FileUtils文件：" + tempList[i]);
                String fileStr = tempList[i].getAbsolutePath();
                String subFileStr = fileStr.substring(fileStr.lastIndexOf(File.separator)+1, fileStr.length());
                files.add(subFileStr);
            }
            if (tempList[i].isDirectory()) {
              System.out.println("FileUtils文件夹：" + tempList[i]);
            }
        }
        return files;
    }

    /**
     * 获取新的集合,填充了bean:TableEntity中setBackupFiles集合
     * @param tablesEntities
     * @param backupFiles
     * @return
     */
    public static List getNewTablesEntities(List tablesEntities,List backupFiles){
        List<TablesEntity> newList = new ArrayList<TablesEntity>();
        for (int i = 0; i < tablesEntities.size(); i++) {
            TablesEntity tablesEntity = (TablesEntity) tablesEntities.get(i);
            String tableName = tablesEntity.getTableName();
            ArrayList<String> backupList = new ArrayList<String>();
            for (int j = 0; j < backupFiles.size(); j++) {
                String backupFile = (String) backupFiles.get(j);
                if (backupFile.startsWith(tableName)) {
                    backupList.add(backupFile);
                }
            }
            tablesEntity.setBackupFiles(backupList);
            newList.add(tablesEntity);
        }
        return newList;
    }


}
