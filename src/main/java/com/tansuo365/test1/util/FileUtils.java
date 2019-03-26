package com.tansuo365.test1.util;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileUtils {

    /**
     * 创建数据库备份路径 如果路径不存在,则创建,如果路径后不包含分隔符,则创建
     * @param dbBackUpPath
     * @return
     */
    public String dbBackUpPathCreate(String dbBackUpPath){
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
}
