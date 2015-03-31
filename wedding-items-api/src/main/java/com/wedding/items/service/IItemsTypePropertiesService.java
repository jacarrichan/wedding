package com.wedding.items.service;

import org.springframework.stereotype.Service;

import com.wedding.common.model.ListResult;
import com.wedding.common.model.RequestResult;
import com.wedding.items.dto.ItemsTypePropertiesDto;

@Service
public interface IItemsTypePropertiesService {

	ListResult<ItemsTypePropertiesDto> findByItemsTypeId(String itemTypeId);
	
	RequestResult saveOrUpdateProperty(ItemsTypePropertiesDto property);
	
	RequestResult deleteById(String id);
	
}
