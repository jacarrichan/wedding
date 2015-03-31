package com.wedding.admin.controller.items;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedding.common.ext.ExtPageQuery;
import com.wedding.common.model.ListResult;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.items.dto.ItemsTypeDto;
import com.wedding.items.dto.ItemsTypePropertiesDto;
import com.wedding.items.service.IItemsTypePropertiesService;
import com.wedding.items.service.IItemsTypeService;

/**
 * 类目及其属性管理
 * @author rkzhang
 */
@Controller
@RequestMapping(value="/items/items-type")
public class ItemsTypeController {

	  protected static final Log logger = LogFactory.getLog(ItemsTypeController.class);
	  
	  @Autowired
	  private IItemsTypeService itemsTypeService;
	  
	  @Autowired
	  private IItemsTypePropertiesService itemsTypePropertiesService;
	
	  @RequestMapping(value="/index.do")
	  public String index(){
	       logger.debug("visit items manage page");
	       return "/admin/items/items-type";
	  }
	  
	  @ResponseBody
	  @RequestMapping(value="/createType.do")
	  public RequestResult createType(String typeName){
		  ItemsTypeDto itemsType = new ItemsTypeDto();
		  itemsType.setTypeName(typeName);
		  return itemsTypeService.create(itemsType);
	  }
	  
	  @ResponseBody
	  @RequestMapping(value="/deleteType.do")
	  public RequestResult deleteType(String typeId) {
		  return itemsTypeService.deleteByTypeId(typeId);
	  }
	  
	  @ResponseBody
	  @RequestMapping(value="/findAllType.do")
	  public PageResult<ItemsTypeDto> findAllType(ExtPageQuery page) {
		  return itemsTypeService.findAll(page.changeToPageQuery());	   
	  }
	  
	  @ResponseBody
	  @RequestMapping(value="/saveOrUpdateProperty.do")
	  public RequestResult createProperty(ItemsTypePropertiesDto property){		 
		  return itemsTypePropertiesService.saveOrUpdateProperty(property);
	  }
	  
	  @ResponseBody
	  @RequestMapping(value="/deleteProperty.do")
	  public RequestResult deleteProperty(String propertyId){
		  return itemsTypePropertiesService.deleteById(propertyId);
	  }
	  
	  @ResponseBody
	  @RequestMapping(value="/findByTypeId.do")
	  public ListResult<ItemsTypePropertiesDto> findByTypeId(String itemTypeId) {
		  return itemsTypePropertiesService.findByItemsTypeId(itemTypeId);
	  }
}
