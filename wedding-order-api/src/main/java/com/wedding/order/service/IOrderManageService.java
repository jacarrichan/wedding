package com.wedding.order.service;

import org.springframework.stereotype.Service;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.order.dto.OrderManageDto;
import com.wedding.order.dto.OrderManageQuery;

@Service
public interface IOrderManageService {

	PageResult<OrderManageDto> findByPage(OrderManageQuery query, PageQuery page);
}
