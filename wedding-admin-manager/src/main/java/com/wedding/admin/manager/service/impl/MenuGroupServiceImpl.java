package com.wedding.admin.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.admin.manager.dao.MenuGroupDao;
import com.wedding.admin.manager.pojo.MenuGroup;
import com.wedding.admin.manager.service.IMenuGroupService;
import com.wedding.admin.manger.dto.MenuGroupDto;
import com.wedding.common.model.ListResult;
import com.wedding.common.util.BeanUtils;

@Service
public class MenuGroupServiceImpl implements IMenuGroupService {

	@Autowired
	private MenuGroupDao groupDao;
	
	@Override
	public ListResult<MenuGroupDto> findAll() {
		List<MenuGroup> groups = groupDao.findAll();
		List<MenuGroupDto> results = BeanUtils.createBeanListByTarget(groups, MenuGroupDto.class);
		return new ListResult<MenuGroupDto>(results);
	}

}
