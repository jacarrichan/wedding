package com.wedding.admin.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;
import com.wedding.order.service.IAppointcConstantsService;

/**
 * @author rkzhang
 */
@Controller
@RequestMapping(value="/appoint/constants")
public class AppointConstantsController {

	@Autowired
	private IAppointcConstantsService appointConstantsService;
	
	@ResponseBody
	@RequestMapping(value="/appointStatus.do")
	public ListResult<Pair<Integer, String>> getAppointStatus() {
		return appointConstantsService.getAppointStatus();
	}
}
