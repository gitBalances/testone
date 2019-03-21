package com.tansuo365.test1.mapper.db;

import com.tansuo365.test1.entity.TablesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TablesMapper {

    List<TablesEntity> getTablesInDB(@Param("dbName") String dbName);
}
