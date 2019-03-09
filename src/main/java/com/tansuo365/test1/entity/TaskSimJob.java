package com.tansuo365.test1.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ApiModel(value="数据库备份任务",description="数据库备份任务")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskSimJob {

    //Job主键
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //Job是否启用
    private Integer enabled;
    //间隔时间
    private Integer interval_time;
    //Job相关的类全名
    private String job_class_name;
    //Job描述
    private String job_description;
    //Job全称
    private String job_name;
    //Job编号
    private String job_number;

}