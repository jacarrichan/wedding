package com.wedding.admin.controller.items;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedding.common.model.RequestResult;
import com.wedding.items.service.ItemsService;

/**
 * 商品信息修改
 * @author rkzhang
 */
@Controller
@RequestMapping(value="/items/items-manage")
public class ItemsManageController {
	
	 protected static final Log logger = LogFactory.getLog(ItemsManageController.class);
	
	@Autowired
	private ItemsService itemsService;
	
	  @RequestMapping(value="/index.do")
	  public String index(){
	       logger.debug("visit items manage page");
	       return "/admin/items/items-manage";
	  }

	 @ResponseBody
	 @RequestMapping(value="/cancelPromotion.do")
	 public RequestResult cancelPromotion(@RequestParam("itemId")String itemId){		 
		 
		 return itemsService.cancelPromotion(itemId);
	 }
}
