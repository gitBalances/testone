package com.tansuo365.test1.bean;

import com.tansuo365.test1.entity.MyLoginInstance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;


import java.io.Serializable;

/*管理员*/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable,MyLoginInstance {

	private Long id;

	private String name;

	private String password;

	private String salt;

	@Transient
	private String roles; //展示用户角色

	@Override
	public String getInstanceName() {
		return name;
	}

	@Override
	public String getInstancePassword() {
		return password;
	}

	@Override
	public String getInstanceSalt() {
		return salt;
	}
}