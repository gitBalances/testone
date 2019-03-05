package com.tansuo365.test1.bean.user;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*管理员后台角色*/
@ApiModel(value="角色",description="角色实体")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	private Long id;

	private String name;

	private String desc_;
}