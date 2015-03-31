package com.wedding.admin.manager.service;

import org.springframework.stereotype.Service;

import com.wedding.admin.manger.dto.MenuGroupDto;
import com.wedding.common.model.ListResult;

@Service
public interface IMenuGroupService {

	public ListResult<MenuGroupDto> findAll();
}
