package com.wedding.order.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.wedding.common.model.PageQuery;
import com.wedding.order.dto.AppointDto;
import com.wedding.order.dto.AppointQuery;

public interface AppointExMapper {

	List<AppointDto> findByPage(@Param("query")AppointQuery query, @Param("page")PageQuery page);
	
	long count(@Param("query")AppointQuery query);
	
}
