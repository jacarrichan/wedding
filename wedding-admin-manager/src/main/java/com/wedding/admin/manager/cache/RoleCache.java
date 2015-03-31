package com.wedding.admin.manager.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.wedding.admin.manager.dao.RoleDao;
import com.wedding.admin.manager.pojo.Role;
import com.wedding.admin.manger.dto.RoleDto;
import com.wedding.common.util.BeanUtils;

@Service
public class RoleCache {
	
	@Autowired
	private RoleDao roleDao;

	private LoadingCache<String, RoleDto> roleCache = CacheBuilder.newBuilder().build(
			
			new CacheLoader<String, RoleDto>() {										
					
					public RoleDto load(String key){
					       return createArea(key);
					}

					private RoleDto createArea(String key) {
						Role role = roleDao.selectByPrimaryKey(key);
						return BeanUtils.createBeanByTarget(role, RoleDto.class);
					}
				}
			);
	
	public RoleDto get(String key){
		return roleCache.getUnchecked(key);
	}
}
