package com.wedding.items.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wedding.common.model.PageQuery;
import com.wedding.common.model.PageResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.util.BeanUtils;
import com.wedding.items.dao.ItemsTypeDao;
import com.wedding.items.dao.ItemsTypePropertiesDao;
import com.wedding.items.dto.ItemsTypeDto;
import com.wedding.items.pojo.ItemsType;
import com.wedding.items.pojo.ItemsTypeProperties;
import com.wedding.items.service.IItemsTypeService;

@Service("itemsTypeService")
public class ItemsTypeServiceImpl implements IItemsTypeService {

	@Autowired
	private ItemsTypeDao itemsTypeDao;
	
	@Autowired
	private ItemsTypePropertiesDao itemsTypePropertiesDao;
	
	@Override
	public RequestResult create(ItemsTypeDto itemsType) {
		ItemsType item = BeanUtils.createBeanByTarget(itemsType, ItemsType.class); 
		itemsTypeDao.insert(item);
		return new RequestResult(true, "保存成功！"); 
	}

	@Override
	public PageResult<ItemsTypeDto> findAll(PageQuery page) {
		List<ItemsType> results = itemsTypeDao.findAll(page);
		if(CollectionUtils.isEmpty(results)) {
			 return new PageResult<ItemsTypeDto>();
		}
		List<ItemsTypeDto> dtoResults = BeanUtils.createBeanListByTarget(results, ItemsTypeDto.class);
		int total = itemsTypeDao.countAll();
		page.setTotal(total);
		return new PageResult<ItemsTypeDto>(page, dtoResults);
	}

	@Override
	@Transactional
	public RequestResult deleteByTypeId(String typeId) {
		itemsTypeDao.logicDeleteById(typeId);
		List<ItemsTypeProperties> properties = itemsTypePropertiesDao.findByItemsTypeId(typeId);
		if(CollectionUtils.isNotEmpty(properties)) {
			 for(ItemsTypeProperties property : properties) {
				 itemsTypePropertiesDao.logicDeleteById(property.getId());
			 }
		}
		return new RequestResult(true, "删除成功！");
	}

}
