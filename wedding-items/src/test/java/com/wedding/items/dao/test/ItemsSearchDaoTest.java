package com.wedding.items.dao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wedding.items.dao.search.ItemsSearchDao;
import com.wedding.items.pojo.search.ItemsSearch;
import com.wedding.items.test.BaseTestCase;

public class ItemsSearchDaoTest extends BaseTestCase {

	@Autowired
	private ItemsSearchDao itemsSearchDao;
	
	public void testItemsSearch(){
		ItemsSearch items = itemsSearchDao.findInDbById("06d234a7-989a-4574-8ea5-89e9810fed7e");
		System.out.println(items);
	}
	
	@Test
	public void findByByAreaId() {
		List<ItemsSearch> items = itemsSearchDao.findByItemType(1, 20);
		System.out.println(items);
	}
}
