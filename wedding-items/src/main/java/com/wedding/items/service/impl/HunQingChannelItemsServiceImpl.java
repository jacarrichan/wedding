package com.wedding.items.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.wedding.common.model.ListResult;
import com.wedding.items.dao.search.ItemsSearchDao;
import com.wedding.items.dto.HunQingChannelItem;
import com.wedding.items.pojo.search.ItemsSearch;
import com.wedding.items.service.IHunQingChannelItemsService;

@Service("hunQingChannelItemsService")
public class HunQingChannelItemsServiceImpl implements IHunQingChannelItemsService {

	@Autowired
	private ItemsSearchDao searchDao;
	
	@Override
	public ListResult<HunQingChannelItem> findByItemType(Integer areaId, Integer number) {
		List<HunQingChannelItem> items = new ArrayList<>();
		List<ItemsSearch> itemsSearchs = searchDao.findByItemType(areaId, number);
		if(CollectionUtils.isEmpty(itemsSearchs)) {
			return new ListResult<>(items);
		}
		for(ItemsSearch item : itemsSearchs) {	
			HunQingChannelItem channelItem = new HunQingChannelItem();
			channelItem.setHref("href");			
			channelItem.setImage(item.getMainPic());
			channelItem.setItemName(item.getItemName());
			channelItem.setDescription1(item.getItemFinalPrice().toString());
			channelItem.setDescription2("");
			items.add(channelItem);
		}
		return new ListResult<>(items);
	}

}
