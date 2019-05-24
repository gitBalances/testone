package com.tansuo365.test1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TablesEntity {
    //表名
    private String tableName;
    //对应的备份的备份文件
    private ArrayList<String> backupFiles;
    //对应的该表的简介
    @Transient
    private String tableBrief;

}
