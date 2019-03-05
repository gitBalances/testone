package com.tansuo365.test1.bean.member;

import com.tansuo365.test1.entity.MyLoginInstance;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Date create_time;

    private Date update_time;

    private Date lastlogin_time;

    private String salt;

    private Byte expand_2;

    private Byte expand_3;

    private Byte expand_4;

    @Override
    public Integer getInstanceId() {
        return Math.toIntExact(id);
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