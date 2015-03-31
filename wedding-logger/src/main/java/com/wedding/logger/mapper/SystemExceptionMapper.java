package com.wedding.logger.mapper;

import org.apache.ibatis.annotations.Param;
import com.wedding.common.jdbc.DataSource;
import com.wedding.logger.dto.SystemExceptionDto;

public interface SystemExceptionMapper {

	@DataSource("logger")
	int insert(@Param("exception")SystemExceptionDto exception, @Param("tableName")String tableName);
}
