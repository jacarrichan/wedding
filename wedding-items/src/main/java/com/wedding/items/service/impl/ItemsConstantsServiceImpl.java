package com.wedding.items.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wedding.common.dto.Pair;
import com.wedding.common.model.ListResult;
import com.wedding.items.constants.ItemsPropertyTypeEnum;
import com.wedding.items.constants.ItemsTypeEnum;
import com.wedding.items.service.IItemsConstantsService;

@Service("itemsConstantsService")
public class ItemsConstantsServiceImpl implements IItemsConstantsService {

	@Override
	public ListResult<Pair<Integer, String>> getPropertyType() {
		List<Pair<Integer, String>> results = new ArrayList<Pair<Integer, String>>();
		for(ItemsPropertyTypeEnum type : ItemsPropertyTypeEnum.values()){
			Pair<Integer, String> pair = new Pair<Integer, String>(type.getType(), type.getName());
			results.add(pair);
		}
		return new ListResult<Pair<Integer, String>>(results);
	}

	@Override
	public ListResult<Pair<Integer, String>> getItemsType() {
		List<Pair<Integer, String>> results = new ArrayList<Pair<Integer, String>>();
		
		for(ItemsTypeEnum type : ItemsTypeEnum.values()){
			Pair<Integer, String> pair = new Pair<Integer, String>(type.getType(), type.getName());
			results.add(pair);
		}
		return new ListResult<Pair<Integer, String>>(results);
	}

}
