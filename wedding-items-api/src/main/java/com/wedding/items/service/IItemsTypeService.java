package com.wedding.items.service;

import org.springframework.stereotype.Service;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.items.dto.ItemsTypeDto;

@Service
public interface IItemsTypeService {

	RequestResult create(ItemsTypeDto itemsType);
	
	PageResult<ItemsTypeDto> findAll(PageQuery page);

	RequestResult deleteByTypeId(String typeId);
	
}
