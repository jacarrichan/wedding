package com.wedding.items.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.common.model.ListResult;
import com.wedding.common.model.RequestResult;
import com.wedding.common.util.BeanUtils;
import com.wedding.common.util.StringUtils;
import com.wedding.items.constants.ItemsPropertyTypeEnum;
import com.wedding.items.dao.ItemsTypePropertiesDao;
import com.wedding.items.dto.ItemsTypePropertiesDto;
import com.wedding.items.pojo.ItemsTypeProperties;
import com.wedding.items.service.IItemsTypePropertiesService;

@Service("itemsTypePropertiesService")
public class ItemsTypePropertiesServiceImpl implements IItemsTypePropertiesService {
	
	@Autowired
	private ItemsTypePropertiesDao propertiesDao;

	@Override
	public ListResult<ItemsTypePropertiesDto> findByItemsTypeId(String itemTypeId) {
		List<ItemsTypeProperties> properties = propertiesDao.findByItemsTypeId(itemTypeId);
		if(CollectionUtils.isEmpty(properties)){
			return new ListResult<ItemsTypePropertiesDto>();
		}
		List<ItemsTypePropertiesDto> propertiesDto = BeanUtils.createBeanListByTarget(properties, ItemsTypePropertiesDto.class);
		for(ItemsTypePropertiesDto property : propertiesDto){
			property.setPropertyTypeName(ItemsPropertyTypeEnum.getName(property.getPropertyType()));
		}
		
		return new ListResult<ItemsTypePropertiesDto>(propertiesDto);
	}

	@Override
	public RequestResult saveOrUpdateProperty(ItemsTypePropertiesDto propertyDto) {
		ItemsTypeProperties property = BeanUtils.createBeanByTarget(propertyDto, ItemsTypeProperties.class);
		if(StringUtils.isEmpty(propertyDto.getId())) {
			save(propertyDto, property);
		} else {
			update(propertyDto, property);
		}
		return new RequestResult(true, "保存成功！");
	}

	@Override
	public RequestResult deleteById(String id) {
		propertiesDao.logicDeleteById(id);
		return new RequestResult(true, "删除成功！");
	}
	
	private void update(ItemsTypePropertiesDto propertyDto, ItemsTypeProperties property) {
		if(StringUtils.isNotEmpty(propertyDto.getPropertyTypeName())) {
			property.setPropertyType(ItemsPropertyTypeEnum.getType(propertyDto.getPropertyTypeName()));
		}
		propertiesDao.updateByPrimaryKeySelective(property);		
	}

	private void save(ItemsTypePropertiesDto propertyDto,
			ItemsTypeProperties property) {
		if(StringUtils.isNotEmpty(propertyDto.getPropertyTypeName())) {
			property.setPropertyType(ItemsPropertyTypeEnum.getType(propertyDto.getPropertyTypeName()));
		}
		propertiesDao.insertSelective(property);
	}

}
