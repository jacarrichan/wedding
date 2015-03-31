package com.wedding.items.dto;

import org.springframework.stereotype.Service;

import com.wedding.common.model.ListResult;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.model.Result;

public interface IItemsSearchService {

	public PageResult<ItemsDto> search(ItemsSearchQuery query, PageQuery page);
	
	public RequestResult saveOrUpdateSearch(String itemId);
	
	public RequestResult removeSearch(String itemId);

	ListResult<Result<String>> findByItemNameLike(String name);
}
