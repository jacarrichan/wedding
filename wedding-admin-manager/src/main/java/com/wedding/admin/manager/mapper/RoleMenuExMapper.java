package com.wedding.admin.manager.mapper;

import java.util.List;

import com.wedding.admin.manger.dto.RoleMenuMappingDto;

public interface RoleMenuExMapper {

	List<RoleMenuMappingDto> getRoleMenuByRoleId(String roleId);
}
