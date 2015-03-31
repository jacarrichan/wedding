package com.wedding.admin.controller.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedding.common.model.RequestResult;
import com.wedding.seller.dto.SellerCurdDto;
import com.wedding.seller.service.ISellerManageService;

/**
 * 商家信息修改
 * @author rkzhang
 */
@Controller
@RequestMapping(value="/seller/seller-curd")
public class SellerCurdController {

	@Autowired
	private ISellerManageService sellerManageService;
	
	@ResponseBody
    @RequestMapping(value="/saveOrUpdate.do")
	public RequestResult update(SellerCurdDto seller){
		
		return sellerManageService.saveOrUpdate(seller);
	}
}
