package com.wedding.order.service;

import org.springframework.stereotype.Service;

import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;

@Service
public interface IOrderConstantsService {

	ListResult<Pair<Integer, String>> getOrderType();
	
	ListResult<Pair<Integer, String>> getOrderInternalType();
	
	ListResult<Pair<Integer, String>> getOrderPaymentStatus();
}
