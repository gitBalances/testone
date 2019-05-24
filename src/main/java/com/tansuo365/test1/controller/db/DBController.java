package com.tansuo365.test1.controller.db;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Tables;
import com.tansuo365.test1.bean.log.LogEnum;
import com.tansuo365.test1.entity.TablesEntity;
import com.tansuo365.test1.service.db.IDBService;
import com.tansuo365.test1.util.FileUtils;
import com.tansuo365.test1.util.LogUtils;
import com.tansuo365.test1.util.TablesBriefUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Api(value = "后端页面控制层", tags = "后端页面控制接口 BackEndPageController", description = "主要作为后端页面的页面跳转控制")
@PropertySource(value = "classpath:dbbackup.properties")
@RestController
@RequestMapping("/admin/db")
public class DBController {

    @Autowired
    private IDBService dbService;
    @Autowired
    private LogUtils logUtils;
    @Autowired
    private TablesBriefUtils tablesBriefUtils;

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
    @Value("${db.backup.dateformat}")
    private String dbDateFormat;

    private String instance = "DBTables";

    @ApiOperation(value = "分页获取数据库表列表根据数据库名", notes = "分页获取数据库表列表根据数据库名,简介,以及其备份的数据库表")
    @PostMapping("/getTables")
    public Map<String, Object> getTablesByDBName(HttpSession session, String dbName) {
//    public Map<String, Object> getTablesByDBName() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<TablesEntity> list = dbService.getAllTablesByDBName(dbName);

        List<TablesEntity> tablesEntities = tablesBriefUtils.settingBriefByAllList(list);
        //记录日志
        logUtils.doLog(list, 0, LogEnum.SEARCH_ACTION, instance, session);

        //从备份路径获取备份文件名集合
        ArrayList<String> backupFiles = FileUtils.getFiles(dbBackUpPath);
        //填充bean TableEntity 的备份数据集合,返回新的集合
        List newTablesEntities = FileUtils.getNewTablesEntities(tablesEntities, backupFiles);
        //
        System.out.println("backupFiles:" + backupFiles);
        map.put("rows", newTablesEntities);
        map.put("total", list.size());
        return map;
    }

    /**
     * 批量备份 (备份选中) OK
     *
     * @param session 用户session
     * @param names   表名数组
     * @return
     */
    @ApiOperation(value = "获取数据库表名集合备份数据库", notes = "获取数据库表名集合备份数据库")
    @PostMapping("/backup")
    public Integer dbBackUp(HttpSession session, @RequestParam(value = "names[]") String[] names) throws IllegalAccessException, InstantiationException {
        System.out.println("dbBackUpPath:" + dbBackUpPath);
        dbBackUpPath = FileUtils.dbBackUpPathCreate(dbBackUpPath);
        int count = 0;
        try {
            for (int i = 0; i < names.length; i++) {
                String backUpFile = dbBackUpPath + "/" + names[i] + "-" + new SimpleDateFormat(dbDateFormat).format(new Date()) + ".sql";
                Process process = Runtime.getRuntime().exec("cmd /c mysqldump -h" + dbAddress + " -u" + dbUsername + " -p" + dbPassword + " " + dbName + " " + names[i] + " > " + backUpFile);
                count++;
            }
            if (count == names.length) {
                logUtils.doLog(null, count, LogEnum.BACKUP_ACTION, instance, session);
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
     * 一次性备份全库到库名+时间.sql  OK
     *
     * @param session
     * @return
     */
    @ApiOperation(value = "根据数据库名备份全库", notes = "根据数据库名备份全库")
    @PostMapping("/backupAll")
    public Integer dbBackUpAll(HttpSession session) {
        String backUpFile = dbBackUpPath + "/" + dbName + "-" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".sql";
        try {
            Process process = Runtime.getRuntime().exec("cmd /c mysqldump -h" + dbAddress + " -u" + dbUsername + " -p" + dbPassword + " " + dbName + " > " + backUpFile);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 数据库整库还原 TODO
     *
     * @param session //     * @param names
     * @return
     */
    @PostMapping("/dbRestoreAll")
    public Integer dbRestore(HttpSession session, @RequestParam(value = "name") String name) {
//    public Integer dbRestoreAll(HttpSession session) {
        try {
            String backUpFile = dbBackUpPath + "/" + name + ".sql";
            Process process = Runtime.getRuntime().exec("cmd /c mysql -h" + dbAddress + " -u" + dbUsername + " -p" + dbPassword + " " + dbName + " < " + backUpFile);

            logUtils.doLog(null, 1, LogEnum.BACKUP_ACTION, instance, session);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 数据库选择还原 can not use it
     *
     * @param session //     * @param names
     * @return
     */
//    @PostMapping("/dbRestoreSelect")
////    public Integer dbRestore(HttpSession session, @RequestParam(value = "names[]") String[] names) {
//    public Integer dbRestore(HttpSession session) {
//        int count = 0;
//        try {
//            String name = "user";
////            for (int i = 0; i < names.length; i++) {
//            String backUpFile = dbBackUpPath + "/" + "user-20190420113807.sql";
//            Process process = Runtime.getRuntime().exec("cmd /c mysql -h" + dbAddress + " -u" + dbUsername + " -p" + dbPassword);
//            Process process1 = Runtime.getRuntime().exec("cmd /c use " + dbName);
//            Process process11 = Runtime.getRuntime().exec("cmd /c drop table " + name);
//            Process process2 = Runtime.getRuntime().exec("cmd /c source " + backUpFile);
//            count++;
////            }
////            if (count == names.length) {
//            logUtils.doLog(null, count, LogEnum.BACKUP_ACTION, instance, session);
//            return 1;
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            return 0;
//        }
////        return 0;
//    }

    /**
     * 服务器中所有数据库的备份  Can not use it
     *
     //     * @param session //     * @param names
     * @return
     */
//    @PostMapping("/backUpAllDBInMySQL")
//    public Integer backUpAllDBInMySQL(HttpSession session) {
//        String backUpFile = dbBackUpPath + "/" + "allDBBackup" + "-" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".sql";
//        try {
//            Process process = Runtime.getRuntime().exec("cmd /c mysqldump -h" + dbAddress + " -u" + dbUsername + " -p" + dbPassword + " " + "–all-databases" + " > " + backUpFile);
//            logUtils.doLog(null, 1, LogEnum.BACKUP_ACTION, instance, session);
//            return 1;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }


}
