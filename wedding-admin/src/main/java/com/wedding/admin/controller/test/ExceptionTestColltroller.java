package com.wedding.admin.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedding.common.constants.BusinessExceptionDiscription;
import com.wedding.common.exception.BusinessException;
import com.wedding.common.exception.SystemException;
import com.wedding.common.model.RequestResult;

@Controller
@RequestMapping(value="/exception")
public class ExceptionTestColltroller {

	
	@ResponseBody
	@RequestMapping(value="/tbusiness.do")
	public RequestResult throwBussinessException(){
		int a = 1;
		if(a == 1) {
			throw new BusinessException(BusinessExceptionDiscription.USER_ERROR_001);
				
		}
		return new RequestResult(true, "测试结束");
	}
	
	@ResponseBody
	@RequestMapping(value="/tsystem.do")
	public RequestResult throwSystemException(){
		int a = 1;
		if(a == 1) {
			throw new SystemException(BusinessExceptionDiscription.USER_ERROR_001.getMessage());
		}
		return new RequestResult(true, "测试结束");
	}
}
