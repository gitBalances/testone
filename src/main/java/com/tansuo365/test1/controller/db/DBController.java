package com.tansuo365.test1.controller.db;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.java.swing.plaf.windows.resources.windows;
import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.entity.TablesEntity;
import com.tansuo365.test1.service.db.IDBService;
import com.tansuo365.test1.util.FileUtils;
import com.tansuo365.test1.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@PropertySource(value = "classpath:dbbackup.properties")
@RestController
@RequestMapping("/admin/db")
public class DBController {

    @Autowired
    private IDBService dbService;
    @Autowired
    private LogUtils logUtils;
    @Autowired
    private FileUtils fileUtils;

    @Value("${db.type}")
    private String dbType;
    @Value("${db.address}")
    private String dbAddress;
    @Value("${db.port}")
    private String port;
    @Value("${db.name}")
    private String dbName;
    @Value("${db.username}")
    private String dbUsername;
    @Value("${db.password}")
    private String dbPassword;
    @Value("${db.os}")
    private String dbOs;
    //#备份文件存放位置
    @Value("${db.backup.path}")
    private String dbBackUpPath;

    private String instance = "DBTables";

    @RequestMapping("/getTables")
    public Map<String, Object> getTablesByDBName(HttpSession session,String dbName) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<TablesEntity> list = dbService.getAllTablesByDBName(dbName);
        PageInfo<TablesEntity> pageInfo = new PageInfo<TablesEntity>(list);
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        logUtils.doLog(list,0,LogEnum.SEARCH_ACTION,instance,session);
        return map;
    }

    /**
     * 批量备份
     * @param session 用户session
     * @param names 表名数组
     * @return
     */
    @RequestMapping("/backup")
    public Integer dbBackUp(HttpSession session, @RequestParam(value = "names[]") String[] names) throws IllegalAccessException, InstantiationException {
        System.out.println("dbBackUpPath:"+dbBackUpPath);
        dbBackUpPath = fileUtils.dbBackUpPathCreate(dbBackUpPath);
        int count = 0;
        try {
            for (int i = 0; i < names.length; i++) {
                String backUpFile = dbBackUpPath + "/" + names[i] + "-" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".sql";
                Process process = Runtime.getRuntime().exec("cmd /c mysqldump -h"+dbAddress + " -u" + dbUsername + " -p" + dbPassword + " " + dbName + " " + names[i] + " > " + backUpFile);
                count++;
            }
            if (count == names.length) {
                logUtils.doLog(null,count,LogEnum.BACKUP_ACTION,instance,session);
                //备份成功
                return 1;
            }

        } catch (IOException e) {
            e.printStackTrace();
            //备份失败
            return 0;
        }
        return 0;

    }

    /**
     * 一次性备份该库全部表
     * @param session
     * @return
     */
    @RequestMapping("/backupAllTables")
    public Integer dbBackUpAll(HttpSession session){
        String backUpFile = dbBackUpPath + "/" + dbName + "-" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".sql";
        try {
            Process process = Runtime.getRuntime().exec("cmd /c mysqldump -h"+dbAddress + " -u" + dbUsername + " -p" + dbPassword + " " +dbName +" > "+  backUpFile);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 数据库还原 TODO
     * @param session
     * @param names
     * @return
     */
    @RequestMapping("/dbRestore")
    public Integer dbRestore(HttpSession session, @RequestParam(value = "names[]") String[] names){
        int count = 0;
        try {
            for (int i = 0; i < names.length; i++) {
                String backUpFile = dbBackUpPath + "/" + names[i];
                Process process = Runtime.getRuntime().exec("cmd /c mysql -h"+dbAddress + " -u" + dbUsername + " -p" + dbPassword + " " + dbName + " < " + backUpFile);
                count++;
            }
            if (count == names.length) {
                logUtils.doLog(null,count,LogEnum.BACKUP_ACTION,instance,session);
                return 1;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }
}
