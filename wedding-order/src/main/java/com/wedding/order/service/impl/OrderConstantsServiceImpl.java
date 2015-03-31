package com.wedding.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;
import com.wedding.order.constants.OrderInternalTypeEnum;
import com.wedding.order.constants.OrderPaymentStatusEnum;
import com.wedding.order.constants.OrderTypeEnum;
import com.wedding.order.service.IOrderConstantsService;

/**
 * 返回Order订单的一些常量的Pair值
 * @author rkzhang
 *
 */
@Service
public class OrderConstantsServiceImpl implements IOrderConstantsService {
	
	/**
	 * 订单类型
	 */
	@Override
	public ListResult<Pair<Integer, String>> getOrderType() {		
		List<Pair<Integer, String>> reuslts = new ArrayList<Pair<Integer, String>>();
		for(OrderTypeEnum orderType : OrderTypeEnum.values()){
			reuslts.add(new Pair<Integer, String>(orderType.getIndex(), orderType.getTypeName()));
    	}
		return new ListResult<Pair<Integer, String>>(reuslts);
	}

	/**
	 * 线下或线上订单
	 */
	@Override
	public ListResult<Pair<Integer, String>> getOrderInternalType() {
		List<Pair<Integer, String>> reuslts = new ArrayList<Pair<Integer, String>>();
		for(OrderInternalTypeEnum type : OrderInternalTypeEnum.values()){
			reuslts.add(new Pair<Integer, String>(type.getIndex(), type.getValue()));
		}
		return new ListResult<Pair<Integer, String>>(reuslts);
	}

	/**
	 * 支付状态
	 */
	@Override
	public ListResult<Pair<Integer, String>> getOrderPaymentStatus() {
		List<Pair<Integer, String>> reuslts = new ArrayList<Pair<Integer, String>>();
		for(OrderPaymentStatusEnum type : OrderPaymentStatusEnum.values()){
			reuslts.add(new Pair<Integer, String>(type.getIndex(), type.getValue()));
		}
		return new ListResult<Pair<Integer, String>>(reuslts);
	}

}
