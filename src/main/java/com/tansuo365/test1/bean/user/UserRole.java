package com.tansuo365.test1.bean.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*管理员角色*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {

	private Long id;

	private Long uid;

	private Long rid;

}