package com.tansuo365.test1.mapper;

import com.tansuo365.test1.bean.user.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*权限Mapper层*/
@Mapper
public interface PermissionMapper {

	int deleteByPrimaryKey(Long id);

	int insert(Permission record);

	int insertSelective(Permission record);

	Permission selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);

}