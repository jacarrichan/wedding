package com.wedding.logger.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import lombok.Getter;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.logger.dto.SystemExceptionDto;
import com.wedding.logger.mapper.SystemExceptionMapper;
import com.wedding.logger.util.SysLoggerUtil;

/**
 * Created by rkzhang on 14-9-20.
 */
@Repository
public class SystemExceptionDao extends MyBatisBaseDao<SystemExceptionDto>{

	@Getter
	@Autowired
	private SystemExceptionMapper mapper;

	 public int saveException(SystemExceptionDto exception){    	
        return mapper.insert(exception, SysLoggerUtil.getTodaySystemExceptionLoggerTableName());
    }

}
