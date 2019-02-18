package com.tansuo365.test1.bean;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleMenu {

    private Integer id;

    private Integer menu_id;

    private Integer role_id;

}