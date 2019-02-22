package com.tansuo365.test1.bean.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * 会员(前端使用者)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

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

}