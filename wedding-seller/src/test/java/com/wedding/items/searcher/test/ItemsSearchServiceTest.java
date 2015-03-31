package com.wedding.items.searcher.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.items.dto.IItemsSearchService;
import com.wedding.items.dto.ItemsDto;
import com.wedding.items.dto.ItemsSearchQuery;
import com.wedding.seller.test.BaseTestCase;

public class ItemsSearchServiceTest extends BaseTestCase {

	@Autowired
	private IItemsSearchService iItemsSearchService;
	
	@Test
	public void searchTest(){
		ItemsSearchQuery query = new ItemsSearchQuery(); 
		query.setItemName("又省心婚580有限公司");
		
		PageQuery page = new PageQuery();
		page.setCurrPage(1);
		page.setPageSize(20);
		
		PageResult<ItemsDto> pageReuslt = iItemsSearchService.search(query, page);
		for(ItemsDto item : pageReuslt.getResults()){
			System.out.println(item);
		}
	}
}
