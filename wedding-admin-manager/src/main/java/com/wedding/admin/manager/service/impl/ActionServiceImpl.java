package com.wedding.admin.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.admin.manager.cache.RoleActionCache;
import com.wedding.admin.manager.dao.ActionDao;
import com.wedding.admin.manager.pojo.Action;
import com.wedding.admin.manager.service.IActionService;
import com.wedding.admin.manger.dto.ActionDto;
import com.wedding.common.model.ListResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.util.BeanUtils;
import com.wedding.common.util.StringUtils;

@Service
public class ActionServiceImpl implements IActionService {
	
	@Autowired
	private ActionDao actionDao;
	
	@Autowired
	private RoleActionCache roleActionCache;

	@Override
	public ListResult<ActionDto> findAll() {
		List<Action> actions = actionDao.findAll();
		List<ActionDto> results = BeanUtils.createBeanListByTarget(actions, ActionDto.class);
		return new ListResult<>(results);
	}

	@Override
	public RequestResult saveOrUpdate(ActionDto actionDto) {
		Action action = BeanUtils.createBeanByTarget(actionDto, Action.class);
		if(StringUtils.isEmpty(action.getId())) {
			actionDao.insert(action);
		} else {
			actionDao.updateByPrimaryKey(action);
		}
		roleActionCache.refresh();
		return new RequestResult(true, "保存成功！");
	}

	@Override
	public RequestResult deleteAction(String actionId) {
		actionDao.logicDelete(actionId);
		roleActionCache.refresh();
		return new RequestResult(true, "删除成功！");
	}

}
