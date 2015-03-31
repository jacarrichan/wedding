package com.wedding.items.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.common.model.ListResult;
import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.model.Result;
import com.wedding.common.util.BeanUtils;
import com.wedding.common.util.NumberUtils;
import com.wedding.items.constants.ItemsTypeEnum;
import com.wedding.items.dao.ItemsDescDao;
import com.wedding.items.dao.search.ItemsSearchDao;
import com.wedding.items.dto.IItemsSearchService;
import com.wedding.items.dto.ItemsDto;
import com.wedding.items.dto.ItemsSearchQuery;
import com.wedding.items.pojo.ItemsDesc;
import com.wedding.items.pojo.search.ItemsDescSearch;
import com.wedding.items.pojo.search.ItemsSearch;
import com.wedding.tools.cache.AreaCache;

@Service("itemsSearchService")
public class ItemsSearchServiceImpl implements IItemsSearchService {

	@Autowired
	private ItemsSearchDao itemsSearchDao;
	
	@Autowired
	private ItemsDescDao itemsDescDao;
	
	@Autowired
	private AreaCache areaCache;
	
	@Override
	public PageResult<ItemsDto> search(ItemsSearchQuery query, PageQuery page) {
		List<ItemsSearch> searchResults = itemsSearchDao.search(query, page);
		if(CollectionUtils.isEmpty(searchResults)) {
			return new PageResult<>(page, null);
		}
		
		DecimalFormat format = NumberUtils.createNumberFormat();
		List<ItemsDto> items = new ArrayList<>();
		for(ItemsSearch search : searchResults) {
			ItemsDto item = BeanUtils.createBeanByTarget(search, ItemsDto.class);
			item.setItemTypeName(ItemsTypeEnum.getName(search.getItemType()));
			if(search.getItemFactPrice() != null) {
				item.setItemFactPrice(Double.valueOf(format.format(search.getItemFactPrice() / 100d)));
			}
			if(search.getItemFinalPrice() != null) {
				item.setItemFinalPrice(Double.valueOf(format.format(search.getItemFinalPrice() / 100d)));
			}
			if(search.getItemMarketPrice() != null) {
				item.setItemMarketPrice(Double.valueOf(format.format(search.getItemMarketPrice() / 100d)));
			}
			items.add(item);
		}
		
		return new PageResult<>(page, items);
	}

	@Override
	public RequestResult saveOrUpdateSearch(String itemId) {
		ItemsSearch search = itemsSearchDao.findInDbById(itemId);
		
		List<ItemsDesc>  itemsDesc = itemsDescDao.getItemsDescByItemId(itemId);
		if(!CollectionUtils.isEmpty(itemsDesc)){
			List<ItemsDescSearch> searchDesc = BeanUtils.createBeanListByTarget(itemsDesc, ItemsDescSearch.class);
			search.setItemsDesc(searchDesc);
		}
		itemsSearchDao.saveOrUpdate(search);
		return new RequestResult(true, "save or update sucessed!");
	}

	@Override
	public RequestResult removeSearch(String itemId) {
		itemsSearchDao.removeById(itemId);
		return new RequestResult(true, "remove sucessed!");
	}

	@Override
	public ListResult<Result<String>> findByItemNameLike(String name) {
		List<Result<String>> list = new ArrayList<>();
		PageQuery page = new PageQuery();
		page.setCurrPage(1);
		page.setPageSize(10);
		List<ItemsSearch> items = itemsSearchDao.findByItemNameLike(name, page);
		
		for(ItemsSearch item : items) {
			list.add(new Result<String>(item.getItemName()));
		}
		return new ListResult<Result<String>>(list);
	}


}
