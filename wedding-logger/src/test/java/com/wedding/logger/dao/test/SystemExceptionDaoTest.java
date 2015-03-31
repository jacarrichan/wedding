package com.wedding.logger.dao.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wedding.common.util.UUIDGenerator;
import com.wedding.logger.dao.SystemExceptionDao;
import com.wedding.logger.dto.SystemExceptionDto;
import com.wedding.logger.test.BaseTestCase;

public class SystemExceptionDaoTest extends BaseTestCase {

	@Autowired
	private SystemExceptionDao systemDao;
	
	@Test
	public void insertTest(){
		SystemExceptionDto systemDto = new SystemExceptionDto();
		systemDto.setCreateTime(new Date());
		systemDto.setErrorMessage("test message");
		systemDto.setErrorStackTrace("errorStackTrace");
		systemDto.setId(UUIDGenerator.getUUID());
		
		systemDao.saveException(systemDto);
	}
}
