package com.wedding.home.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.wedding.common.util.JsonUtil;
import com.wedding.common.util.StringUtils;
import com.wedding.home.dao.HomePageConfigDao;
import com.wedding.home.dto.PageData;
import com.wedding.home.pojo.HomePageConfig;
import com.wedding.home.service.IHomePageConfigSerivce;

@Service
public class HomePageConfigSerivceImpl implements IHomePageConfigSerivce {

	@Autowired
	private HomePageConfigDao configDao;
	
	@Override
	public Map<String, List<PageData>> findAll() {
		List<HomePageConfig> all = configDao.findAll();
		if(CollectionUtils.isEmpty(all)) {
			return null;
		}
		Map<String, List<PageData>> results = new HashMap<String, List<PageData>>();
		for(HomePageConfig config : all) {
			List<PageData> list = createIfAbsent(config.getDataKey(), results);
			PageData data = createPageData(config.getDataValue());
			list.add(data);
		}
		return results;
	}
	
	@Override
	public List<PageData> findByKey(String key) {
		List<HomePageConfig> all = configDao.findByKey(key);
		List<PageData> reuslts = new ArrayList<>();
		for(HomePageConfig config : all) {
			PageData data = createPageData(config.getDataValue());
			reuslts.add(data);
		}
		return reuslts;
	}


	private List<PageData> createIfAbsent(String key, Map<String, List<PageData>> results) {
		List<PageData> list = results.get(key);
		if(CollectionUtils.isEmpty(list)) {
			list = new ArrayList<PageData>();
			results.put(key, list);
		}
		return list;
	}

	private PageData createPageData(String value) {
		if(StringUtils.isEmpty(value)) {
			return null;
		}
		return JsonUtil.getObjFromJson(value, PageData.class);
	}

}
