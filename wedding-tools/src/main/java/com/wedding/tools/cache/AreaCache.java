package com.wedding.tools.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.wedding.common.util.BeanUtils;
import com.wedding.tool.dto.AreaDto;
import com.wedding.tools.dao.AddressesDao;
import com.wedding.tools.pojo.Addresses;

@Component
public class AreaCache {
	
	@Autowired
	private AddressesDao addressesDao;

	private LoadingCache<Integer, AreaDto> areas = CacheBuilder.newBuilder().build(
			
			new CacheLoader<Integer, AreaDto>() {										
					
					public AreaDto load(Integer key){
					       return createArea(key);
					}

					private AreaDto createArea(Integer key) {
						Addresses address = addressesDao.findId(key);
						return BeanUtils.createBeanByTarget(address, AreaDto.class);
					}
				}
			);
	
	public AreaDto get(Integer key){
		return areas.getUnchecked(key);
	}
	
	public String findNameById(Integer key) {
		AreaDto areaDto = areas.getUnchecked(key);
		return areaDto != null ? areaDto.getName() : null;
	}
}
