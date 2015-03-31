package com.wedding.logger.mapper;

import org.apache.ibatis.annotations.Param;

import com.wedding.common.jdbc.DataSource;

public interface LoggerTableManageMapper {

	@DataSource("logger")
	long count(@Param("tableName")String tableName);
	
	@DataSource("logger")
	int createBussinessExceptionTable(@Param("tableName")String tableName);
	
	@DataSource("logger")
	int createSystemExceptionTable(@Param("tableName")String tableName);
	
}
