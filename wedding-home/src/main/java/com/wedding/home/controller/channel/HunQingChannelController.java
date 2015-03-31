package com.wedding.home.controller.channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedding.common.model.ListResult;
import com.wedding.items.dto.HunQingChannelItem;
import com.wedding.items.service.IHunQingChannelItemsService;
import com.wedding.seller.dto.HunQingChannelShop;
import com.wedding.seller.service.IHunQingChannelShopService;

/**
 * @author rkzhang
 */
@Controller
@RequestMapping("/channel")
public class HunQingChannelController {
	
	@Autowired
	private IHunQingChannelItemsService channelHqItemService;
	
	@Autowired
	private IHunQingChannelShopService channelHqShopService;

    @ResponseBody
    @RequestMapping(value = "/hq/getItems.do")
	public ListResult<HunQingChannelItem> getChannelItemsByItemType(@Param("itemType")Integer itemType, @Param("number")Integer number) {
    	ListResult<HunQingChannelItem> results = channelHqItemService.findByItemType(itemType, number);
		return results;
	}
    
    @ResponseBody
    @RequestMapping(value = "/hq/getShops.do")
	public ListResult<HunQingChannelShop> getChannelShopsByAreaId(@Param("areaId")Integer areaId, @Param("number")Integer number, @Param("activityType")Integer activityType) {
    	ListResult<HunQingChannelShop> results = channelHqShopService.findChannelItemsByAreaId(areaId, activityType, number);
		return results;
	}
    
}
