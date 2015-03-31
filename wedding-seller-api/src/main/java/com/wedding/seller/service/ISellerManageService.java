package com.wedding.seller.service;

import org.springframework.stereotype.Service;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.model.Result;
import com.wedding.seller.dto.SellerCurdDto;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.SellerManageQuery;


@Service
public interface ISellerManageService {
	
	PageResult<SellerDto> findByPageInDb(SellerManageQuery query, PageQuery page);
	
	public RequestResult saveOrUpdate(SellerCurdDto seller);

	Result<SellerDto> findBySellerId(String sellerId);
}
