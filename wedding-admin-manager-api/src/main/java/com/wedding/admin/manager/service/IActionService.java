package com.wedding.admin.manager.service;

import org.springframework.stereotype.Service;

import com.wedding.admin.manger.dto.ActionDto;
import com.wedding.common.model.ListResult;
import com.wedding.common.model.RequestResult;

@Service
public interface IActionService {

	ListResult<ActionDto> findAll();

	RequestResult saveOrUpdate(ActionDto action);

	RequestResult deleteAction(String actionId);

}
