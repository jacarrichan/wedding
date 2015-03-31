package com.wedding.items.dao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wedding.seller.dao.search.ShopSearchDao;
import com.wedding.seller.pojo.search.ShopSearch;
import com.wedding.seller.test.BaseTestCase;

public class ShopSearchDaoTest extends BaseTestCase {

	@Autowired
	private ShopSearchDao shopSearchDao;
	
	@Test
	public void findByAreaIdTest() {
		List<ShopSearch> searchs = shopSearchDao.findByAreaId(110000, 1, 20);
		System.out.println(searchs);
	}
	
}
