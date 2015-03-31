package com.wedding.logger.mapper;

import org.apache.ibatis.annotations.Param;
import com.wedding.common.jdbc.DataSource;
import com.wedding.logger.dto.BusinessExceptionDto;

public interface BusinessExceptionMapper {

	@DataSource("logger")
	int insert(@Param("exception")BusinessExceptionDto exception, @Param("tableName")String tableName);

}
