package com.wedding.admin.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.admin.manager.cache.RoleCache;
import com.wedding.admin.manager.dao.RoleDao;
import com.wedding.admin.manager.pojo.Role;
import com.wedding.admin.manager.service.IRoleCURDService;
import com.wedding.admin.manger.dto.RoleDto;
import com.wedding.common.exception.SystemException;
import com.wedding.common.model.RequestResult;
import com.wedding.common.model.Result;
import com.wedding.common.util.BeanUtils;

@Service
public class RoleCURDServiceImpl implements IRoleCURDService {
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private RoleCache roleCache;

	@Override
	public Result<RoleDto> findById(String roleId) {
		
		return null;
	}

	@Override
	public RequestResult create(RoleDto dto) {
		try{
			Role role = BeanUtils.createBeanByTarget(dto, Role.class);
			roleDao.insert(role);
		}catch(Throwable e){
			throw new SystemException(e);
		}
		return new RequestResult(true, "角色创建成功");
	}

	@Override
	public RequestResult update(RoleDto dto) {
		
		return null;
	}

	@Override
	public RequestResult delete(String roleId) {
		roleDao.logicDelete(roleId);
		return new RequestResult(true, "角色删除成功");
	}

	
}
