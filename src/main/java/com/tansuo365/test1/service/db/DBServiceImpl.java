package com.tansuo365.test1.service.db;

import com.tansuo365.test1.entity.TablesEntity;
import com.tansuo365.test1.mapper.db.TablesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DBServiceImpl implements IDBService {

    @Resource
    private TablesMapper tablesMapper;

    @Override
    public List<TablesEntity> getAllTablesByDBName(String dbName) {
        return tablesMapper.getTablesInDB(dbName);
    }
}
