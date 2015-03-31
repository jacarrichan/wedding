package com.wedding.items.service;

import com.wedding.common.model.ListResult;
import com.wedding.items.dto.HunQingChannelItem;

public interface IHunQingChannelItemsService {

	ListResult<HunQingChannelItem> findByItemType(Integer areaId, Integer number);
	
}
