package com.wedding.seller.service;

import org.springframework.stereotype.Service;

import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;

@Service
public interface ISellerConstantsService {

	ListResult<Pair<Integer, String>> getSellerType();

	ListResult<Pair<Integer, String>> getSellerInternalStatus();
}
