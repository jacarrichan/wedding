package com.wedding.items.service.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.wedding.items.dao.ItemsDao;
import com.wedding.items.dao.ItemsDescDao;
import com.wedding.items.test.BaseTestCase;

public class ItemsDataPrepareService extends BaseTestCase {

	@Autowired
	private ItemsDao itemsDao;
	
	@Autowired
	private ItemsDescDao itemsDescDao;
	
	public void prepareData(){
		
		
	}
}
