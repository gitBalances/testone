package com.tansuo365.test1.bean.user;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="角色权限菜单",description="角色-权限菜单实体")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleMenu {
    private Integer id;

    private Integer menu_id;

    private Integer role_id;
}