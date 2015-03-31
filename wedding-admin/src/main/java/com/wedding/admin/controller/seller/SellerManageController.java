package com.wedding.admin.controller.seller;

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
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.SellerManageQuery;
import com.wedding.seller.service.ISellerSearchService;

/**
 * 商家管理
 * @author rkzhang
 */
@Controller
@RequestMapping(value="/seller/seller-manage")
public class SellerManageController {
	
	protected static final Log logger = LogFactory.getLog(SellerManageController.class);
	
	@Autowired
	private ISellerSearchService sellerSearchService;
	
	@RequestMapping(value="/index.do")
    public String index(){    
        return "/admin/seller/seller-manage";
    }
	
	  @ResponseBody
	  @RequestMapping(value="/find.do")
	  public PageResult<SellerDto> find(SellerManageQuery query, ExtPageQuery page){		
		  return sellerSearchService.findByPage(query, page.changeToPageQuery());
	  }
	  
	  @ResponseBody
	  @RequestMapping(value="/findLikeName.do")
	  public ListResult<Result<String>> findLikeName(@RequestParam("query")String name){		
		  return sellerSearchService.findNameLike(name);
	  }
}
