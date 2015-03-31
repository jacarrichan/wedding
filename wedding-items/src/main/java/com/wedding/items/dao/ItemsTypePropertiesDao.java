package com.wedding.items.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wedding.common.constants.DataStatus;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.items.mapper.ItemsTypePropertiesMapper;
import com.wedding.items.pojo.ItemsTypeProperties;
import com.wedding.items.pojo.ItemsTypePropertiesExample;

@Repository
public class ItemsTypePropertiesDao extends MyBatisBaseDao<ItemsTypeProperties>  {

	@Getter
	@Autowired
	private ItemsTypePropertiesMapper mapper;
	
	public List<ItemsTypeProperties> findByItemsTypeId(String itemsTypeId) {
		ItemsTypePropertiesExample example = new ItemsTypePropertiesExample();
		ItemsTypePropertiesExample.Criteria criteria = example.createCriteria();
		criteria.andItemsTypeIdEqualTo(itemsTypeId);
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.selectByExample(example);
	}

	public void logicDeleteById(String id) {
		ItemsTypePropertiesExample example = new ItemsTypePropertiesExample();
		ItemsTypePropertiesExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		ItemsTypeProperties property = new ItemsTypeProperties();
		property.setStat(0);
		mapper.updateByExampleSelective(property, example);
	}
	
}
