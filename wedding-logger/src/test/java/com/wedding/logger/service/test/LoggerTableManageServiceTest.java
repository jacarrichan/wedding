package com.wedding.logger.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wedding.logger.service.ILoggerTableManageService;
import com.wedding.logger.test.BaseTestCase;

public class LoggerTableManageServiceTest extends BaseTestCase{

	@Autowired
	private ILoggerTableManageService service;
	
	@Test
	public void testCreateTable(){
		service.createTodayBussinessExceptionLoggerTableIfNotExist();
		//service.createTodaySystemExceptionLoggerTableIfNotExist();
	}
}
