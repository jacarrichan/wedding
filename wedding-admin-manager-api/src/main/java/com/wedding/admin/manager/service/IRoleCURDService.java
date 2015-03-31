package com.wedding.admin.manager.service;

import org.springframework.stereotype.Service;

import com.wedding.admin.manger.dto.RoleDto;
import com.wedding.common.model.RequestResult;
import com.wedding.common.model.Result;

@Service
public interface IRoleCURDService {

	Result<RoleDto> findById(String roleId);
	
	RequestResult create(RoleDto dto);
	
	RequestResult update(RoleDto dto);
	
	RequestResult delete(String roleId);
	
}
