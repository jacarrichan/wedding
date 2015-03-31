package com.wedding.seller.service;

import com.wedding.common.model.ListResult;
import com.wedding.seller.dto.HunQingChannelShop;

public interface IHunQingChannelShopService {

	ListResult<HunQingChannelShop> findChannelItemsByAreaId(Integer areaId, Integer activityType, Integer number);
	
}
