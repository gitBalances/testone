package com.tansuo365.test1.bean.user;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 前端EasyUI的菜单节点及权限路径数据库表
 */
@ApiModel(value="权限菜单",description="权限菜单实体")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EMenu {
    private Integer id;

    private String icon;

    private String name;

    private Integer state;

    private String url;

    private Integer p_id;
}