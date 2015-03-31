package com.wedding.seller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.wedding.common.model.ListResult;
import com.wedding.seller.dao.search.ShopSearchDao;
import com.wedding.seller.dto.HunQingChannelShop;
import com.wedding.seller.pojo.search.ShopSearch;

@Service
public class HunQingChannelShopServiceImpl implements IHunQingChannelShopService {
	
	@Autowired
	private ShopSearchDao shopSearchDao;

	@Override
	public ListResult<HunQingChannelShop> findChannelItemsByAreaId(Integer areaId, Integer activityType, Integer number) {
		List<ShopSearch> results = shopSearchDao.findByAreaId(areaId, activityType, number);
		List<HunQingChannelShop> shops = new ArrayList<>();
		if(CollectionUtils.isEmpty(results)) {
			 return new ListResult<>(shops);
		}
		
		for(ShopSearch result : results) {
			HunQingChannelShop shop = new HunQingChannelShop();
			shop.setImage(result.getLogo());
			shop.setShopName(result.getName());
			shop.setDescription1("囍囍囍");
			shop.setDescription2("米兰婚纱沪上最大的婚纱");
			shop.setHref("aaaaaaa");			
			shops.add(shop);
		}
		 return new ListResult<>(shops);
	}

}
