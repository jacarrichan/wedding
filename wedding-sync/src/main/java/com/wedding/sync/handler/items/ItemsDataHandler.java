package com.wedding.sync.handler.items;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.items.dto.IItemsSearchService;
import com.wedding.sync.annotation.TableName;
import com.wedding.sync.handler.IDataHandler;
import com.wedding.sync.model.DataInfo;

@TableName("wd_items")
@Service
public class ItemsDataHandler implements IDataHandler {

	protected static final Log logger = LogFactory.getLog(ItemsDataHandler.class);
	
	@Autowired
	private IItemsSearchService itemsSearchService;
	

	@Override
	public void create(DataInfo dataInfo) {
		logger.info("create : " + dataInfo);
		String itemId = dataInfo.getColumnStringValue("id");
		itemsSearchService.saveOrUpdateSearch(itemId);
		
	}

	@Override
	public void update(DataInfo dataInfo) {
		logger.info("update : " + dataInfo);
		String itemId = dataInfo.getColumnStringValue("id");
		Integer stat = dataInfo.getColumnIntegerValue("stat");
		if(stat == null || stat.intValue() == 1) {
			itemsSearchService.saveOrUpdateSearch(itemId);
		} else { 
			itemsSearchService.removeSearch(itemId);
		}
		
	}

	@Override
	public void delete(DataInfo dataInfo) {
		logger.info("delete : " + dataInfo);
		String itemId = dataInfo.getColumnStringValue("id");
		itemsSearchService.removeSearch(itemId);
		
	}

}
