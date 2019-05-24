package com.tansuo365.test1.bean.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tansuo365.test1.entity.MyLoginInstance;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;


/**
 * 会员(前端使用者)
 */
@ApiModel(value="会员实体",description="会员实体")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable,MyLoginInstance {
    private Long id;

    private String username;

    private String password;

    private String company;

    private String truename;

    private Long phone;

    private Short sex;

    private String email;

    private Short member_type;

    private Short member_level;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastlogin_time;

    private String salt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Transient
    private String b_time; //起始时间 搜索用到

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Transient
    private String e_time; //结束时间 搜索用到
    @Transient
    private String activation;

    /*扩展字段*/

    private Byte expand_2;

    private Byte expand_3;

    private Byte expand_4;

    /*扩展字段*/

    //返回实例id,再shiro中使用,这里返回null 弃用
    @Override
    public Integer getInstanceId() {
//        return Math.toIntExact(id);
        return null;
    }

    @Override
    public String getInstanceName() {
        return username;
    }

    @Override
    public String getInstancePassword() {
        return password;
    }

    @Override
    public String getInstanceSalt() {
        return salt;
    }

    @Override
    public void setInstanceName(String username) {
        this.username = username;
    }

    @Override
    public void setInstancePassword(String password) {
        this.password = password;
    }

    @Override
    public void setInstanceSalt(String salt) {
        this.salt = salt;
    }
}