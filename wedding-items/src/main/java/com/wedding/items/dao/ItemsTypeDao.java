package com.wedding.items.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Getter;

import com.wedding.common.constants.DataStatus;
import com.wedding.common.model.PageQuery;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.items.mapper.ItemsTypeMapper;
import com.wedding.items.pojo.ItemsType;
import com.wedding.items.pojo.ItemsTypeExample;

@Repository
public class ItemsTypeDao extends MyBatisBaseDao<ItemsType> {

	@Autowired
	@Getter
	private ItemsTypeMapper mapper;
	
	public List<ItemsType> findAll(PageQuery page) {
		ItemsTypeExample example = new ItemsTypeExample();
		ItemsTypeExample.Criteria criteria = example.createCriteria();
		criteria.andStatEqualTo(DataStatus.ENABLED);
		example.setOrderByClause(" create_time desc limit " + page.getStartNum() + ", " + page.getPageSize());
		return mapper.selectByExample(example);
	}
	
	public Integer countAll() {
		ItemsTypeExample example = new ItemsTypeExample();
		ItemsTypeExample.Criteria criteria = example.createCriteria();
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return mapper.countByExample(example);
	}

	public void logicDeleteById(String typeId) {
		ItemsType type = new ItemsType();
		type.setStat(0);
		ItemsTypeExample example = new ItemsTypeExample();
		ItemsTypeExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(typeId);
		mapper.updateByExampleSelective(type, example);
	}
	
}
