package com.wedding.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.util.DateUtils;
import com.wedding.common.util.StringUtils;
import com.wedding.order.constants.AppointStatusEnum;
import com.wedding.order.dao.AppointDao;
import com.wedding.order.dto.AppointDto;
import com.wedding.order.dto.AppointQuery;
import com.wedding.order.service.IAppointQueryService;

@Service
public class AppointQueryServiceImpl implements IAppointQueryService {

	@Autowired
	private AppointDao appointDao;
	
	@Override
	public PageResult<AppointDto> findByPage(AppointQuery query, PageQuery page) {
		process(query);
		
		List<AppointDto> dtos = appointDao.findByPage(query, page);
		for(AppointDto dto : dtos) {
			dto.setAppointStatusName(AppointStatusEnum.getAppointStatusValue(dto.getAppointStatus().intValue()));
		}
		long count = appointDao.count(query);
		page.setTotal(count);
		return new PageResult<AppointDto>(page, dtos);
	}

	private void process(AppointQuery query) {
		query.setEndDate(DateUtils.addDays(query.getEndDate(), 1));
		query.setSellerName(StringUtils.isEmpty(query.getSellerName()) ? null : "%" + query.getSellerName() + "%");
		query.setUserName(StringUtils.isEmpty(query.getUserName()) ? null : "%" + query.getUserName() + "%");
	}

}
