package com.wedding.admin.controller.order;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wedding.common.dto.DateRange;
import com.wedding.common.ext.ExtPageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.order.dto.OrderManageDto;
import com.wedding.order.dto.OrderManageQuery;
import com.wedding.order.service.IOrderManageService;

/**
 * 
 * @author rkzhang
 *
 */
@Controller
@RequestMapping(value="/order/order-manage")
public class OrderManagementController {

	  protected static final Log logger = LogFactory.getLog(OrderManagementController.class);
	  
	  @Autowired
	  private IOrderManageService orderManageService;
	
	  @RequestMapping(value="/index.do")
	    public String index(){
	        logger.debug("visit role manager page");
	        return "/admin/order/order-manage";
	    }
	  
	  @ResponseBody
	  @RequestMapping(value="/find.do")
	  public PageResult<OrderManageDto> find(OrderManageQuery query, DateRange dateRange, ExtPageQuery page){
		  query.setCreateTimeRange(dateRange);
		  return orderManageService.findByPage(query, page.changeToPageQuery());
	  }

}
