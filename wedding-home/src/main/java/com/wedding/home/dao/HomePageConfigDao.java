package com.wedding.home.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wedding.common.constants.DataStatus;
import com.wedding.common.mybatis.MyBatisBaseDao;
import com.wedding.home.mapper.HomePageConfigMapper;
import com.wedding.home.pojo.HomePageConfig;
import com.wedding.home.pojo.HomePageConfigExample;

@Repository
public class HomePageConfigDao extends MyBatisBaseDao<HomePageConfig> {
	
	@Autowired
	@Getter
	private HomePageConfigMapper mapper;

	public List<HomePageConfig> findAll() {
		HomePageConfigExample example = new HomePageConfigExample();
		HomePageConfigExample.Criteria criteria = example.createCriteria();		
		criteria.andStatEqualTo(DataStatus.ENABLED);
		example.setOrderByClause(" order_tag asc ");
		return mapper.selectByExample(example);
	}

	public List<HomePageConfig> findByKey(String key) {
		HomePageConfigExample example = new HomePageConfigExample();
		HomePageConfigExample.Criteria criteria = example.createCriteria();	
		criteria.andDataKeyEqualTo(key);
		criteria.andStatEqualTo(DataStatus.ENABLED);
		example.setOrderByClause(" order_tag asc ");
		return mapper.selectByExample(example);
	}
	
}
