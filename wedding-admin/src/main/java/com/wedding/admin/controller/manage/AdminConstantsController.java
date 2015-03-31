package com.wedding.admin.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedding.admin.manager.service.IRoleManagerService;
import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;

/**
 * @author rkzhang
 */
@Controller
@RequestMapping(value="/manager/constants")
public class AdminConstantsController {

	@Autowired
	private IRoleManagerService roleManagerService;
	
	@ResponseBody
	@RequestMapping(value="/getRole.do")
	public ListResult<Pair<String, String>> getRole() {
		return roleManagerService.getRoles();
	}	

}
