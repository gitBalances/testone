package com.tansuo365.test1.bean.log;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tansuo365.test1.entity.LogUsers;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.Date;

@ApiModel(value="会员日志实体",description="会员日志实体")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogMember implements LogUsers {

    private Integer id;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Transient
    private String b_time; //起始时间 搜索用到

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Transient
    private String e_time; //结束时间 搜索用到

    private String type;

    @ManyToOne
    private Long member_id;

    @Override
    public void setTypeContent(String type, String content) {
        this.type = type;
        this.content = content;
    }

    @Override
    public void setUsersId(Integer id) {
        this.member_id = Long.valueOf(id);
    }
}