package com.wedding.order.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.util.StringUtils;
import com.wedding.order.constants.OrderInternalTypeEnum;
import com.wedding.order.constants.OrderPaymentStatusEnum;
import com.wedding.order.constants.OrderTypeEnum;
import com.wedding.order.dao.OrderManageDao;
import com.wedding.order.dto.OrderManageDto;
import com.wedding.order.dto.OrderManageQuery;
import com.wedding.order.service.IOrderManageService;

/**
 * 
 * @author rkzhang
 *
 */
@Service
public class OrderManageServiceImpl implements IOrderManageService {
	
	@Autowired
	private OrderManageDao orderManageDao;

	@Override
	public PageResult<OrderManageDto> findByPage(OrderManageQuery query, PageQuery page) {
		process(query);	
		List<OrderManageDto> results = orderManageDao.findByPage(query, page);
		for(OrderManageDto order : results){
			order.setOrderType(OrderTypeEnum.getOrderTypeName(order.getOrderTypeId().intValue()));
			order.setPaymentStatus(OrderPaymentStatusEnum.getOrderPaymentStatusValue(order.getPaymentStatusId().intValue()));
			order.setOrderIsOnline(OrderInternalTypeEnum.getOrderInternalTypeValue(order.getOrderIsOnlineId()));
		}
		long total = orderManageDao.count(query);
		page.setTotal(total);
		return new PageResult<OrderManageDto>(page, results);
	}

	private void process(OrderManageQuery query) {
		Date endDate = DateUtils.addDays(query.getCreateTimeRange().getEndDate(), 1);
		query.getCreateTimeRange().setEndDate(endDate);
		String orderNum = StringUtils.isEmpty(query.getOrderNum()) ? null : "%" + query.getOrderNum() + "%";
		query.setOrderNum(orderNum);
		String orderBuyer = StringUtils.isEmpty(query.getOrderBuyer()) ? null : "%" + query.getOrderBuyer() + "%";
		query.setOrderBuyer(orderBuyer);
		Double beginAmount = query.getBeginAmount() == null ? null : query.getBeginAmount() * 100;
		query.setBeginAmount(beginAmount);
		Double endAmount = query.getEndAmount() == null ? null : query.getEndAmount() * 100;
		query.setEndAmount(endAmount);	
		String shopName = StringUtils.isEmpty(query.getShopName()) ? null : "%" + query.getShopName() + "%";
		query.setShopName(shopName);
		String appointId = StringUtils.isEmpty(query.getAppointId()) ? null : query.getAppointId();
		query.setAppointId(appointId);
	}

}
