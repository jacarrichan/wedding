package com.wedding.admin.manager.mapper;

import java.util.List;

import com.wedding.admin.manger.dto.RoleActionDto;

public interface RoleActionExMapper {

	List<RoleActionDto> getRoleActionByRoleId(String roleId);

}
