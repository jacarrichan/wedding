package com.wedding.logger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wedding.common.support.Queue;
import com.wedding.logger.dao.BusinessExceptionDao;
import com.wedding.logger.dao.SystemExceptionDao;
import com.wedding.logger.dto.BusinessExceptionDto;
import com.wedding.logger.dto.SystemExceptionDto;
import com.wedding.logger.service.IExceptionLoggerService;
import com.wedding.logger.service.ILoggerTableManageService;

/**
 * @author rkzhang
 */
@Service
public class ExceptionLoggerServiceImpl implements IExceptionLoggerService {

	@Autowired
	@Qualifier("businessExceptionQueue")
	private Queue<BusinessExceptionDto> businessExceptionQueue;
	
	@Autowired
	@Qualifier("systemExceptionQueue")
	private Queue<SystemExceptionDto> systemExceptionQueue;
	
	@Autowired
	private BusinessExceptionDao businessDao;
	
	@Autowired
	private SystemExceptionDao systemDao;
	
	@Autowired
	private ILoggerTableManageService loggerTableManageService;
	
	public void pushBusinessException(BusinessExceptionDto ex) {
		businessExceptionQueue.push(ex);
	}
	
	public BusinessExceptionDto popBusinessException(){		
		return businessExceptionQueue.bPop();
	}

	public void pushSystemException(SystemExceptionDto ex) {
		systemExceptionQueue.push(ex);
	}
	
	public SystemExceptionDto popSystemException(){		
		return systemExceptionQueue.bPop();
	}

	@Override
	public void saveBusinessException(BusinessExceptionDto ex) {
		loggerTableManageService.createTodayBussinessExceptionLoggerTableIfNotExist();
		businessDao.saveException(ex);
	}

	@Override
	public void saveSystemException(SystemExceptionDto ex) {
		loggerTableManageService.createTodaySystemExceptionLoggerTableIfNotExist();
		systemDao.saveException(ex);
	}

}
