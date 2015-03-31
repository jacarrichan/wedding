package com.wedding.admin.controller.items;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedding.common.ext.ExtPageQuery;
import com.wedding.common.model.ListResult;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.Result;
import com.wedding.items.dto.IItemsSearchService;
import com.wedding.items.dto.ItemsDto;
import com.wedding.items.dto.ItemsSearchQuery;

/**
 * 商品信息查询
 * @author rkzhang
 */
@Controller
@RequestMapping(value="/items/items-search")
public class ItemsSearchController {

	  protected static final Log logger = LogFactory.getLog(ItemsSearchController.class);
	  
	  @Autowired
	  private IItemsSearchService itemsSearchService;
	 
	 @ResponseBody
	 @RequestMapping(value="/find.do")
	 public PageResult<ItemsDto> find(ItemsSearchQuery query, ExtPageQuery page){		 
		 return itemsSearchService.search(query, page.changeToPageQuery());
	 }
	 
	 @ResponseBody
	  @RequestMapping(value="/findLikeItemName.do")
	  public ListResult<Result<String>> findLikeItemName(@RequestParam("query")String name){		
		  return itemsSearchService.findByItemNameLike(name);
	  }
	 
}
