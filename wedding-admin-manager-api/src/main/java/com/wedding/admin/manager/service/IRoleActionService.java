package com.wedding.admin.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wedding.admin.manger.dto.RoleActionDto;
import com.wedding.common.model.ListResult;
import com.wedding.common.model.RequestResult;

@Service
public interface IRoleActionService {
	
	ListResult<RoleActionDto> getRoleActionByRoleId(String roleId);

	RequestResult updateRoleAction(String roleId, List<String> actionIdList);
	
}
