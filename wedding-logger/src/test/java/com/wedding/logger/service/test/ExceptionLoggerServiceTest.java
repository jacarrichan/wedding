package com.wedding.logger.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.wedding.common.redis.WdRedisDao;
import com.wedding.common.util.UUIDGenerator;
import com.wedding.logger.dto.BusinessExceptionDto;
import com.wedding.logger.dto.SystemExceptionDto;
import com.wedding.logger.service.IExceptionLoggerService;
import com.wedding.logger.test.BaseTestCase;

public class ExceptionLoggerServiceTest extends BaseTestCase{

	@Autowired
	private IExceptionLoggerService loggerService;
	
	@Autowired
	private WdRedisDao<SystemExceptionDto> systemExceptionDao;
	
	@Autowired
	private WdRedisDao<BusinessExceptionDto> businessExceptionDao;
	
	@Test
	public void systemExceptionTest(){
		systemExceptionDao.delete(SystemExceptionDto.REDIS_KEY);
		SystemExceptionDto sysDto = new SystemExceptionDto();
		String uid = UUIDGenerator.getUUID();
		sysDto.setId(uid);
		loggerService.pushSystemException(sysDto);
		
		sysDto = loggerService.popSystemException();
		Assert.assertEquals(uid, sysDto.getId());

		sysDto = loggerService.popSystemException();
		Assert.assertNull(sysDto);
	}
	
	@Test
	public void businessExceptionTest() {
		businessExceptionDao.delete(BusinessExceptionDto.REDIS_KEY);
		BusinessExceptionDto businessDto = new BusinessExceptionDto();
		String uid = UUIDGenerator.getUUID();
		businessDto.setId(uid);
		loggerService.pushBusinessException(businessDto);
		
		businessDto = loggerService.popBusinessException();
		Assert.assertEquals(uid, businessDto.getId());
		
		businessDto = loggerService.popBusinessException();
		Assert.assertNull(businessDto);
	}
}
