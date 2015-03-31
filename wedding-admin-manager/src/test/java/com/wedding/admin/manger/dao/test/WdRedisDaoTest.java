package com.wedding.admin.manger.dao.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wedding.admin.manager.dto.test.TestDto;
import com.wedding.admin.manager.test.BaseTestCase;
import com.wedding.common.redis.WdRedisDao;

public class WdRedisDaoTest extends BaseTestCase {

	@Autowired
	private WdRedisDao<TestDto> redisDao;
	
	@Test
	public void testRedisDao(){
		TestDto dto = new TestDto();
		dto.setPassword("aaaaa");
		dto.setUserName("sdfasdf");
		redisDao.set(dto);
		TestDto g = redisDao.get(dto.getUserName(), TestDto.class);
		System.out.println(g);
	}
}
