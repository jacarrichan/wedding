package com.wedding.admin.manager.service;

import org.springframework.stereotype.Service;

import com.wedding.admin.manger.dto.AdminMenuFunctionDto;
import com.wedding.common.model.ListResult;
import com.wedding.common.model.RequestResult;

@Service
public interface IMenuService {

	ListResult<AdminMenuFunctionDto> findAll();

	RequestResult saveOrUpdate(AdminMenuFunctionDto menu);

	RequestResult deleteMenu(String menuId);
}
