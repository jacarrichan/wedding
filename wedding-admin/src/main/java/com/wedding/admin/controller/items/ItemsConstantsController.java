package com.wedding.admin.controller.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;
import com.wedding.items.service.IItemsConstantsService;

/**
 * @author rkzhang
 */
@Controller
@RequestMapping(value="/items/constants")
public class ItemsConstantsController {

	@Autowired
	private IItemsConstantsService itemsConstantsService;
	
	@ResponseBody
	@RequestMapping(value="/propertyType.do")
	public ListResult<Pair<Integer, String>> getPropertyType() {
		return itemsConstantsService.getPropertyType();
	}
	
	@ResponseBody
	@RequestMapping(value="/itemsType.do")
	public ListResult<Pair<Integer, String>> getItemsType() {
		return itemsConstantsService.getItemsType();
	}
}
