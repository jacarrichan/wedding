package com.wedding.admin.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wedding.admin.manager.pojo.MenuGroup;

public interface MenuGroupExMapper {

	public List<MenuGroup> findMenuGroupByAdminAccountId(@Param("accountId")String accountId, @Param("roleId")String roleId);
	
}
