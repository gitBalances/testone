package com.tansuo365.test1.controller.db;

import com.github.pagehelper.PageInfo;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private FileUtils fileUtils;
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

    @ApiOperation(value = "分页获取数据库表列表根据数据库名", notes = "分页获取数据库表列表根据数据库名")
    @PostMapping("/getTables")
    public Map<String, Object> getTablesByDBName(HttpSession session, String dbName) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<TablesEntity> list = dbService.getAllTablesByDBName(dbName);
//
        List<TablesEntity> tablesEntities = tablesBriefUtils.settingBriefByAllList(list);
        logUtils.doLog(list, 0, LogEnum.SEARCH_ACTION, instance, session);
        map.put("rows",tablesEntities);
        map.put("total", list.size());
        return map;
    }

    /**
     * 批量备份
     *
     * @param session 用户session
     * @param names   表名数组
     * @return
     */
    @ApiOperation(value = "获取数据库表名集合备份数据库", notes = "获取数据库表名集合备份数据库")
    @PostMapping("/backup")
    public Integer dbBackUp(HttpSession session, @RequestParam(value = "names[]") String[] names) throws IllegalAccessException, InstantiationException {
        System.out.println("dbBackUpPath:" + dbBackUpPath);
        dbBackUpPath = fileUtils.dbBackUpPathCreate(dbBackUpPath);
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
     * 一次性备份全库到库名+时间.sql
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
     * 数据库整库还原 ok
     *
     * @param session //     * @param names
     * @return
     */
    @PostMapping("/dbRestoreAll")
//    public Integer dbRestore(HttpSession session, @RequestParam(value = "names[]") String[] names){
    public Integer dbRestoreAll(HttpSession session) {
        int count = 0;
        try {
            String backUpFile = dbBackUpPath + "/" + "tansuodb-20190420095949.sql";
            Process process = Runtime.getRuntime().exec("cmd /c mysql -h" + dbAddress + " -u" + dbUsername + " -p" + dbPassword + " " + dbName + " < " + backUpFile);
            count++;

//            for (int i = 0; i < names.length; i++) {
//                String backUpFile = dbBackUpPath + "/" + names[i];
//                Process process = Runtime.getRuntime().exec("cmd /c mysql -h"+dbAddress + " -u" + dbUsername + " -p" + dbPassword + " " + dbName + " < " + backUpFile);
//                count++;
//            }
//            if (count == names.length) {
            logUtils.doLog(null, count, LogEnum.BACKUP_ACTION, instance, session);
            return 1;
//            }

        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
//        return 0;
    }

    /**
     * 数据库整库还原 ok
     *
     * @param session //     * @param names
     * @return
     */
    @PostMapping("/dbRestoreSelect")
//    public Integer dbRestore(HttpSession session, @RequestParam(value = "names[]") String[] names) {
    public Integer dbRestore(HttpSession session) {
        int count = 0;
        try {
            String name = "user";
//            for (int i = 0; i < names.length; i++) {
                String backUpFile = dbBackUpPath + "/" + "user-20190420113807.sql";
                Process process = Runtime.getRuntime().exec("cmd /c mysql -h" + dbAddress + " -u" + dbUsername + " -p" + dbPassword + " " + dbName + " --table " + name + " < " + backUpFile);
                count++;
//            }
//            if (count == names.length) {
                logUtils.doLog(null, count, LogEnum.BACKUP_ACTION, instance, session);
                return 1;
//            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
//        return 0;
    }

    /**
     * 服务器中所有数据库的备份
     *
     * @param session //     * @param names
     * @return
     */
    @PostMapping("/backUpAllDBInMySQL")
    public Integer backUpAllDBInMySQL(HttpSession session) {
        String backUpFile = dbBackUpPath + "/" + "allDBBackup" + "-" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".sql";
        try {
            Process process = Runtime.getRuntime().exec("cmd /c mysqldump -h" + dbAddress + " -u" + dbUsername + " -p" + dbPassword + " " + "–all-databases" + " > " + backUpFile);
            logUtils.doLog(null, 1, LogEnum.BACKUP_ACTION, instance, session);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }


}
