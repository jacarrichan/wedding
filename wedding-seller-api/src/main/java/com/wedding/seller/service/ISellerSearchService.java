package com.wedding.seller.service;

import org.springframework.stereotype.Service;

import com.wedding.common.model.ListResult;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.Result;
import com.wedding.seller.dto.SellerDto;
import com.wedding.seller.dto.SellerManageQuery;

@Service
public interface ISellerSearchService {

	public PageResult<SellerDto> findByPage(SellerManageQuery query, PageQuery page);
		
	PageResult<SellerDto> findByNameStartingWith(String name, PageQuery page);

	ListResult<Result<String>> findNameLike(String name);
}
