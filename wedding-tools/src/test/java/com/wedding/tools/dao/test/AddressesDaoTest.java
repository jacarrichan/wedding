package com.wedding.tools.dao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wedding.tools.dao.AddressesDao;
import com.wedding.tools.test.BaseTestCase;

public class AddressesDaoTest extends BaseTestCase {
	
	@Autowired
	private AddressesDao addressesDao;
	
	@Test
	public void testFindAllParentId(){
		List<Integer> parentIds = addressesDao.findAllParentId();
		for(Integer id : parentIds) {
			System.out.println(id);
		}
	}
}
