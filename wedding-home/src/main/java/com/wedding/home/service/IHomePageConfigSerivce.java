package com.wedding.home.service;

import java.util.List;
import java.util.Map;
import com.wedding.home.dto.PageData;


public interface IHomePageConfigSerivce {

	Map<String, List<PageData>> findAll();
	
	List<PageData> findByKey(String key);
}
