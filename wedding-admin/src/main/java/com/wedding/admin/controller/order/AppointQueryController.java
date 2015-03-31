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
import com.wedding.order.dto.AppointDto;
import com.wedding.order.dto.AppointQuery;
import com.wedding.order.service.IAppointQueryService;

/**
 * @author rkzhang
 */
@Controller
@RequestMapping(value="/appoint/appoint-query")
public class AppointQueryController {

	  protected static final Log logger = LogFactory.getLog(AppointQueryController.class);
	  
	  @Autowired
	  private IAppointQueryService appointQueryService;
	  
	  @RequestMapping(value="/index.do")
	  public String index(){
	       logger.debug("visit appoint query page");
	       return "/admin/appoint/appoint-query";
	  }
	  
	  @ResponseBody
	  @RequestMapping(value="/find.do")
	  public PageResult<AppointDto> find(AppointQuery query, ExtPageQuery page){
		  return appointQueryService.findByPage(query, page.changeToPageQuery());
	  }
}
