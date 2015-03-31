package com.wedding.order.service;

import org.springframework.stereotype.Service;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.order.dto.AppointDto;
import com.wedding.order.dto.AppointQuery;

@Service
public interface IAppointQueryService {

	PageResult<AppointDto> findByPage(AppointQuery query, PageQuery changeToPageQuery);
	
}
