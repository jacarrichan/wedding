package com.wedding.admin.controller.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;
import com.wedding.seller.service.ISellerConstantsService;

/**
 * @author rkzhang
 */
@Controller
@RequestMapping(value="/seller/constants")
public class SellerConstantsController {

	@Autowired
	private ISellerConstantsService sellerConstantsService;
	
	
	@ResponseBody
	@RequestMapping(value="/sellerType.do")
	public ListResult<Pair<Integer, String>> getSellerType() {
		return sellerConstantsService.getSellerType();
	}
	
	@ResponseBody
	@RequestMapping(value="/sellerInternalStatus.do")
	public ListResult<Pair<Integer, String>> sellerInternalStatus() {
		return sellerConstantsService.getSellerInternalStatus();
	}
}
