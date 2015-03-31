package com.wedding.logger.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.common.redis.WdRedisDao;
import com.wedding.common.support.Queue;
import com.wedding.logger.dto.SystemExceptionDto;

@Service
public class SystemExceptionQueue implements Queue<SystemExceptionDto> {
	
	@Autowired
	private WdRedisDao<SystemExceptionDto> systemExceptionDao;

	@Override
	public void push(SystemExceptionDto t) {
		systemExceptionDao.setToList(SystemExceptionDto.REDIS_KEY, t);
	}

	@Override
	public SystemExceptionDto pop() {
		return systemExceptionDao.pop(SystemExceptionDto.REDIS_KEY);
	}

	@Override
	public void empty() {
		systemExceptionDao.delete(SystemExceptionDto.REDIS_KEY);
	}

	@Override
	public SystemExceptionDto bPop() {
		return systemExceptionDao.bpop(SystemExceptionDto.REDIS_KEY, 10);
	}

}
