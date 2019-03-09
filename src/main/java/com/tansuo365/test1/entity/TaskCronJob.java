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
public class TaskCronJob {

    //Job主键
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //Job是否启用
    private Integer enabled;
    //cron表达式
    private String cron;
    //Job相关的类全名
    private String job_class_name;
    //Job描述
    private String job_description;
    //Job名称
    private String job_name;
    //Job编号
    private String job_number;

    public TaskCronJob(String cron,String job_name,String job_class_name,String job_description,String job_number){
        this.cron = cron;
        this.job_name = job_name;
        this.job_class_name = job_class_name;
        this.job_description = job_description;
        this.job_number = job_number;
    }

}