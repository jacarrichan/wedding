package com.wedding.admin.controller.seller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedding.common.model.ListResult;
import com.wedding.common.model.Result;
import com.wedding.seller.service.IShopSearchService;

/**
 * 店铺查询
 * @author rkzhang
 */
@Controller
@RequestMapping(value="/shop/shop-search")
public class ShopSearchController {

	protected static final Log logger = LogFactory.getLog(ShopSearchController.class);
	
	@Autowired
	private IShopSearchService shopSearchService;
	
	@ResponseBody
	@RequestMapping(value="/findLikeShopName.do")
	public ListResult<Result<String>> findLikeShopName(@RequestParam("query")String name){		
		  return shopSearchService.findNameLike(name);
	}
	
}
