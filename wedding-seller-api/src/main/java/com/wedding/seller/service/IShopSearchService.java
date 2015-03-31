package com.wedding.seller.service;

import org.springframework.stereotype.Service;

import com.wedding.common.model.ListResult;
import com.wedding.common.model.Result;

@Service
public interface IShopSearchService {

	ListResult<Result<String>> findNameLike(String name);
	
}
