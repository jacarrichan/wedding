package com.wedding.admin.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;
import com.wedding.order.service.IOrderConstantsService;

/**
 * 
 * @author rkzhang
 *
 */
@Controller
@RequestMapping(value="/order/constants")
public class OrderConstantsController {

	@Autowired
	private IOrderConstantsService orderConstantsService;
	
	@ResponseBody
	@RequestMapping(value="/orderType.do")
	public ListResult<Pair<Integer, String>> getOrderType() {
		return orderConstantsService.getOrderType();
	}
	
	@ResponseBody
	@RequestMapping(value="/orderInternalType.do")
	public ListResult<Pair<Integer, String>> getOrderInternalType() {
		return orderConstantsService.getOrderInternalType();
	}
	
	@ResponseBody
	@RequestMapping(value="/orderPaymentStatus.do")
	public ListResult<Pair<Integer, String>> getOrderPaymentStatus() {
		return orderConstantsService.getOrderPaymentStatus();
	}
}
