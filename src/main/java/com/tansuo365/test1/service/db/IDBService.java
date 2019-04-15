package com.tansuo365.test1.service.db;


import com.tansuo365.test1.entity.TablesEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDBService {

    List<TablesEntity> getAllTablesByDBName(@Param("dbName") String dbName);
}
