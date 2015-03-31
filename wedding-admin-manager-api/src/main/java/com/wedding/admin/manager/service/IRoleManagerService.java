package com.wedding.admin.manager.service;

import com.wedding.admin.manger.dto.RoleActionDto;
import com.wedding.admin.manger.dto.RoleDto;
import com.wedding.admin.manger.dto.RoleMenuMappingDto;
import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;
import com.wedding.common.model.RequestResult;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rkzhang on 14-9-25.
 */
@Service
public interface IRoleManagerService {

    public List<RoleDto> findAll();
    
    public ListResult<RoleMenuMappingDto> getRoleMenuByRoleId(String roleId);
    
    public ListResult<RoleActionDto> getRoleActionByRoleId(String roled);

	public RequestResult updateRoleMenu(String roleId, List<String> menuIdList);
	
	ListResult<Pair<String, String>> getRoles();

	public RequestResult updateRoleAction(String roleId, List<String> actionIdList);
}
