package com.wedding.admin.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wedding.admin.manager.dao.RoleActionDao;
import com.wedding.admin.manager.pojo.RoleAction;
import com.wedding.admin.manager.service.IRoleActionService;
import com.wedding.admin.manger.dto.RoleActionDto;
import com.wedding.common.model.ListResult;
import com.wedding.common.model.RequestResult;

@Service
public class RoleActionServiceImpl implements IRoleActionService {

	@Autowired
	private RoleActionDao roleActionDao;
	
	@Transactional
	public RequestResult updateRoleAction(String roleId, List<String> actionIdList) {
		roleActionDao.logicDeleteRoleActionByRoleId(roleId);
		for(String actionId : actionIdList) {
			RoleAction roleAction = new RoleAction();
			roleAction.setRoleId(roleId);
			roleAction.setActionId(actionId);
			roleActionDao.insert(roleAction);
		}
		return new RequestResult(true, "更新功能权限成功！");
	}

	@Override
	public ListResult<RoleActionDto> getRoleActionByRoleId(String roleId) {
		List<RoleActionDto> roleActions = roleActionDao.getRoleActionByRoleId(roleId);
		return new ListResult<>(roleActions);
	}

}
