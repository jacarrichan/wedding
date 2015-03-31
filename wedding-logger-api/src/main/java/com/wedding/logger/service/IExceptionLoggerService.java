package com.wedding.logger.service;

import org.springframework.stereotype.Service;
import com.wedding.logger.dto.BusinessExceptionDto;
import com.wedding.logger.dto.SystemExceptionDto;

@Service
public interface IExceptionLoggerService {

	BusinessExceptionDto popBusinessException();
	
	void pushBusinessException(BusinessExceptionDto ex);
	
	void saveBusinessException(BusinessExceptionDto ex);
	
	SystemExceptionDto popSystemException();
	
	void pushSystemException(SystemExceptionDto ex);
	
	void saveSystemException(SystemExceptionDto ex);
}
